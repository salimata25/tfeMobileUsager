package sn.diotali.tfe_usager_dgid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class ModePaiementActivity extends AppCompatActivity {

    ImageView btn_omoney;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mode_paiement);

        btn_omoney = findViewById(R.id.btn_omoney);
        btn_omoney.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ModePaiementActivity.this, PaiementMobileActivity.class);
                startActivity(intent);
            }
        });
    }
}
