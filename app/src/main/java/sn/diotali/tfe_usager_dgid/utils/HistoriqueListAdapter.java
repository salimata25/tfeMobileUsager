package sn.diotali.tfe_usager_dgid.utils;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import sn.diotali.tfe_usager_dgid.R;
import sn.diotali.tfe_usager_dgid.types.OneTimbrePanier;

public class HistoriqueListAdapter extends BaseAdapter {

    private List<OneTimbrePanier> listData;
    private LayoutInflater layoutInflater;
    private Context context;

    public HistoriqueListAdapter(Context context, List<OneTimbrePanier> listData) {
        this.listData = listData;
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return listData.size();
    }

    @Override
    public Object getItem(int i) {
        return listData.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if (view == null) {
            view = layoutInflater.inflate(R.layout.list_item_layout, null);
            holder = new ViewHolder();
            holder.icone = view.findViewById(R.id.icone_qrcode);
            holder.libelle = view.findViewById(R.id.txt_libelle);
            holder.date = view.findViewById(R.id.txt_date);
            holder.prix = view.findViewById(R.id.txt_prix);
            holder.statut = view.findViewById(R.id.txt_statut);
            view.setTag(holder);
        }
        else {
            holder = (ViewHolder) view.getTag();
        }

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        OneTimbrePanier timbre = this.listData.get(i);
        holder.libelle.setText(timbre.getLibelle());
        holder.date.setText(format.format(timbre.getTransactionDate()) );
        holder.prix.setText(timbre.getPrixU() + " FCFA");
        holder.statut.setText(timbre.getType());

        return view;
    }

    public static class ViewHolder {
        ImageView icone;
        TextView libelle, date, prix, statut;
    }
}
