package com.uniube.servicos;

public class Ingresso {
    private String comprador;
    private String setor;
    private double preco;

    public Ingresso(String comprador, String setor, double preco) {
        this.comprador = comprador;
        this.setor = setor;
        this.preco = preco;
    }

    public double getPreco() {
        return preco;
    }
    public void setPreco(double preco) {
        this.preco = preco;
    }
    public String getComprador() {
        return comprador;
    }
    public void setComprador(String comprador) {
        this.comprador = comprador;
    }
    public String getSetor() {
        return setor;
    }
    public void setSetor(String setor) {
        this.setor = setor;
    }

    @Override
    public String toString() {
        return "Comprador: " + comprador + ", Setor: " + setor + ", Preço: R$" + preco;
    }
}