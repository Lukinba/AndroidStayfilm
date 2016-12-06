package com.lucasimoes.escalastayfilm.model;




public class Horarios {
    private Long Id;
    private String Horario;
    private boolean Bloqueado;


    public Horarios(){}

    public Horarios(String horario){
        this.Horario = horario;
    }


    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getHorario() {
        return Horario;
    }

    public void setHorario(String horario) {
        Horario = horario;
    }


    public boolean isBloqueado() {
        return Bloqueado;
    }

    public void setBloqueado(boolean bloqueado) {
        Bloqueado = bloqueado;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException{
        Horarios novo = new Horarios();
        novo.Id =(long)Id;
        novo.Horario = Horario;
        novo.Bloqueado = Bloqueado;

        return novo;
    }

}
