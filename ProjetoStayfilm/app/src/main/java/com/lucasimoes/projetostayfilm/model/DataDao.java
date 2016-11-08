package com.lucasimoes.projetostayfilm.model;

import com.lucasimoes.projetostayfilm.R;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;


public class DataDao {
    String date;
    String hora;
    //colhendo dados de data atual

    public static DataDao instancia = new DataDao();

    private List<Data> lista;
    private List<Data> listHora;
    private long id=0;

    //simulacao
    private DataDao(){
        lista = new ArrayList<>();
        salvar(new Data("22/10/2012", "08:00h as 18:00h"));
        salvar(new Data("25/10/2012", "10:00h as 14:00h"));
        salvar(new Data("30/10/2012", "15:00h as 20:00h"));
        salvar(new Data("01/11/2012", "08:00h as 15:00h"));
        salvar(new Data("06/11/2012", "20:00h as 22:00h"));
        salvar(new Data("12/11/2012", "13:00h as 19:00h"));
        salvar(new Data("25/11/2012", "19:00h as 22:00h"));
        salvar(new Data("30/11/2012", "10:00h as 14:00h"));

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
