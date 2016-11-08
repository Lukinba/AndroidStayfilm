package com.lucasimoes.projetostayfilm.model;

public class Item {
    private Long id;
    private String data;
    private String horario;
    private int img;
    private boolean datas;
    private boolean horarios;

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

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public boolean isDatas() {
        return datas;
    }

    public void setDatas(boolean datas) {
        this.datas = datas;
    }

    public boolean isHorarios(){
        return horarios;
    }
    public void setHorarios(boolean horarios){
        this.horarios = horarios;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Item novo = new Item();

        novo.id = (long)id;
        novo.data = data;
        novo.horario = horario;
        novo.img = img;

        return novo;
    }
}
