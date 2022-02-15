package br.com.fundatec.locadoraveiculo.telas;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TelaDeLocacoes {

    public static void MostrarTelaLocacoes(){
        Scanner t = new Scanner(System.in);
        boolean decisão = true;
        while (decisão) {
            int resposta = 0;
            System.out.println("opção 1: cadastrar Locações");
            System.out.println("opção 2: encerrar Locações");
            System.out.println("opção 3: listar Locações");
            System.out.println("opção 0: retornar ao Menu Principal");
            System.out.println("diga o número da opção escolhida");
            try {
                resposta = t.nextInt();
            } catch (InputMismatchException excecao) {
                t.nextLine();
                resposta = 4;
            }
            switch (resposta) {
                case 1 -> {
                    System.out.println("cadastrando nova locacao");
                    //   this.cadastrarLocacao();
                }
                case 2 -> {
                    System.out.println("encerrando locacao");
                }
                case 3 -> {
                    System.out.println("listando locacoes");
                    //   this.listarLocacoes();
                }
                case 0 -> {
                    System.out.println("retornando à tela principal");
                    return;
                }
                default->{
                    System.out.println("Opção inválida, digite novamente.");
                    break;
                }
            }
        }
//        public void cadastrarLocacao() {
//
//        }
//
//        public void listarLocacoes() {
//
//        }
    }
}