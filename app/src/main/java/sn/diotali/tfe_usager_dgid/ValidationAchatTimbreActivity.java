package sn.diotali.tfe_usager_dgid;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import sn.diotali.tfe_usager_dgid.services.ServiceParams;
import sn.diotali.tfe_usager_dgid.services.ServiceResult;
import sn.diotali.tfe_usager_dgid.services.ServicesTask;
import sn.diotali.tfe_usager_dgid.types.OneTimbrePanier;
import sn.diotali.tfe_usager_dgid.types.Timbre;
import sn.diotali.tfe_usager_dgid.types.TransactionResponse;
import sn.diotali.tfe_usager_dgid.utils.Constants;


/**
 * Created by Cheikhouna on 27/02/2018.
 */

public class ValidationAchatTimbreActivity extends DiotaliMain{
    private ImageView menu_bar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_validation_achat);

        menu_bar = findViewById(R.id.menu_bar);

        menu_bar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                //Creating the instance of PopupMenu
                PopupMenu popup = new PopupMenu(ValidationAchatTimbreActivity.this, menu_bar);
                //Inflating the Popup using xml file
                popup.getMenuInflater().inflate(R.menu.menu, popup.getMenu());

                //registering popup with OnMenuItemClickListener
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.profil:
                                break;
                            case R.id.deconnect:
                                Intent intent = new Intent(getApplicationContext(), DiotaliLogin.class);
                                startActivity(intent);
                                finish();
                        }
                        return true;
                    }
                });

                popup.show();
            }
        });

        Button btnValider =  (Button)findViewById(R.id.btn_achat_fe_valider);
        //ImageView btnAnnuler =  (ImageView)findViewById(R.id.btn_achat_fe_annuler);
        TextView montant_global = (TextView)findViewById(R.id.txt_montant_global);

        TextView titre = findViewById(R.id.titre_menu);
        titre.setText("Timbre fiscal");
        List<Timbre> panierTimbresFilter = new ArrayList<>();
        int montantGlobal = 0;
        for ( Timbre timbrePanier: Constants.newTransaction.getPanierTimbres() ) {
            if(timbrePanier.getQuantite() != 0){
                montantGlobal += timbrePanier.getQuantite() * timbrePanier.getPrixU();
                panierTimbresFilter.add(timbrePanier);
            }
        }
        Constants.newTransaction.setPanierTimbres(panierTimbresFilter);
        montant_global.setText(String.valueOf(montantGlobal)+" XOF");
        TextView title_montant_global = findViewById(R.id.txt_title_montant_global);
        title_montant_global.setText(getResources().getString(R.string.timbre_fe_tittre_montant_global));

        btnValider.setOnClickListener(new ValidationAchatTimbreActivity.DetailsButton());
        //btnAnnuler.setOnClickListener(new ValidationAchatTimbreActivity.DetailsButton());
    }

    private class DetailsButton implements Button.OnClickListener {

        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.btn_achat_fe_valider : {
                    Constants.newTransaction.setToken(Constants.newUser.getToken());
                    Constants.newTransaction.setTerminalNumber(Constants.newUser.getTerminalNumber());
                    Log.i("-newTransactionDetail- ",Constants.newTransaction.toString());
                    ServicesTask service = new ServicesTask(ValidationAchatTimbreActivity.this);
                    ServiceParams method = new ServiceParams();
                    method.setMethodName(Constants.Methods.ACHETER_TIMBRE);
                    Log.d("transaction params ",Constants.newTransaction.toString());
                    method.setMethodParams(Constants.newTransaction);
                    service.execute(method);
                    break;
                }

            }
        }
    }

    @Override
    public void sendTaskResponse(ServiceResult serviceResult) {
        try {
            String ticketInfos[][] =new String[4][11];
            if(Constants.ResponseStatus.OK == serviceResult.getStatus()){
                TransactionResponse response = (TransactionResponse) serviceResult;

                Intent intent = new Intent();
                intent.putExtra(Constants.ExtrasName.STATUS,Constants.ResponseStatus.OK);
                for( int i = 0;i<response.getRespTimbres().size();i++ ) {
                    Log.d("response.getRespTimbres().get(i) "+i,response.getRespTimbres().get(i).toString());
                    Log.d("Constants.ExtrasName.TICKET_INFOS+\"\"+(i+1) "+i,Constants.ExtrasName.TICKET_INFOS+""+(i+1));

                    OneTimbrePanier oTimbre = response.getRespTimbres().get(i);

                    String jourAttestation = new SimpleDateFormat("dd-MM-yyyy", Locale.FRENCH).format(oTimbre.getTransactionDate());
                    String heurAttestation = new SimpleDateFormat("HH:mm", Locale.FRENCH).format(oTimbre.getTransactionDate());

                    ticketInfos[i][0] = oTimbre.getNumero()+"";
                    ticketInfos[i][1] = oTimbre.getNumeroTransaction();
                    ticketInfos[i][2] = jourAttestation +" a " + heurAttestation;
                    ticketInfos[i][3] = oTimbre.getPrixU()*oTimbre.getQuantite()+" FCFA";
                    ticketInfos[i][4] = Constants.newUser.getUserNumber(); // Date transaction
                    ticketInfos[i][5] = oTimbre.getType()+"-"+ oTimbre.getLibelle()+"-"+ oTimbre.getPrixU()+"-"+ oTimbre.getQuantite();
                    ticketInfos[i][6] = Constants.newUser.getAddress(); // Date transaction
                    ticketInfos[i][7] = Constants.newUser.getAddress(); // Date transaction
                    ticketInfos[i][8] = Constants.newUser.getAddress(); // Date transaction
                    ticketInfos[i][9] = jourAttestation; // Date transaction
                    ticketInfos[i][10] = heurAttestation; // Date transaction

                    intent.putExtra(Constants.ExtrasName.TICKET_INFOS+""+(i+1), ticketInfos[i]);
                }

                intent.putExtra(Constants.ExtrasName.MESSAGE,"SUCCESS");

                setResult(Constants.ResponseActivty.OK,intent);
            }
            else {
                Intent intent = new Intent();
                intent.putExtra(Constants.ExtrasName.TICKET_INFOS, ticketInfos);
                intent.putExtra(Constants.ExtrasName.STATUS,serviceResult.getStatus());
                intent.putExtra(Constants.ExtrasName.MESSAGE,serviceResult.getMessage());
                setResult(Constants.ResponseActivty.OK,intent);
            }
            finish();

        }
        catch (Exception e){
            e.printStackTrace();
        }
    }




}
