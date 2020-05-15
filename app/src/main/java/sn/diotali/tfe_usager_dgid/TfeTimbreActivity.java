package sn.diotali.tfe_usager_dgid;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupMenu;

import java.util.ArrayList;
import java.util.List;

import sn.diotali.tfe_usager_dgid.types.Timbre;
import sn.diotali.tfe_usager_dgid.types.TransactionRequest;
import sn.diotali.tfe_usager_dgid.utils.Constants;

public class TfeTimbreActivity extends AppCompatActivity {

    private Button btn_timbre_1000;
    private Button btn_timbre_2000;
    private Button btn_timbre_5000;
    private Button btn_timbre_10000;
    ImageView menu_bar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tfe_timbre);

        Constants.newTransaction = new TransactionRequest();
        Constants.newTransaction.setTransactionType(Constants.Menu.TIMBRE);

        menu_bar = findViewById(R.id.menu_bar);

        menu_bar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                //Creating the instance of PopupMenu
                PopupMenu popup = new PopupMenu(TfeTimbreActivity.this, menu_bar);
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

        btn_timbre_1000 = findViewById(R.id.choix_timbre_1000);
        btn_timbre_2000 = findViewById(R.id.choix_timbre_2000);
        btn_timbre_5000 = findViewById(R.id.choix_timbre_5000);
        btn_timbre_10000 = findViewById(R.id.choix_timbre_10000);

        btn_timbre_1000.setOnClickListener(new ClickTfeButton());
        btn_timbre_2000.setOnClickListener(new ClickTfeButton());
        btn_timbre_5000.setOnClickListener(new ClickTfeButton());
        btn_timbre_10000.setOnClickListener(new ClickTfeButton());


        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);

    }

    private class ClickTfeButton implements Button.OnClickListener {

        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.choix_timbre_1000 : {

                    int nb1000 = 1;
                    int nb2000 = 0;
                    int nb5000 = 0;
                    int nb10000 = 0;
                    int nb = nb1000+nb2000+nb5000+nb10000;
                    if(nb>0){

                        List<Timbre> panierTimbres = new ArrayList<>();
                        panierTimbres.add(new Timbre("Timbre quotite", "Timbre 1000", 1000, nb1000));
                        panierTimbres.add(new Timbre("Timbre quotite", "Timbre 2000", 2000, nb2000));
                        panierTimbres.add(new Timbre("Timbre quotite", "Timbre 5000", 5000, nb5000));
                        panierTimbres.add(new Timbre("Timbre quotite", "Timbre 10000", 10000, nb10000));

                        Constants.newTransaction.setPanierTimbres(panierTimbres);

                    }

                    break;
                }
                case R.id.choix_timbre_2000 : {

                    int nb1000 = 0;
                    int nb2000 = 1;
                    int nb5000 = 0;
                    int nb10000 = 0;
                    int nb = nb1000+nb2000+nb5000+nb10000;
                    if(nb>0){

                        List<Timbre> panierTimbres = new ArrayList<>();
                        panierTimbres.add(new Timbre("Timbre quotite", "Timbre 1000", 1000, nb1000));
                        panierTimbres.add(new Timbre("Timbre quotite", "Timbre 2000", 2000, nb2000));
                        panierTimbres.add(new Timbre("Timbre quotite", "Timbre 5000", 5000, nb5000));
                        panierTimbres.add(new Timbre("Timbre quotite", "Timbre 10000", 10000, nb10000));

                        Constants.newTransaction.setPanierTimbres(panierTimbres);

                    }

                    break;
                }
                case R.id.choix_timbre_5000 : {

                    int nb1000 = 0;
                    int nb2000 = 0;
                    int nb5000 = 1;
                    int nb10000 = 0;
                    int nb = nb1000+nb2000+nb5000+nb10000;
                    if(nb>0){

                        List<Timbre> panierTimbres = new ArrayList<>();
                        panierTimbres.add(new Timbre("Timbre quotite", "Timbre 1000", 1000, nb1000));
                        panierTimbres.add(new Timbre("Timbre quotite", "Timbre 2000", 2000, nb2000));
                        panierTimbres.add(new Timbre("Timbre quotite", "Timbre 5000", 5000, nb5000));
                        panierTimbres.add(new Timbre("Timbre quotite", "Timbre 10000", 10000, nb10000));

                        Constants.newTransaction.setPanierTimbres(panierTimbres);

                    }

                    break;
                }
                case R.id.choix_timbre_10000 : {

                    int nb1000 = 0;
                    int nb2000 = 0;
                    int nb5000 = 0;
                    int nb10000 = 1;
                    int nb = nb1000+nb2000+nb5000+nb10000;
                    if(nb>0){

                        List<Timbre> panierTimbres = new ArrayList<>();
                        panierTimbres.add(new Timbre("Timbre quotite", "Timbre 1000", 1000, nb1000));
                        panierTimbres.add(new Timbre("Timbre quotite", "Timbre 2000", 2000, nb2000));
                        panierTimbres.add(new Timbre("Timbre quotite", "Timbre 5000", 5000, nb5000));
                        panierTimbres.add(new Timbre("Timbre quotite", "Timbre 10000", 10000, nb10000));

                        Constants.newTransaction.setPanierTimbres(panierTimbres);

                    }

                    break;
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
