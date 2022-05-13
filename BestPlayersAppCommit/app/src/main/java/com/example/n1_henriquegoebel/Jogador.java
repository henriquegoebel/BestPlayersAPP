package com.example.n1_henriquegoebel;

public class Jogador {

    public int id, numeroCamiseta;
    public String nomeCompleto, nomeCamiseta, pePreferencial;
    public int goleiro, lateral, zagueiro, meia, atacante;

    public Jogador() {
    }

    public Jogador(int id, int numeroCamiseta, String nomeCompleto, String nomeCamiseta, String pePreferencial,
                   int goleiro, int lateral, int zagueiro, int meia, int atacante) {
        this.id = id;
        this.numeroCamiseta = numeroCamiseta;
        this.nomeCompleto = nomeCompleto;
        this.nomeCamiseta = nomeCamiseta;
        this.pePreferencial = pePreferencial;
        this.goleiro = goleiro;
        this.lateral = lateral;
        this.zagueiro = zagueiro;
        this.meia = meia;
        this.atacante = atacante;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumeroCamiseta() {
        return numeroCamiseta;
    }

    public void setNumeroCamiseta(int numeroCamiseta) {
        this.numeroCamiseta = numeroCamiseta;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public String getNomeCamiseta() {
        return nomeCamiseta;
    }

    public void setNomeCamiseta(String nomeCamiseta) {
        this.nomeCamiseta = nomeCamiseta;
    }

    public String getPePreferencial() {
        return pePreferencial;
    }

    public void setPePreferencial(String pePreferencial) {
        this.pePreferencial = pePreferencial;
    }

    public int getGoleiro() {
        return goleiro;
    }

    public void setGoleiro(int goleiro) {
        this.goleiro = goleiro;
    }

    public int getLateral() {
        return lateral;
    }

    public void setLateral(int lateral) {
        this.lateral = lateral;
    }

    public int getZagueiro() {
        return zagueiro;
    }

    public void setZagueiro(int zagueiro) {
        this.zagueiro = zagueiro;
    }

    public int getMeia() {
        return meia;
    }

    public void setMeia(int meia) {
        this.meia = meia;
    }

    public int getAtacante() {
        return atacante;
    }

    public void setAtacante(int atacante) {
        this.atacante = atacante;
    }
}
