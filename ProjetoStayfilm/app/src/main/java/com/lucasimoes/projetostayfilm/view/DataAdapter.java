package com.lucasimoes.projetostayfilm.view;

import android.app.Activity;
import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.lucasimoes.projetostayfilm.R;
import com.lucasimoes.projetostayfilm.model.Dao;
import com.lucasimoes.projetostayfilm.model.Data;
import com.lucasimoes.projetostayfilm.model.DataDao;

public class DataAdapter extends BaseAdapter {

    private static DataDao dao = DataDao.instancia;
    private SparseArray<Long> mapa;
    private boolean datas;
    private Activity activity;

    public DataAdapter(Activity activity, boolean datas){
        this.datas = datas;
        this.activity = activity;

        criarMapa();
    }

    public void criarMapa(){
        mapa = new SparseArray<>();
        int id = 0;

        for(Data data: dao.listar(datas)){
            mapa.put(id++, data.getId());
        }
    }

    @Override
    public void notifyDataSetChanged() {
        criarMapa();
        super.notifyDataSetChanged();
    }
    @Override
    public int getCount() {
        return mapa.size();
    }

    @Override
    public Object getItem(int id) {
        return dao.localizar(id);
    }

    @Override
    public long getItemId(int linha) {
        return mapa.get(linha);
    }

    @Override
    public View getView(int linha, View convertView, ViewGroup parent){
        ConstraintLayout layout;
        Context context = parent.getContext();
        layout = new ConstraintLayout(context);
        LayoutInflater service = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        service.inflate(R.layout.item_data, layout, true);

        Data dtas = dao.localizar(mapa.get(linha));

        TextView Titulodata = (TextView)layout.findViewById(R.id.txtData);
        Titulodata.setText(dtas.getData());


        return layout;
    }

}
