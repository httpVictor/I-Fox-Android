package com.example.i_fox_v1.classes;

import android.widget.EditText;

public class Caderno {

    private String titulo, descricao, icone, usuario;
    private  int codigo;

    public Caderno(String titulo, String descricao, String icone, int codigo) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.icone = icone;
        this.codigo = codigo;
    }


    public Caderno(String titulo, String descricao, String icone, String usuario) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.icone = icone;
        this.usuario = usuario;
    }


//construtor

    //getters e setters


    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getIcone() {
        return icone;
    }

    public void setIcone(String icone) {
        this.icone = icone;
    }

    public int getCodigo() {
        return codigo;
    }


}
