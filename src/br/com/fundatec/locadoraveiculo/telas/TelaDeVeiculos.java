package br.com.fundatec.locadoraveiculo.telas;

import br.com.fundatec.locadoraveiculo.bancoDeDados.DadosVeiculos;
import br.com.fundatec.locadoraveiculo.enums.TipoCarro;
import br.com.fundatec.locadoraveiculo.model.Veiculo;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TelaDeVeiculos {

    Scanner t = new Scanner(System.in);
    private DadosVeiculos dadosVeiculos = DadosVeiculos.criar();
    public void MostrarTelaVeiculos(){
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
                    System.out.println("cadastrando veiculo");
                    System.out.println("qual a placa do carro?");
                    String placa = t.next();
                    System.out.println("qual a marca do carro?");
                    String marca = t.next();
                    System.out.println("qual o modelo do veiculo?");
                    String modelo = t.next();
                    System.out.println("qual a sua quilometragem?");
                    Double quilometragem = t.nextDouble();
                    System.out.println("qual o valor por quilometro rodado");
                    Double valorKmRodado = t.nextDouble();
                    System.out.println("qual o valor da diária?");
                    Double valorDiaria = t.nextDouble();
                    System.out.println("qual o tipo de carro?");
                    System.out.println("os tipos de carro são  HATCH, SEDAN, SUV, PICKUP e COUPE");
                    var tipoCarro = TipoCarro.valueOf(t.next());
                   this.cadastrarVeiculo(placa, marca,modelo, quilometragem, valorKmRodado, valorDiaria, tipoCarro);
                }
                case 2 -> {
                    System.out.println("lista de veiculos");
                    this.listarVeiculos();
                }
                case 0 ->{
                    System.out.println("retornando à tela principal");
                    return;
                }
                default->{
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
            for (Veiculo elemento : dadosVeiculos.getVeiculos()){
                System.out.println("as informações do veículo são placa, marca, modelo, quilometragem, valor km rodado, valor por diaria, tipo de carro");
                System.out.println(elemento.getPlaca()+", "+elemento.getMarca()+", "+elemento.getModelo()+", "+elemento.getQuilometragem()+", "+ elemento.getValorKmRodado()+", "+elemento.getValorDiaria()+", "+ elemento.getTipoCarro());
            }
        }
}