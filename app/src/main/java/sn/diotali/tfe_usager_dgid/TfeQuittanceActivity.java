package sn.diotali.tfe_usager_dgid;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.PopupMenu;

import sn.diotali.tfe_usager_dgid.types.Quittance;
import sn.diotali.tfe_usager_dgid.types.TransactionRequest;
import sn.diotali.tfe_usager_dgid.utils.Constants;

public class TfeQuittanceActivity extends AppCompatActivity {

    ImageView menu_bar;
    ImageView btnRetour;
    Button btn_valider;
    EditText firstName;
    EditText lastName;
    EditText phone;
    EditText nin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tfe_quittance);

        getEllementsById();

        Constants.newTransaction = new TransactionRequest();
        Constants.newTransaction.setTransactionType(Constants.Menu.QUITTANCE);

        menu_bar = findViewById(R.id.menu_bar);

        menu_bar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                //Creating the instance of PopupMenu
                PopupMenu popup = new PopupMenu(TfeQuittanceActivity.this, menu_bar);
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

        btn_valider.setOnClickListener(new ClickTfeButton());
        //btnRetour.setOnClickListener(new ClickTfeButton());

    }

    private class ClickTfeButton implements Button.OnClickListener {

        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.btn_valider : {
                    /*if (firstName.getText().toString() == null || firstName.getText().toString().replaceAll(" ", "").isEmpty()) {
                        firstName.setError(getResources().getString(R.string.client_firstname));
                    } else if (lastName.getText().toString() == null || lastName.getText().toString().replaceAll(" ", "").isEmpty()) {
                        lastName.setError(getResources().getString(R.string.client_lastname));
                    } else if (phone.getText().toString() == null || phone.getText().toString().replaceAll(" ", "").isEmpty()) {
                        phone.setError(getResources().getString(R.string.client_phone));
                    } else if (nin.getText().toString() == null || nin.getText().toString().replaceAll(" ", "").isEmpty()) {
                        nin.setError(getResources().getString(R.string.client_nin));
                    }
                    else{*/


                        Intent intent = new Intent(TfeQuittanceActivity.this, DetailsQuittanceActivity.class);
                        startActivity(intent);
                    //}

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
                            Intent intent = new Intent(this,ValidationAchatQuittanceActivity.class);
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



    public void getEllementsById(){
        btn_valider = findViewById(R.id.btn_valider);
        //btnRetour = findViewById(R.id.btn_return);

        firstName = (EditText) findViewById(R.id.labelFirstName);
        lastName = (EditText) findViewById(R.id.labelLastName);
        phone = (EditText) findViewById(R.id.labelPhone);
        nin = (EditText) findViewById(R.id.labelNin);
    }

}
