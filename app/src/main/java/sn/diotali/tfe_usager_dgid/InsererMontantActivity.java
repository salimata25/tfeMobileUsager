package sn.diotali.tfe_usager_dgid;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import sn.diotali.tfe_usager_dgid.types.Timbre;
import sn.diotali.tfe_usager_dgid.types.TransactionRequest;
import sn.diotali.tfe_usager_dgid.utils.Constants;

public class InsererMontantActivity extends AppCompatActivity {

    private TextView txt_libelle;
    private Button btn_achat_valider;
    private ImageView menu_bar;
    private EditText txt_montant;
    private String libelle = "";
    private int montant = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inserer_montant);

        Constants.newTransaction = new TransactionRequest();
        Constants.newTransaction.setTransactionType(Constants.Menu.TIMBRE);

        libelle = getIntent().getExtras().getString("libelle");

        txt_montant = findViewById(R.id.montant);


        //txt_libelle = findViewById(R.id.libelle);
        //txt_libelle.setText(libelle);

        menu_bar = findViewById(R.id.menu_bar);

        menu_bar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                //Creating the instance of PopupMenu
                PopupMenu popup = new PopupMenu(InsererMontantActivity.this, menu_bar);
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

        btn_achat_valider = findViewById(R.id.btn_achat_valider);

        btn_achat_valider.setOnClickListener(new ClickTfeButton());

    }

    private class ClickTfeButton implements Button.OnClickListener {

        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.btn_achat_valider : {

                    Intent intent = new Intent(getApplicationContext(), ModePaiementActivity.class);
                    startActivity(intent);
                }


            }
        }
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        try {
            switch(resultCode){
                case Constants.ResponseActivty.OK :{
                    switch(requestCode){
                        case Constants.ActivityRequest.PRINT_CHOICE :{
                            Intent intent = new Intent(this,ValidationAchatTimbreActivity.class);
                            startActivityForResult(intent,Constants.ActivityRequest.FINAL_DISPLAY);
                            break;
                        }

                    }

                }
                case Constants.ResponseActivty.NOK :{
                    switch(requestCode){
                        case Constants.ActivityRequest.RECAPITULATIF :{

                            break;
                        }
                        case Constants.ActivityRequest.PRINT_CHOICE :{

                            break;
                        }
                        case Constants.ActivityRequest.FINAL_DISPLAY:{

                            break;
                        }
                    }
                }
                default:{
                    switch (requestCode) {
                        case Constants.ActivityRequest.FINAL_DISPLAY: {
                            break;
                        }
                    }
                }
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
