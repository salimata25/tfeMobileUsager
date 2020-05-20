package sn.diotali.tfe_usager_dgid;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupMenu;

import sn.diotali.tfe_usager_dgid.utils.Constants;

public class DetailsQuittanceActivity extends AppCompatActivity {

    ImageView btnSuivant;
    ImageView btnRetour, menu_bar;

    /*TextView firstName;
    TextView lastName;
    TextView phone;
    TextView nin;*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_quittance);

        getEllementsById();

       // Quittance quittance = Constants.newTransaction.getInfoQuittance();

        btnSuivant.setOnClickListener(new DetailsButton());
        //btnRetour.setOnClickListener(new DetailsButton());
        menu_bar = findViewById(R.id.menu_bar);

        menu_bar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), NavBarActivity.class);
                startActivity(intent);
                overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
            }
        });

        /*firstName.setText(quittance.getFirstName());
        lastName.setText(quittance.getLastName());
        phone.setText(quittance.getPhone());
        nin.setText(quittance.getNin());*/
    }

    private class DetailsButton implements Button.OnClickListener {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.detail_btn_suivant : {

                    Intent intent = new Intent(DetailsQuittanceActivity.this, ValidationAchatQuittanceActivity.class);
                    startActivity(intent);
                    //Intent intent = new Intent();
                    //setResult(Constants.ResponseActivty.OK,intent);
                    //finish();
                    break;
                }

            }
        }
    }

    public void getEllementsById(){
        btnSuivant = findViewById(R.id.detail_btn_suivant);
        //btnRetour = findViewById(R.id.detail_btn_return);

        /*firstName = (TextView) findViewById(R.id.detail_tvFirstName);
        lastName = (TextView) findViewById(R.id.detail_tvLastName);
        phone = (TextView) findViewById(R.id.detail_tvPhone);
        nin = (TextView) findViewById(R.id.detail_tvNin);*/
    }

}
