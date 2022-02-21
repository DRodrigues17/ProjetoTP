package br.com.fundatec.locadoraveiculo.telas;

import br.com.fundatec.locadoraveiculo.bancoDeDados.DadosVeiculos;
import br.com.fundatec.locadoraveiculo.enums.TipoCarro;
import br.com.fundatec.locadoraveiculo.model.Veiculo;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TelaDeVeiculos {

    Scanner t = new Scanner(System.in);
    private DadosVeiculos dadosVeiculos = DadosVeiculos.criar();

    public void MostrarTelaVeiculos() {
        boolean decisão = true;
        while (decisão) {
            int resposta = 0;
            System.out.println("opção 1: cadastrar Veículos");
            System.out.println("opção 2: listar Veículos");
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
                    System.out.println("qual a placa do carro?");
                    String placa = this.lerString();
                    System.out.println("qual a marca do carro?");
                    String marca = this.lerString();
                    System.out.println("qual o modelo do veiculo?");
                    String modelo = this.lerString();
                    System.out.println("qual a sua quilometragem?");
                    Double quilometragem = this.lerDouble();
                    System.out.println("qual o valor por quilometro rodado");
                    Double valorKmRodado = this.lerDouble();
                    System.out.println("qual o valor da diária?");
                    Double valorDiaria = this.lerDouble();
                    System.out.println("qual o tipo de carro?");
                    System.out.println("os tipos de carro são  HATCH, SEDAN, SUV, PICKUP e COUPE");
                    var tipoCarro = this.lerTipoVeiculo();
                    this.cadastrarVeiculo(placa, marca, modelo, quilometragem, valorKmRodado, valorDiaria, tipoCarro);
                }
                case 2 -> {
                    System.out.println("lista de veiculos");
                    this.listarVeiculos();
                }
                case 0 -> {
                    System.out.println("retornando à tela principal");
                    return;
                }
                default -> {
                    System.out.println("Opção inválida, digite novamente.");
                    break;
                }
            }
        }
    }

    public void cadastrarVeiculo(String placa, String marca, String modelo, double quilometragem, double valorKmRodado,
                                 double valorDiaria, TipoCarro tipoCarro) {
        dadosVeiculos.adicionar(new Veiculo(placa, marca, modelo, quilometragem, valorKmRodado, valorDiaria, tipoCarro));
    }

    public void listarVeiculos() {
        for (Veiculo elemento : dadosVeiculos.getVeiculos()) {
            System.out.println("a seguir, a lista de veiculos");
            System.out.println(elemento.toString());
        }
        if (dadosVeiculos.getVeiculos().isEmpty()) {
            System.out.println("ainda não existe nenhum veiculo cadastrado");
        }
    }

    public TipoCarro lerTipoVeiculo() {
        while (true) {
            try {
                String tipo = t.next();
                return TipoCarro.valueOf(tipo.toUpperCase());
            } catch (IllegalArgumentException excecao) {
                System.out.println(
                        "!!!Tipo de veículo inválido. Digite uma das opções válidas. (HATCH, SEDAN, SUV, PICKUP)!!!");
            }
        }
    }

    public double lerDouble() {
        while (true) {
            try {
                return t.nextDouble();
            } catch (IllegalArgumentException excecao) {
                t.nextLine();
                System.out.println("!!!Digite um valor válido!!!");
            }
        }
    }

    public String lerString(){
        while (true) {
            try {

                return t.nextLine();
            } catch (IllegalArgumentException excecao) {
                t.nextLine();
                System.out.println("!!!Digite uma opção válida!!!");
            }
        }
    }
}