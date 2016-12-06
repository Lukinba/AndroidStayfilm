package com.lucasimoes.escalastayfilm.model;


import java.util.ArrayList;
import java.util.List;

public class Datas {
    private Long Id;
    private String Data;
    private List<Horarios> mHorarios = new ArrayList<>();


    public Datas(){}

    public Datas(String data){
        this.Data = data;

    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getData() {
        return Data;
    }

    public void setData(String data) {
        Data = data;
    }

    public boolean isBloqueado(){
        boolean bloqueado = true;

        for (Horarios horarios : mHorarios){
            if (!horarios.isBloqueado()){
                bloqueado = false;
                break;
            }
        }
        return bloqueado && mHorarios.size() > 0;
    }

    public void setBloqueado(boolean bloqueado){}

    public List<Horarios> getmHorarios() {
        List<Horarios> novaList = null;

        try{
            novaList = new ArrayList<>();
            for (Horarios horarios : mHorarios){
                novaList.add((Horarios)horarios.clone());
            }
        } catch (CloneNotSupportedException ex){
            novaList = mHorarios;
        }

        return novaList;
    }

    public void setmHorarios(List<Horarios> mHorarios) {
        this.mHorarios = mHorarios;
    }



    @Override
    public String toString(){
        return Data;
    }
}
