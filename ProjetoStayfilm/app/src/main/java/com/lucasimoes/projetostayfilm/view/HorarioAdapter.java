package com.lucasimoes.projetostayfilm.view;

import android.app.Activity;
import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.lucasimoes.projetostayfilm.R;
import com.lucasimoes.projetostayfilm.model.Item;
import com.lucasimoes.projetostayfilm.model.ItemDao;

public class HorarioAdapter extends BaseAdapter {
    private ItemDao dao;
    private SparseArray<Long> mapa;
    private Activity parent;

    public HorarioAdapter (Activity activity, ItemDao dao){
        this.parent = activity;
        this.dao = dao;

        criaMapa();
    }
    @Override
    public void notifyDataSetChanged() {
        criaMapa();
        super.notifyDataSetChanged();
    }

    private void criaMapa() {
        mapa = new SparseArray();
        int id = 0;

        for (Item obj : dao.listar()) {
            mapa.put(id++, obj.getId());
        }
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
    public long getItemId(int lin) {
        return mapa.get(lin);
    }

    @Override
    public View getView(int lin, View viewObj, ViewGroup parent) {
        ConstraintLayout layout;

        if (viewObj == null){
            Context ctx = parent.getContext();
            layout = new ConstraintLayout(ctx);
            LayoutInflater service = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            service.inflate(R.layout.activity_horarioadapter, layout, true);
        } else{
            layout = (ConstraintLayout) viewObj;
        }

        Item obj = dao.localizar(mapa.get(lin));
        TextView hora  = (TextView) layout.findViewById(R.id.txtHorario);
        hora.setText(obj.getHorario().toString());

        return layout;
    }
}
