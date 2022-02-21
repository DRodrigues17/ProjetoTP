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

    Scanner t = new Scanner(System.in);
    public void MostrarTelaLocacoes() {
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
                    this.cadastrarLocacao();
                }
                case 2 -> {
                   this.encerrarLocacao();
                    System.out.println("encerrando locacao");
                }
                case 3 -> {
                    this.listarLocacoes();
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

    public Locacao cadastrarLocacao() {
        Veiculo veiculos = selecionarVeiculo();
        Cliente clientes = selecionarCliente();
        System.out.println("Informe a data de locacao. (YYYY-MM-DD)");
        String dataLocacao = this.lerString();
        LocalDate dataLocacaoo = LocalDate.parse(dataLocacao);
        System.out.println("qual a situacao da locacao?");
        SituacaoLocacao situacaoLocacao = SituacaoLocacao.valueOf(t.next().toUpperCase());
        Locacao locacao = new Locacao(clientes, veiculos, dataLocacaoo, situacaoLocacao);
        return locacao;
    }
    public Locacao encerrarLocacao(){
        this.listarLocacoes();
        System.out.println("informe a locacao que voce pretende ");

    }
    private Veiculo selecionarVeiculo() {

        DadosVeiculos dadosVeiculos = DadosVeiculos.criar();
        List<Veiculo> veiculos = dadosVeiculos.getVeiculos();
        if (veiculos.isEmpty()) {
            System.out.println("Ainda não foram cadastrados Veiculos");
        } else {
            String linha = "%-4s %-7s %-10s %-10s %-6s %-8s %-6s %-6s";
            System.out.println(
                    String.format(linha, "Num", "Placa", "Marca", "Modelo", "Tipo", "Km", "Valor Km", "Valor Diaria"));
            for (int i = 1; i <= veiculos.size(); i++) {
                Veiculo veiculo = veiculos.get(i - 1);
                System.out.println(String.format(linha, i, veiculo.toString()));
            }
        }
        System.out.println("Selecione um veículo.");
        int veiculoSelecionado = this.lerInt();
        dadosVeiculos.getVeiculoId(veiculoSelecionado);
        return veiculos.get(veiculoSelecionado);
    }

    private Cliente selecionarCliente() {
        DadosClientes dadosClientes = DadosClientes.criar();
        List<Cliente> clientes = dadosClientes.getClientes();
        if (clientes.isEmpty()) {
            System.out.println("Ainda nao foram cadastrados clientes");
        } else {
            String linha = "%-4s %-7s %-10s %-10s %-6s %-8s %-6s %-6s";
            System.out.println(
                    String.format(linha, "Num", "Nome", "Tipo Documento", "Número documento", "CNPJ", "Razão Social", "Endereco"));
            for (int i = 1; i <= clientes.size(); i++) {
                Cliente cliente = clientes.get(i - 1);
                System.out.println(String.format(linha, i, cliente.toString()));
            }
        }
        System.out.println("Indique o cliente que realizara a locação.");
        int cliente = this.lerInt();
        dadosClientes.getClienteId(cliente);
        return clientes.get(cliente);
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

    private BigDecimal lerBigDecimal(){
        while (true) {
            try {
                return t.nextBigDecimal();
            } catch (InputMismatchException excecao) {
                t.nextLine();
                System.out.println("!!!Digite um valor válido!!!");
            }
        }
    }
    private LocalDate lerLocalDate(){
        while (true) {
            try {
                return LocalDate.parse(dataLocacao);
            } catch (InputMismatchException excecao) {
                t.nextLine();
                System.out.println("!!!Digite um valor válido!!!");
            }
        }
    }
    private  int lerInt(){
        while (true) {
            try {
                return t.nextInt();
            } catch (InputMismatchException excecao) {
                t.nextLine();
                System.out.println("!!!Digite um valor válido!!!");
            }
        }
    }
    private String lerString(){
        while (true) {
            try {
                return t.next();
            } catch (InputMismatchException excecao) {
                t.nextLine();
                System.out.println("!!!Digite uma opção válida!!!");
            }
        }
    }

}