package br.com.fundatec.locadoraveiculo.telas;

import br.com.fundatec.locadoraveiculo.bancoDeDados.DadosClientes;
import br.com.fundatec.locadoraveiculo.bancoDeDados.DadosLocacao;
import br.com.fundatec.locadoraveiculo.bancoDeDados.DadosVeiculos;
import br.com.fundatec.locadoraveiculo.enums.SituacaoLocacao;
import br.com.fundatec.locadoraveiculo.model.Cliente;
import br.com.fundatec.locadoraveiculo.model.Locacao;
import br.com.fundatec.locadoraveiculo.model.Veiculo;

import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class TelaDeLocacoes {

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
                 //  this.encerrarLocacao();
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
        System.out.println("Informe a data de locação. (YYYY-MM-DD)");
        String dataLocacao = t.nextLine();
        LocalDate dataLocacaoo = LocalDate.parse(dataLocacao);
        System.out.println("qual a situacao da locacao?");
        SituacaoLocacao situacaoLocacao = SituacaoLocacao.valueOf(t.next().toUpperCase());
        Locacao locacao = new Locacao(clientes, veiculos, dataLocacaoo, situacaoLocacao);
        return locacao;
    }
    private Veiculo selecionarVeiculo() {

        DadosVeiculos dadosVeiculos = DadosVeiculos.criar();
        List<Veiculo> veiculos = dadosVeiculos.getVeiculos();
        if (veiculos.isEmpty()) {
            System.out.println("Ainda não foram cadastrados Veiculos");
        } else {
            String linha = "%-4s %-7s %-10s %-10s %-6s %-8s %-6s %-6s";
            System.out.println(
                    String.format(linha, "Num", "Placa", "Marca", "Modelo", "Tipo", "Km", "Valor Km", "Valor Diária"));
            for (int i = 1; i <= veiculos.size(); i++) {
                Veiculo veiculo = veiculos.get(i - 1);
                System.out.println(String.format(linha, i, veiculo.toString()));
            }
        }
        System.out.println("Selecione um veículo.");
        int veiculoSelecionado = t.nextInt();
        dadosVeiculos.getVeiculoId(veiculoSelecionado);
        return veiculos.get(veiculoSelecionado);
    }

    private Cliente selecionarCliente() {
        DadosClientes dadosClientes = DadosClientes.criar();
        List<Cliente> clientes = dadosClientes.getClientes();
        if (clientes.isEmpty()) {
            System.out.println("Ainda não foram cadastrados clientes");
        } else {
            String linha = "%-4s %-7s %-10s %-10s %-6s %-8s %-6s %-6s";
            System.out.println(
                    String.format(linha, "Num", "Nome", "Tipo Documento", "Número documento", "CNPJ", "Razão Social", "Endereço"));
            for (int i = 1; i <= clientes.size(); i++) {
                Cliente cliente = clientes.get(i - 1);
                System.out.println(String.format(linha, i, cliente.toString()));
            }
        }
        System.out.println("Indique o cliente que realizará a locação.");
        int cliente = t.nextInt();
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
}