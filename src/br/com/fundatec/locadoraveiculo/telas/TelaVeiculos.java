package br.com.fundatec.locadoraveiculo.telas;

import br.com.fundatec.locadoraveiculo.bancodedados.DadosVeiculos;
import br.com.fundatec.locadoraveiculo.enums.TipoCarro;
import br.com.fundatec.locadoraveiculo.model.Veiculo;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TelaVeiculos {

    private Scanner t = new Scanner(System.in);
    private DadosVeiculos dadosVeiculos = DadosVeiculos.criar();

    public void MostrarTelaVeiculos() {
        boolean decisao = true;
        while (decisao) {
            int resposta = 0;
            System.out.println("opcao 1: cadastrar Veiculos");
            System.out.println("opcao 2: listar Veiculos");
            System.out.println("opcao 0: retornar ao Menu Principal");
            System.out.println("diga o numero da opcao escolhida");
            try {
                resposta = t.nextInt();
            } catch (InputMismatchException excecao) {
                t.nextLine();
                resposta = 4;
            }
            switch (resposta) {
                case 1 -> {
                    System.out.println("qual a placa do carro?");
                    String placa = this.lerString();
                    System.out.println("qual a marca do carro?");
                    String marca = this.lerString();
                    System.out.println("qual o modelo do veiculo?");
                    String modelo = this.lerString();
                    System.out.println("qual a sua quilometragem?");
                    Float quilometragem = this.lerFloat();
                    System.out.println("qual o valor por quilometro rodado");
                    Double valorKmRodado = this.lerDouble();
                    System.out.println("qual o valor da diaria?");
                    Double valorDiaria = this.lerDouble();
                    System.out.println("qual o tipo de carro?");
                    System.out.println("os tipos de carro sao  HATCH, SEDAN, SUV, PICKUP e COUPE");
                    var tipoCarro = this.lerTipoCarro();
                    this.cadastrarVeiculo(placa, marca, modelo, quilometragem, valorKmRodado, valorDiaria, tipoCarro);

                }
                case 2 -> {
                    System.out.println("lista de veiculos");
                    this.listarVeiculos();
                    break;
                }
                case 0 -> {
                    System.out.println("retornando a tela principal");
                    return;
                }
                default -> {
                    System.out.println("Opcao invalida, digite novamente.");
                    break;
                }
            }
        }
    }
    public void cadastrarVeiculo(String placa, String marca, String modelo, Float quilometragem, Double valorKmRodado,
                                 Double valorDiaria, TipoCarro tipoCarro) {
        dadosVeiculos.adicionar(new Veiculo(placa, marca, modelo, quilometragem, valorKmRodado, valorDiaria, tipoCarro));
    }

    public void listarVeiculos() {
        for (Veiculo elemento : dadosVeiculos.getVeiculos()) {
            System.out.println("a seguir, a lista de veiculos");
            System.out.println(elemento.toString());
        }
        if (dadosVeiculos.getVeiculos().isEmpty()) {
            System.out.println("ainda nao existe nenhum veiculo cadastrado");
        }
    }
    private TipoCarro lerTipoCarro() {
        while (true) {
            try {
                String tipoCarro = t.next();
                return TipoCarro.valueOf(tipoCarro.toUpperCase());
            } catch (IllegalArgumentException excecao) {
                System.err.println(
                        "Tipo de veiculo invalido, digite uma das opcoes validas. (HATCH, SEDAN, SUV ou PICKUP)");
            }
        }
    }
    private float lerFloat() {
        while (true) {
            try {
                return t.nextFloat();
            } catch (InputMismatchException excecao) {
                t.nextLine();
                System.err.println("!!!Digite um valor valido!!!");
            }
        }
    }
    private double lerDouble() {
        while (true) {
            try {
                return t.nextDouble();
            } catch (InputMismatchException excecao) {
                t.nextLine();
                System.err.println("!!!Digite um valor valido!!!");
            }
        }
    }
    private String lerString(){
        while (true) {
            try {
                return t.next();
            } catch (InputMismatchException excecao) {
                t.nextLine();
                System.err.println("!!!Digite uma opcao valida!!!");
            }
        }
    }
}