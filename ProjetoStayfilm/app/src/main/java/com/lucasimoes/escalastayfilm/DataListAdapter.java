package com.lucasimoes.escalastayfilm;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.lucasimoes.escalastayfilm.model.Datas;
import com.lucasimoes.escalastayfilm.model.Horarios;

import java.util.List;

public class DataListAdapter extends RecyclerView.Adapter<DataListAdapter.ViewHolder> {



    private List<Datas> mDatas;
    private List<Horarios> mHorarios;
    private Context mContext;

    public DataListAdapter (Context context, List<Datas> mDatas, List<Horarios> mHorarios){
        this.mContext = context;
        this.mDatas = mDatas;
        this.mHorarios = mHorarios;
    }

    @Override
    public DataListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.datas_layout, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(DataListAdapter.ViewHolder holder, int position) {
        Datas datas = mDatas.get(position);
        holder.txtData.setText(datas.getData());

        Horarios horarios = mHorarios.get(position);

        if (horarios.isBloqueado()){
            holder.llBloqueado.setVisibility(View.VISIBLE);
            holder.txtBloqueado.setText(horarios.getHorario());
        }else{
            holder.llLiberado.setVisibility(View.VISIBLE);
            holder.txtLiberado.setText(horarios.getHorario());
        }
    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView txtData;
        public TextView txtBloqueado;
        public TextView txtLiberado;

        public LinearLayout llBloqueado;
        public LinearLayout llLiberado;

        public ViewHolder (View view){
            super(view);

            txtData = (TextView)view.findViewById(R.id.info_text);
            txtBloqueado = (TextView)view.findViewById(R.id.txt_horarioBolqueado);
            txtLiberado = (TextView)view.findViewById(R.id.txt_horarioLiberado);

            llBloqueado = (LinearLayout)view.findViewById(R.id.LLBloqueado);
            llBloqueado.setVisibility(View.INVISIBLE);
            llLiberado = (LinearLayout)view.findViewById(R.id.LLLiberado);
            llLiberado.setVisibility(View.INVISIBLE);

            llBloqueado.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(mContext, "Período de Folga, Aproveite!", Toast.LENGTH_SHORT).show();
                }
            });

            llLiberado.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(mContext, "Período de trabalho, não se atrase!", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}
