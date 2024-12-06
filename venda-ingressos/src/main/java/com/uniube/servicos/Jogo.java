package com.uniube.servicos;

public class Jogo {
    private String timeCasa;
    private String timeVisitante;
    private String estadio;
    private String data;
    private String horario;
    private int capacidade;
    private int ingressosVendidos;

    public Jogo(String timeCasa, String timeVisitante, String estadio, String data, String horario, int capacidade) {
        this.timeCasa = timeCasa;
        this.timeVisitante = timeVisitante;
        this.estadio = estadio;
        this.data = data;
        this.horario = horario;
        this.capacidade = capacidade;
        this.ingressosVendidos = 0;
    }

    public String getDescricaoJogo() {
        return timeCasa + " x " + timeVisitante + " - " + estadio + " - " + data + " às " + horario;
    }

    public int getIngressosDisponiveis() {
        return capacidade - ingressosVendidos;
    }

    public void venderIngressos(int quantidade) {
        if (quantidade <= getIngressosDisponiveis()) {
            ingressosVendidos += quantidade;
        }
    }

    public void cancelarIngressos(int quantidade) {
        if (quantidade <= ingressosVendidos) {
            ingressosVendidos -= quantidade;
        }
    }
}