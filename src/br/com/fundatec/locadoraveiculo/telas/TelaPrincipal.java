package br.com.fundatec.locadoraveiculo.telas;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TelaPrincipal {

    public void MostrarMenu(){
        Scanner t = new Scanner(System.in);
        boolean decisão = true;
        while (decisão) {
            int resposta = 0;
            System.out.println("opção 1: apresentar Tela de Veículos");
            System.out.println("opção 2: apresentar Tela de Clientes");
            System.out.println("opção 3: apresentar Tela de Locações");
            System.out.println("opção 0: Encerrar Programa (retornando à classe principal)");
            System.out.println("diga o número da opção escolhida");
            try {
                resposta = t.nextInt();
            } catch (InputMismatchException excecao) {
                t.nextLine();
                resposta = 4;
            }
            switch (resposta) {
                case 1 -> {
                    System.out.println("apresentando a tela de veiculos");
                    TelaDeVeiculos telaDeVeículos = new TelaDeVeiculos();
                    telaDeVeículos.MostrarTelaVeiculos();
                }
                case 2 -> {
                    System.out.println("apresentando a tela de clientes");
                    TelaDeClientes telaDeClientes = new TelaDeClientes();
                    telaDeClientes.MostrarTelaClientes();
                }
                case 3 -> {
                      System.out.println("apresentando a tela de locacoes");
                    TelaDeLocacoes telaDeLocacoes = new TelaDeLocacoes();
                    telaDeLocacoes.MostrarTelaLocacoes();
                }
                case 0 -> {
                    System.out.println("encerrando o programa...");
                    decisão = false;
                    t.close();
                }
                default->{
                    System.out.println("Opção inválida, digite novamente.");
                    break;
                }
            }
        }
    }
}