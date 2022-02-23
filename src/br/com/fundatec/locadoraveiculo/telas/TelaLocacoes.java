package br.com.fundatec.locadoraveiculo.telas;

import br.com.fundatec.locadoraveiculo.bancodedados.DadosClientes;
import br.com.fundatec.locadoraveiculo.bancodedados.DadosLocacao;
import br.com.fundatec.locadoraveiculo.bancodedados.DadosVeiculos;
import br.com.fundatec.locadoraveiculo.enums.SituacaoLocacao;
import br.com.fundatec.locadoraveiculo.model.Cliente;
import br.com.fundatec.locadoraveiculo.model.Locacao;
import br.com.fundatec.locadoraveiculo.model.Veiculo;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class TelaLocacoes {

    private Scanner t = new Scanner(System.in);
    private DadosLocacao dadosLocacao = DadosLocacao.criar();
    public void MostrarTelaLocacoes() {
        boolean decisao = true;
        while (decisao) {
            int resposta = 0;
            System.out.println("opcao 1: cadastrar Locacoes");
            System.out.println("opcao 2: encerrar Locacoes");
            System.out.println("opcao 3: listar Locacoes");
            System.out.println("opcao 0: retornar ao Menu Principal");
            System.out.println("diga o numero da opcao escolhida");
            try {
                resposta = t.nextInt();
            } catch (InputMismatchException excecao) {
                t.nextLine();
                resposta = 4;
            }
            switch (resposta) {
                case 1 :
                    this.cadastrarLocacao();
                    break;
                case 2 :
                   this.encerrarLocacao();
                   encerrarLocacao();
                    break;
                case 3 :
                    this.listarLocacoes();
                    break;
                case 0 :
                    System.out.println("retornando a tela principal");
                    return;
                default :
                    System.out.println("Opcao invalida, digite novamente.");
                    break;
            }
        }
    }

    public void cadastrarLocacao() {
        Veiculo veiculos = selecionarVeiculo();
        Cliente clientes = selecionarCliente();
        System.out.println("Diga a data de locacao (YYYY-MM-DD)");
        String data = this.lerString();
        LocalDate dataLocacao = this.lerLocalDate(data);
        dadosLocacao.adicionar(new Locacao(clientes, veiculos, dataLocacao));
    }
    public void encerrarLocacao(){
        Locacao locacao = selecionarLocacao();
        System.out.println("qual a data de entrega (YYYY-MM-DD)");
        String data = this.lerString();
        LocalDate dataEntrega = this.lerLocalDate(data);
        System.out.println("diga a atual quilometragem?");
        Float kmAtual = this.lerFloat();
        locacao.encerrar( dataEntrega, kmAtual);

    }
    private Veiculo selecionarVeiculo() {
        DadosVeiculos dadosVeiculos = DadosVeiculos.criar();
        List<Veiculo> veiculos = dadosVeiculos.getVeiculos();
        if (veiculos.isEmpty()) {
            System.out.println("Ainda não foram cadastrados Veiculos");
        } else {
            for (int i = 1; i <= veiculos.size(); i++) {
                Veiculo veiculo = veiculos.get(i - 1);
                System.out.println(String.format(i + "-> "+ veiculo.toString()));
            }
        }
        System.out.println("Selecione um veículo.");
        int veiculoSelecionado = this.lerInt();
        dadosVeiculos.getVeiculoId(veiculoSelecionado);
        System.out.println("o veiculo foi selecionado");
        return veiculos.get(veiculoSelecionado);
    }

    private Cliente selecionarCliente() {
        DadosClientes dadosClientes = DadosClientes.criar();
        List<Cliente> clientes = dadosClientes.getClientes();
        if (clientes.isEmpty()) {
            System.out.println("Ainda nao foram cadastrados clientes");
        } else {
            for (int i = 1; i <= clientes.size(); i++) {
                Cliente cliente = clientes.get(i - 1);
                System.out.println(String.format(i + "-> "+ cliente.toString()));
            }
        }
        System.out.println("Indique o cliente que realizara a locação.");
        int cliente = this.lerInt();
        dadosClientes.getClienteId(cliente);
        System.out.println("o cliente foi selecionado");
        return clientes.get(cliente);
    }

    private Locacao selecionarLocacao() {
        DadosLocacao dadosLocacao = DadosLocacao.criar();
        List<Locacao> locacoes = dadosLocacao.getLocacoes();
        if (locacoes.isEmpty()) {
            System.out.println("Ainda nao foram cadastradas locacoes");
        } else {
            for (int i = 1; i <= locacoes.size(); i++) {
                Locacao locacao = locacoes.get(i - 1);
                System.out.println(String.format(i + "-> "+ locacao.toString()));
            }
        }
        System.out.println("selecione a locacao a ser encerrada");
        int locacao = this.lerInt();
        dadosLocacao.getLocacaoId(locacao);
        System.out.println("a locacao foi selecionada");
        return locacoes.get(locacao);
    }

    private void listarLocacoes() {
        DadosLocacao dadosLocacao = DadosLocacao.criar();
        List<Locacao>  locacoes = dadosLocacao.getLocacoes();
        if (locacoes.isEmpty()) {
            System.out.println("Ainda não foram cadastradas locacoes");
        } else {
            for (int i = 1; i <= locacoes.size(); i++) {
                Locacao locacao = locacoes.get(i - 1);
                System.out.println(String.format("(%s) %s", i, locacao));
            }
        }
    }
    private LocalDate lerLocalDate(String dataLocacao){
        while (true) {
            try {
                return LocalDate.parse(dataLocacao);
            } catch (InputMismatchException excecao) {
                t.nextLine();
                System.err.println("digite uma data valida");
            }
        }
    }
    private  int lerInt(){
        while (true) {
            try {
                return t.nextInt();
            } catch (InputMismatchException excecao) {
                t.nextLine();
                System.err.println("!!!Digite um valor válido!!!");
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
    private String lerString(){
        while (true) {
            try {
                return t.next();
            } catch (InputMismatchException excecao) {
                t.nextLine();
                System.err.println("!!!Digite uma opção válida!!!");
            }
        }
    }

}