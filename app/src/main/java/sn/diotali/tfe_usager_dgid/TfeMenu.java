package sn.diotali.tfe_usager_dgid;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.menu.MenuPopupHelper;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupMenu;

import java.lang.reflect.Field;

public class TfeMenu extends AppCompatActivity {

    ImageView tfe_menu_timbre, menu_autres;
    ImageView tfe_menu_quittance, menu_bar, menu_info;
    private Intent intent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tfe_menu);

        getObjectById();

        menu_bar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                //Creating the instance of PopupMenu
                PopupMenu popup = new PopupMenu(TfeMenu.this, menu_bar);
                
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

        tfe_menu_timbre.setOnClickListener(onButtonClickListener);
        tfe_menu_quittance.setOnClickListener(onButtonClickListener);
        menu_autres.setOnClickListener(onButtonClickListener);
        menu_info.setOnClickListener(onButtonClickListener);
    }

    private View.OnClickListener onButtonClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){

                case R.id.tfe_menu_timbre:
                    intent = new Intent (getApplicationContext(), TfeTimbreActivity.class);
                    startActivity(intent);
                    break;

                case R.id.tfe_menu_quittance:
                    intent = new Intent (getApplicationContext(), TfeQuittanceActivity.class);
                    startActivity(intent);
                    break;

                case R.id.menu_autres:
                    intent = new Intent (getApplicationContext(), AutreMontantActivity.class);
                    startActivity(intent);
                    break;

                case R.id.menu_info:
                    intent = new Intent (getApplicationContext(), HistoriqueActivity.class);
                    startActivity(intent);
                    break;
            }
        }
    };


    @Override
    public void onBackPressed() {
        Intent intent = new Intent(getApplicationContext(), DiotaliLogin.class);
        startActivity(intent);
        finish();
    }

    public void getObjectById(){
        tfe_menu_timbre = (ImageView)findViewById(R.id.tfe_menu_timbre);
        tfe_menu_quittance = (ImageView)findViewById(R.id.tfe_menu_quittance);
        menu_autres = findViewById(R.id.menu_autres);
        menu_bar = findViewById(R.id.menu_bar);
        menu_info = findViewById(R.id.menu_info);
    }

}
