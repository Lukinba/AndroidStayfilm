package com.lucasimoes.projetostayfilm.model;

import java.util.ArrayList;
import java.util.List;


public class Data {
    private Long id;
    private String data;
    private String horarios;
    private int img;



    private boolean datas;
    private List<Item> itens = new ArrayList<>();

    public static final boolean LISTA = false;


    //simulacao
    public Data(String data, String horario){
        this.data = data;
        this.horarios = horario;

    }

    public Data(){

    }
    //fim

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }


    public String getHorarios() {
        return horarios;
    }

    public void setHorarios(String horarios) {
        this.horarios = horarios;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }


    public boolean isDatas() {
        boolean datas = true;

        for (Item item : itens){
            if(!item.isDatas()){
                datas = false;
                break;
            }
        }


        return datas && itens.size() > 0;
    }


    public List<Item> getItens() {
        List<Item> novaLista = null;

        try{
            novaLista = new ArrayList<>();
            for (Item item : itens){
                novaLista.add((Item)item.clone());
            }
        } catch (CloneNotSupportedException ex){
            novaLista = itens;
        }
        return novaLista;
    }

    public void setItens(List<Item> itens) {
        this.itens = itens;
    }

}
