package sn.diotali.tfe_usager_dgid;

import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.text.NumberFormat;
import java.util.List;

import sn.diotali.tfe_usager_dgid.types.Timbre;
import sn.diotali.tfe_usager_dgid.utils.Constants;

public class DetailsTimbreActivity extends AppCompatActivity {
    List<Timbre> panierTimbres;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_timbre);
        ImageView btnNext =  findViewById(R.id.btn_suivant);
        ImageView btnReturn =  findViewById(R.id.btn_return);
        btnNext.setOnClickListener(new DetailsButton());
        btnReturn.setOnClickListener(new DetailsButton());
        TableLayout table = findViewById(R.id.table_recap);

        panierTimbres = Constants.newTransaction.getPanierTimbres();
        Log.d("panierTimbre",panierTimbres.toString());
        fillTableRecap(table,panierTimbres);
    }

    private String formatMoney(int amount){
        NumberFormat formattter = NumberFormat.getNumberInstance();
        return  formattter.format(amount);
    }

    private void fillTableRecap(TableLayout tableRecap,List<Timbre> panierTimbres){
        int sum;
        try {
            TableLayout.LayoutParams trParams = new TableLayout.LayoutParams(0, TableLayout.LayoutParams.MATCH_PARENT);
            TableRow.LayoutParams firstParams = new TableRow.LayoutParams(0,TableRow.LayoutParams.WRAP_CONTENT, 1.54f);
            TableRow.LayoutParams txtParamssec = new TableRow.LayoutParams(0,TableRow.LayoutParams.WRAP_CONTENT, 1.1f);
            TableRow.LayoutParams totalPrms = new TableRow.LayoutParams(0,TableRow.LayoutParams.WRAP_CONTENT, 1.1f);
            totalPrms.setMargins(20,0,0,0);
            int layout = getResources().getConfiguration().screenLayout;

            if((layout&Configuration.SCREENLAYOUT_SIZE_XLARGE) == Configuration.SCREENLAYOUT_SIZE_XLARGE){
                trParams = new TableLayout.LayoutParams(0, TableLayout.LayoutParams.MATCH_PARENT);
                firstParams = new TableRow.LayoutParams(0,TableRow.LayoutParams.WRAP_CONTENT, 1.75f);
                firstParams.setMargins(20,0,0,0);
                txtParamssec = new TableRow.LayoutParams(0,TableRow.LayoutParams.WRAP_CONTENT, 1.25f);
            }

            sum = 0;

            for (int i = 0;i<panierTimbres.size();i++) {
                TableRow row = new TableRow(this);
                int  total = panierTimbres.get(i).getQuantite()*panierTimbres.get(i).getPrixU();
                sum += total;
                String quantite = formatMoney(panierTimbres.get(i).getQuantite());
                String pTotal = formatMoney(total);
                String timbre = formatMoney(panierTimbres.get(i).getPrixU()) + " XOF";
                if (total != 0) {
                    TextView viewTimbre = new TextView(this);
                    TextView viewQuantite = new TextView(this);
                    TextView viewTotal = new TextView(this);
                    Log.d("SDK_INT", "" + Build.VERSION.SDK_INT);
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        row.setBackgroundColor(getResources().getColor(R.color.colorWhite));
                        viewTimbre.setBackground(getDrawable(R.drawable.divider));
                        viewQuantite.setBackground(getDrawable(R.drawable.divider));
                        viewTotal.setBackground(getDrawable(R.drawable.divider));
                    } else {
                        row.setBackgroundColor(getResources().getColor(R.color.colorWhite));
                        viewTimbre.setBackground(getResources().getDrawable(R.drawable.divider));
                        viewQuantite.setBackground(getResources().getDrawable(R.drawable.divider));
                        viewTotal.setBackground(getResources().getDrawable(R.drawable.divider));
                    }
                    viewTimbre.setLayoutParams(firstParams);
                    viewQuantite.setLayoutParams(txtParamssec);
                    viewTotal.setLayoutParams(txtParamssec);

                    viewTimbre.setGravity(Gravity.END);
                    viewQuantite.setGravity(Gravity.END);
                    viewTotal.setGravity(Gravity.END);

                    viewTimbre.setPadding(0, 0, 10, 0);
                    viewQuantite.setPadding(0, 0, 10, 0);
                    viewTotal.setPadding(0, 0, 10, 0);

                    viewTimbre.setText(timbre);
                    viewTimbre.setTextSize(18);

                    viewQuantite.setText(quantite);
                    viewQuantite.setTextSize(18);

                    viewTotal.setText(pTotal);
                    viewTotal.setTextSize(18);

                    row.addView(viewTimbre);
                    row.addView(viewQuantite);
                    row.addView(viewTotal);
                    tableRecap.addView(row, trParams);
                }
            }
            if (sum > 0) {
                TableRow row = new TableRow(this);
                TextView viewTotal = new TextView(this);
                TextView viewAmount = new TextView(this);

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    row.setBackgroundColor(getResources().getColor(R.color.colorWhite));
                    viewTotal.setBackground(getDrawable(R.drawable.divider));
                    viewAmount.setBackground(getDrawable(R.drawable.divider));

                } else {
                    row.setBackgroundColor(getResources().getColor(R.color.colorWhite));
                    viewTotal.setBackground(getResources().getDrawable(R.drawable.divider));
                    viewAmount.setBackground(getResources().getDrawable(R.drawable.divider));
                }
                //
                TableRow.LayoutParams totalParams = new TableRow.LayoutParams(0,TableRow.LayoutParams.WRAP_CONTENT, 2.64f);
                viewTotal.setLayoutParams(totalParams);
                viewAmount.setLayoutParams(txtParamssec);

                viewAmount.setGravity(Gravity.END);
                viewTotal.setGravity(Gravity.END);

                viewTotal.setPadding(0, 0, 10, 0);
                viewAmount.setPadding(0, 0, 10, 0);
                viewTotal.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
                viewAmount.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
                viewTotal.setText(R.string.total);
                viewTotal.setTextSize(20);
                viewAmount.setText(formatMoney(sum));
                viewAmount.setTextSize(20);
                row.addView(viewTotal);
                //
                row.addView(viewAmount);
                tableRecap.addView(row);
            }
        }
        catch (NullPointerException e) {
            e.printStackTrace();
        }
    }
    private class DetailsButton implements Button.OnClickListener {

        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.btn_suivant: {
                    Constants.newTransaction.setPanierTimbres(panierTimbres);
                    Intent intent = new Intent();
                    setResult(Constants.ResponseActivty.OK,intent);
                    finish();
                    break;
                }
                case R.id.btn_return: {
                    Intent intent = new Intent();
                    setResult(Constants.ResponseActivty.NOK,intent);
                    finish();
                    break;
                }
            }
        }
    }
}
