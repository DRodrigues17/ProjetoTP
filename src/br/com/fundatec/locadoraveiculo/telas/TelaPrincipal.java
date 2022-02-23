package br.com.fundatec.locadoraveiculo.telas;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TelaPrincipal {

    private Scanner t = new Scanner(System.in);
    public void MostrarMenu(){
        boolean decisao = true;
        while (decisao) {
            int resposta = 0;
            System.out.println("opcao 1: apresentar Tela de Veiculos");
            System.out.println("opcao 2: apresentar Tela de Clientes");
            System.out.println("opcao 3: apresentar Tela de Locacoes");
            System.out.println("opcao 0: Encerrar Programa (retornando a classe principal)");
            System.out.println("diga o numero da opcao escolhida");
            try {
                resposta = t.nextInt();
            } catch (InputMismatchException excecao) {
                t.nextLine();
                resposta = 4;
            }
            switch (resposta) {
                case 1 :
                    System.out.println("apresentando a tela de veiculos");
                    TelaVeiculos telaVeiculos = new TelaVeiculos();
                    telaVeiculos.MostrarTelaVeiculos();
                    break;
                case 2 :
                    System.out.println("apresentando a tela de clientes");
                    TelaClientes telaClientes = new TelaClientes();
                    telaClientes.MostrarTelaClientes();
                    break;
                case 3 :
                      System.out.println("apresentando a tela de locacoes");
                    TelaLocacoes telaLocacoes = new TelaLocacoes();
                    telaLocacoes.MostrarTelaLocacoes();
                    break;
                case 0 :
                    System.out.println("encerrando o programa...");
                    decisao = false;
                    t.close();
                    break;
                default:
                    System.out.println("Opcao invalida, digite novamente.");
                    break;
            }
        }
    }
}