package sn.diotali.tfe_usager_dgid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import sn.diotali.tfe_usager_dgid.types.OneTimbrePanier;
import sn.diotali.tfe_usager_dgid.utils.HistoriqueListAdapter;

public class HistoriqueActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historique);

        List<OneTimbrePanier> listTimbre = getLisData();
        ListView list_timbre = findViewById(R.id.list_timbre);
        list_timbre.setAdapter(new HistoriqueListAdapter(this, listTimbre));
        list_timbre.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getApplicationContext(), InfoTimbreActivity.class);
                startActivity(intent);
            }
        });
    }

    private List<OneTimbrePanier> getLisData() {
        List<OneTimbrePanier> list = new ArrayList<OneTimbrePanier>();
        Date date = new Date();

        OneTimbrePanier timbre1 = new OneTimbrePanier("consommé", "Quittance", 20000, date);
        OneTimbrePanier timbre2 = new OneTimbrePanier("non consommé", "Timbre fiscal", 5000, date);
        OneTimbrePanier timbre3 = new OneTimbrePanier("consommé", "Autre montant", 200000, date);

        list.add(timbre1);
        list.add(timbre2);
        list.add(timbre3);

        return list;
    }
}
