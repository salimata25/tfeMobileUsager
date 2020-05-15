package sn.diotali.tfe_usager_dgid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class InscriptionActivity extends AppCompatActivity {
    Button btn_valider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inscription);

        btn_valider = findViewById(R.id.btn_valider);
        btn_valider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(InscriptionActivity.this, CodeSmsActivity.class);
                startActivity(intent);
            }
        });
    }
}
