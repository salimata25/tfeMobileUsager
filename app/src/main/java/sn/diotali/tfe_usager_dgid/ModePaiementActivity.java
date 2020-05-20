package sn.diotali.tfe_usager_dgid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class ModePaiementActivity extends AppCompatActivity implements View.OnClickListener{

    ImageView btn_omoney;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mode_paiement);

        btn_omoney = findViewById(R.id.btn_omoney);
        btn_omoney.setOnClickListener(this);
        findViewById(R.id.menu_bar).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_omoney:
                Intent intent = new Intent(ModePaiementActivity.this, PaiementMobileActivity.class);
                startActivity(intent);
                break;
            case R.id.menu_bar:
                intent = new Intent(getApplicationContext(), NavBarActivity.class);
                startActivity(intent);
                overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
                break;
        }
    }
}
