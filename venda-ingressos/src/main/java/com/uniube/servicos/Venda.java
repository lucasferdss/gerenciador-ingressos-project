package com.uniube.servicos;

import java.util.ArrayList;
import java.util.List;

public class Venda {
    private List<Ingresso> ingressosVendidos;

    public Venda() {
        this.ingressosVendidos = new ArrayList<>();
    }

    public void registrarVenda(Ingresso ingresso) {
        ingressosVendidos.add(ingresso);
    }

    public void cancelarVenda(Ingresso ingresso) {
        ingressosVendidos.remove(ingresso);
    }

    public List<Ingresso> getIngressosVendidos() {
        return ingressosVendidos;
    }

    public void exibirRelatorio() {
        double receitaTotal = 0;
        System.out.println("Relatório de Vendas:");
        for (Ingresso ingresso : ingressosVendidos) {
            System.out.println(ingresso);
            receitaTotal += ingresso.getPreco();
        }
        System.out.println("Receita total: R$" + receitaTotal);
    }
}
