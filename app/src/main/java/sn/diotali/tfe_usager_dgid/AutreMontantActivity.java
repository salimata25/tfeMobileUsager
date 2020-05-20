package sn.diotali.tfe_usager_dgid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupMenu;

public class AutreMontantActivity extends AppCompatActivity {

    private Button btn_droit_enregistrement;
    private Button btn_mutation;
    private ImageView menu_bar;
    private String nom_timbre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_autre_montant);

        btn_droit_enregistrement = findViewById(R.id.choix_droit_enregistrement);
        btn_mutation = findViewById(R.id.choix_mutation);
        menu_bar = findViewById(R.id.menu_bar);

        menu_bar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent (getApplicationContext(), NavBarActivity.class);
                startActivity(intent);
                overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
            }
        });

        btn_droit_enregistrement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nom_timbre = "Droits d'enregistrements";
                Intent intent = new Intent(AutreMontantActivity.this, InsererMontantActivity.class);
                intent.putExtra("libelle", nom_timbre);
                startActivity(intent);
            }
        });

        btn_mutation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nom_timbre = "Mutation de véhicule";
                Intent intent = new Intent(AutreMontantActivity.this, InsererMontantActivity.class);
                intent.putExtra("libelle", nom_timbre);
                startActivity(intent);
            }
        });
    }
}
