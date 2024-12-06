package com.uniube.main;

import java.util.Scanner;
import com.uniube.sistema.SistemaVenda;

public class Main {
    public static void main(String[] args) {
        SistemaVenda sistema = new SistemaVenda();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Cadastrar Jogo");
            System.out.println("2. Consultar Jogos");
            System.out.println("3. Comprar Ingressos");
            System.out.println("4. Cancelar Ingressos");
            System.out.println("5. Exibir Relatório");
            System.out.println("6. Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            switch (opcao) {
                case 1:
                    sistema.cadastrarJogo();
                    break;
                case 2:
                    sistema.consultarJogos();
                    break;
                case 3:
                    sistema.comprarIngressos();
                    break;
                case 4:
                    sistema.cancelarIngressos();
                    break;
                case 5:
                    sistema.exibirRelatorio();
                    break;
                case 6:
                    System.exit(0);
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }
}