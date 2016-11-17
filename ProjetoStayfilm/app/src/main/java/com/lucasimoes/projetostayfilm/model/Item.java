package com.lucasimoes.projetostayfilm.model;

public class Item {
    private Long id;
    private String horario;
    private boolean horarios;

    //simulacao
    public Item(String Horario){
        this.horario = Horario;
    }

    public Item(){
    }
    //fim

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
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
        novo.horarios = horarios;
        novo.horario = new String(horario.getBytes());

        return novo;
    }

    @Override
    public String toString(){
        return "Item{" + "id=" + id + ", Horario='" + horario + '\'' +
                ", concluido=" + horarios + '}';
    }
}
