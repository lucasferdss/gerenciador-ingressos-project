package com.uniube.sistema;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import com.uniube.servicos.Jogo;
import com.uniube.servicos.Venda;
import com.uniube.servicos.Ingresso;

public class SistemaVenda {
    private List<Jogo> jogos = new ArrayList<>();
    private Venda venda = new Venda();

    public void cadastrarJogo() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o time da casa:");
        String timeCasa = scanner.nextLine();
        System.out.println("Digite o time visitante:");
        String timeVisitante = scanner.nextLine();
        System.out.println("Digite o estádio:");
        String estadio = scanner.nextLine();
        System.out.println("Digite a data (dd/mm/aaaa):");
        String data = scanner.nextLine();
        System.out.println("Digite o horário (hh:mm):");
        String horario = scanner.nextLine();
        System.out.println("Digite a capacidade do estádio:");
        int capacidade = scanner.nextInt();

        Jogo jogo = new Jogo(timeCasa, timeVisitante, estadio, data, horario, capacidade);
        jogos.add(jogo);
        System.out.println("Jogo cadastrado com sucesso!");
    }

    public void consultarJogos() {
        System.out.println("Jogos disponíveis:");
        for (int i = 0; i < jogos.size(); i++) {
            Jogo jogo = jogos.get(i);
            System.out.println((i + 1) + ". " + jogo.getDescricaoJogo() + " - Ingressos disponíveis: " + jogo.getIngressosDisponiveis());
        }
    }

    public void comprarIngressos() {
        Scanner scanner = new Scanner(System.in);

        consultarJogos();
        System.out.println("Escolha o número do jogo:");
        int numeroJogo = scanner.nextInt() - 1;

        if (numeroJogo < 0 || numeroJogo >= jogos.size()) {
            System.out.println("Número do jogo inválido.");
            return;
        }

        Jogo jogo = jogos.get(numeroJogo);

        if (jogo.getIngressosDisponiveis() <= 0) {
            System.out.println("Ingressos esgotados para este jogo.");
            return;
        }

        System.out.println("Digite o nome do comprador:");
        scanner.nextLine();
        String comprador = scanner.nextLine();
        System.out.println("Digite o setor:");
        String setor = scanner.nextLine();
        System.out.println("Digite o número de ingressos:");
        int quantidade = scanner.nextInt();
        System.out.println("Digite o preço por ingresso:");
        double preco = scanner.nextDouble();

        if (quantidade <= jogo.getIngressosDisponiveis()) {
            for (int i = 0; i < quantidade; i++) {
                Ingresso ingresso = new Ingresso(comprador, setor, preco);
                venda.registrarVenda(ingresso);
            }
            jogo.venderIngressos(quantidade);
            System.out.println("Compra realizada com sucesso!");
        } else {
            System.out.println("Quantidade de ingressos indisponível.");
        }
    }

    public void cancelarIngressos() {
        Scanner scanner = new Scanner(System.in);

        consultarJogos();
        System.out.println("Escolha o número do jogo para cancelar ingressos:");
        int numeroJogo = scanner.nextInt() - 1;

        if (numeroJogo < 0 || numeroJogo >= jogos.size()) {
            System.out.println("Número de jogo inválido.");
            return;
        }

        Jogo jogo = jogos.get(numeroJogo);

        System.out.println("Digite o nome do comprador para buscar os ingressos:");
        scanner.nextLine();
        String comprador = scanner.nextLine();

        System.out.println("Digite o setor do ingresso a ser cancelado:");
        String setor = scanner.nextLine();

        System.out.println("Digite a quantidade de ingressos a cancelar:");
        int quantidade = scanner.nextInt();

        List<Ingresso> ingressosParaCancelar = new ArrayList<>();
        for (Ingresso ingresso : venda.getIngressosVendidos()) {
            if (ingresso.getComprador().equalsIgnoreCase(comprador) &&
                    ingresso.getSetor().equalsIgnoreCase(setor) &&
                    ingressosParaCancelar.size() < quantidade) {
                ingressosParaCancelar.add(ingresso);
            }
        }

        if (ingressosParaCancelar.size() < quantidade) {
            System.out.println("Quantidade de ingressos para cancelamento não encontrada.");
            return;
        }

        for (Ingresso ingresso : ingressosParaCancelar) {
            venda.cancelarVenda(ingresso);
        }
        jogo.cancelarIngressos(quantidade);

        System.out.println("Cancelamento realizado com sucesso! " + quantidade + " ingressos devolvidos.");
    }

    public void exibirRelatorio() {
        venda.exibirRelatorio();
    }
}