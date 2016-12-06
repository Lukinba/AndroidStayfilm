package com.lucasimoes.escalastayfilm;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.util.SparseArray;

import com.lucasimoes.escalastayfilm.model.Datas;
import com.lucasimoes.escalastayfilm.model.DatasDao;
import com.lucasimoes.escalastayfilm.model.Horarios;

import java.util.ArrayList;
import java.util.List;

public class DataList extends AppCompatActivity {

    private List<Datas> mDatas = new ArrayList<Datas>();
    private List<Horarios> mHorarios = new ArrayList<Horarios>();
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private LinearLayoutManager mLineartLayoutManager;

    private static DatasDao daoD = DatasDao.instanceD;
    private SparseArray<String> mapaD;
    private boolean bloqueado;

    public static Context mcontext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datalist);

        mcontext = getApplicationContext();

        CreateDatas();

        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        mRecyclerView.setHasFixedSize(true);

        mLineartLayoutManager = new LinearLayoutManager(this);
        mLineartLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        mRecyclerView.setLayoutManager(mLineartLayoutManager);

        mAdapter = new DataListAdapter(this, mDatas, mHorarios);
        mRecyclerView.setAdapter(mAdapter);
    }

    private void CreateDatas() {
        mapaD = new SparseArray<>();
        int id = 0;

        for (Datas datas : daoD.listar(bloqueado)) {
            mapaD.put(id++, datas.getData());
        }
        Datas dtas = new Datas();
        dtas.setData(mapaD.get(id));
        mDatas.add(dtas);
        Log.e("Lista Data", "Lista Data Feita");

        Horarios horario = new Horarios();
        horario.setHorario(mapaD.get(id));
        mHorarios.add(horario);
        Log.e("Lista Horario", "Lista Horario Feita");
    }

//    private void createHorarios(){
//        mapaH = new SparseArray<>();
//        int id = 0;
//
//        for (Horarios horarios : daoH.listarHorarios(Bloqueado)) {
//            mapaH.put(id++, horarios.getHorario());
//        }
//        Horarios horario = new Horarios();
//        horario.setHorario(mapaH.get(id));
//        mHorarios.add(horario);
//        Log.e("Lista Horario", "Lista Horario Feita");
//    }

    //<<<<<<<    SIMULAÇÃO DE DADOS PARA A LIST    >>>>>>>>>>>>
//    private void CreateFake(){
//        for(int i = 0; i < 10; i ++) {
//            Datas datas = new Datas();
//            datas.setData("1" + i + "/11/2016");
//            mDatas.add(datas);
//       }
//
//        for(int i = 0; i < 10; i ++) {
//            Horarios horarios = new Horarios();
//            horarios.setHorario("1" + i + ":00hs as 2" + i + ":00hs");
//            int b = 2;
//           if (i / b == 0){
//                horarios.setBloqueado(false);
//            }else{
//                horarios.setBloqueado(true);
//            }
//            mHorarios.add(horarios);
//        }
//    }

}
