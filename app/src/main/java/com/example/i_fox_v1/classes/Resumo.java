package com.example.i_fox_v1.classes;

public class Resumo {

    //atributos
    private int codigo, caderno;
    private String tipo, titulo, texto, data_resumo;

    //construtor vazio


    public Resumo() {
    }
    //construtor para cadastro de resumo


    public Resumo(int caderno, String tipo, String titulo, String texto, String data_resumo) {
        this.caderno = caderno;
        this.tipo = tipo;
        this.titulo = titulo;
        this.texto = texto;
        this.data_resumo = data_resumo;
    }

    //construtor para listagem de resumos


    public Resumo(int codigo, int caderno, String tipo, String titulo, String data_resumo) {
        this.codigo = codigo;
        this.caderno = caderno;
        this.tipo = tipo;
        this.titulo = titulo;
        this.data_resumo = data_resumo;
    }

    public Resumo(int codigo, int caderno, String tipo, String titulo, String texto, String data_resumo) {
        this.codigo = codigo;
        this.caderno = caderno;
        this.tipo = tipo;
        this.titulo = titulo;
        this.texto = texto;
        this.data_resumo = data_resumo;
    }

    //getters e setters

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getCaderno() {
        return caderno;
    }

    public void setCaderno(int caderno) {
        this.caderno = caderno;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public String getData_resumo() {
        return data_resumo;
    }

    public void setData_resumo(String data_resumo) {
        this.data_resumo = data_resumo;
    }
}
