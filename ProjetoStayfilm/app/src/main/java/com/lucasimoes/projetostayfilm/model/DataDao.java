package com.lucasimoes.projetostayfilm.model;

import com.lucasimoes.projetostayfilm.R;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;


public class DataDao {
    public static DataDao instancia = new DataDao();

    private List<Data> lista;
    private long id=0;

    //simulacao
    private DataDao(){
        lista = new ArrayList<>();
        salvar(new Data("22/10/2012"));
        salvar(new Data("25/10/2012"));
        salvar(new Data("30/10/2012"));
        salvar(new Data("01/11/2012"));
        salvar(new Data("06/11/2012"));
        salvar(new Data("12/11/2012"));
        salvar(new Data("25/11/2012"));
        salvar(new Data("30/11/2012"));

    }
    //fim

    public void salvar(Data obj){
        if (obj.getId() == null){
            obj.setId(id++);
            lista.add(obj);
        }
        else{
            Data data = localizar(obj.getId());
            data.setData(obj.getData());
        }
    }

    public Data localizar (long id){
        Data obj = null;

        for (Data data : lista){
            if (data.getId() == id){

                obj = data;
                break;
            }
        }
        return obj;
    }

    public List<Data> listar(boolean datas){
        List<Data> listSaida = new ArrayList<>();

        for (Data data : lista){
            if (data.isDatas() == datas){
                listSaida.add(data);
            }
        }
        return listSaida;
    }
    

}
