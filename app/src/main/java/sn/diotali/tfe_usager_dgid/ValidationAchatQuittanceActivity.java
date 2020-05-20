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
import java.util.Locale;

import sn.diotali.tfe_usager_dgid.services.ServiceParams;
import sn.diotali.tfe_usager_dgid.services.ServiceResult;
import sn.diotali.tfe_usager_dgid.services.ServicesTask;
import sn.diotali.tfe_usager_dgid.types.TransactionResponse;
import sn.diotali.tfe_usager_dgid.utils.Constants;


/**
 * Created by Cheikhouna on 27/02/2018.
 */

public class ValidationAchatQuittanceActivity extends DiotaliMain{
    private ImageView menu_bar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_validation_achat);

        menu_bar = findViewById(R.id.menu_bar);

        menu_bar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), NavBarActivity.class);
                startActivity(intent);
                overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
            }
        });

        Button btnValider =  (Button)findViewById(R.id.btn_achat_fe_valider);

        TextView montant_global = (TextView)findViewById(R.id.txt_montant_global);
        montant_global.setText("20.000 XOF");
        btnValider.setOnClickListener(new ValidationAchatQuittanceActivity.DetailsButton());

    }

    private class DetailsButton implements Button.OnClickListener {

        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.btn_achat_fe_valider : {
                    Intent intent = new Intent(ValidationAchatQuittanceActivity.this, ModePaiementActivity.class);
                    startActivity(intent);
                    break;
                }

            }
        }
    }

    @Override
    public void sendTaskResponse(ServiceResult serviceResult) {
        try {
            String ticketInfos[] =new String[11];
            if(Constants.ResponseStatus.OK == serviceResult.getStatus()){
                TransactionResponse response = (TransactionResponse) serviceResult;

                String jourAttestation = new SimpleDateFormat("dd-MM-yyyy", Locale.FRENCH).format(response.getTransactionDate());
                String heurAttestation = new SimpleDateFormat("HH:mm", Locale.FRENCH).format(response.getTransactionDate());

                ticketInfos[0] = response.getNumero()+"";
                ticketInfos[1] = response.getNumeroTransaction();
                ticketInfos[2] = jourAttestation +" a " + heurAttestation;
                ticketInfos[3] = "20 000.00 FCFA";
                ticketInfos[4] = Constants.newTransaction.getInfoQuittance().getFirstName(); // Date transaction
                ticketInfos[5] = Constants.newTransaction.getInfoQuittance().getLastName(); // Date transaction
                ticketInfos[6] = Constants.newTransaction.getInfoQuittance().getPhone(); // Date transaction
                ticketInfos[7] = Constants.newTransaction.getInfoQuittance().getNin(); // Date transaction
                ticketInfos[8] = Constants.newUser.getAddress(); // Date transaction
                ticketInfos[9] = jourAttestation; // Date transaction
                ticketInfos[10] = heurAttestation; // Date transaction


                Intent intent = new Intent();
                intent.putExtra(Constants.ExtrasName.STATUS,Constants.ResponseStatus.OK);
                intent.putExtra(Constants.ExtrasName.TICKET_INFOS, ticketInfos);
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
