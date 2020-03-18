package com.example.faculdade;

public class Pessoa {

    private String AnoNascimento, CorDosOlhos, Genero, CorDoCabelo;

    public Pessoa() {

    }

    public Pessoa(String anoNascimento, String corDosOlhos, String genero, String corDoCabelo) {
        AnoNascimento = anoNascimento;
        CorDosOlhos = corDosOlhos;
        Genero = genero;
        CorDoCabelo = corDoCabelo;
    }

    public String getAnoNascimento() {
        return AnoNascimento;
    }

    public void setAnoNascimento(String anoNascimento) {
        AnoNascimento = anoNascimento;
    }

    public String getCorDosOlhos() {
        return CorDosOlhos;
    }

    public void setCorDosOlhos(String corDosOlhos) {
        CorDosOlhos = corDosOlhos;
    }

    public String getGenero() {
        return Genero;
    }

    public void setGenero(String genero) {
        Genero = genero;
    }

    public String getCorDoCabelo() {
        return CorDoCabelo;
    }

    public void setCorDoCabelo(String corDoCabelo) {
        CorDoCabelo = corDoCabelo;
    }
}
