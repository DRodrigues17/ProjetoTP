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
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class TelaLocacoes {

    private Scanner t = new Scanner(System.in);
    DadosVeiculos dadosVeiculos = DadosVeiculos.criar();
    DadosClientes dadosClientes = DadosClientes.criar();
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
                case 1 -> {
                    this.cadastrarLocacao();
                }
                case 2 -> {
                    this.encerrarLocacao();
                }
                case 3 ->{
                    this.listarLocacoes();
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
    public void cadastrarLocacao() {
        Veiculo veiculos = selecionarVeiculo();
        if (veiculos != null) {
            Cliente clientes = selecionarCliente();
            if (clientes != null) {
                System.out.println("Diga a data de locacao (YYYY-MM-DD)");
                LocalDate dataLocacao = this.lerLocalDate();
                dadosLocacao.adicionar(new Locacao(clientes, veiculos, dataLocacao));
            }
        }
    }
    public void encerrarLocacao(){
        Locacao locacao = selecionarLocacao();
        if (locacao != null) {
            if (locacao.getSituacaoLocacao() == SituacaoLocacao.ENCERRADA) {
                System.out.println("selecione outra, pois essa ja foi encerrada");
            } else {
                System.out.println("qual a data de entrega (YYYY-MM-DD)");
                LocalDate dataEntrega = this.lerLocalDateEntrega();
                System.out.println("diga a atual quilometragem?");
                Float kmAtual = this.lerFloat();
                locacao.encerrar(dataEntrega, kmAtual);
            }
        }
    }
    private Veiculo selecionarVeiculo() {
        boolean teste = true;
        List<Veiculo> veiculos = dadosVeiculos.getVeiculos();
        if (veiculos.isEmpty()) {
            System.out.println("Ainda não foram cadastrados Veiculos");
        } else {
            while (teste) {
                for (int i = 1; i <= veiculos.size(); i++) {
                    Veiculo veiculo = veiculos.get(i - 1);
                    System.out.println(String.format(i + "-> " + veiculo.toString()));
                }
                System.out.println("Selecione um veículo.");
                int veiculoSelecionado = this.lerInt();
                int tamanhoLista = 0;
                for (Veiculo elemento : dadosVeiculos.getVeiculos()) {
                    tamanhoLista++;
                }
                if (tamanhoLista < veiculoSelecionado) {
                    System.err.println("opcao invalida");
                } else {
                    dadosVeiculos.getVeiculoId(veiculoSelecionado - 1);
                    System.out.println("o veiculo foi selecionado");
                    return veiculos.get(veiculoSelecionado - 1);
                }
            }
        }
        return  null;
    }
    private Cliente selecionarCliente() {
        boolean teste = true;
        List<Cliente> clientes = dadosClientes.getClientes();
        if (clientes.isEmpty()) {
            System.out.println("Ainda nao foram cadastrados clientes");
        } else {
            while (teste) {
                for (int i = 1; i <= clientes.size(); i++) {
                    Cliente cliente = clientes.get(i - 1);
                    System.out.println(String.format(i + "-> " + cliente.toString()));
                }
                System.out.println("Indique o cliente que realizara a locação.");
                int clienteSelecionado = this.lerInt();
                int tamanhoLista = 0;
                for ( Cliente elemento : dadosClientes.getClientes()) {
                    tamanhoLista++;
                }
                if (tamanhoLista < clienteSelecionado) {
                    System.err.println("opcao invalida");
                } else {
                    dadosClientes.getClienteId(clienteSelecionado - 1);
                    System.out.println("o cliente foi selecionado");
                    return clientes.get(clienteSelecionado - 1);
                }
            }
        }
        return null;
    }
    private Locacao selecionarLocacao() {
        List<Locacao> locacoes = dadosLocacao.getLocacoes();
        if (locacoes.isEmpty()) {
            System.err.println("Ainda não foram cadastradas locacoes");
        } else {
            for (int i = 1; i <= locacoes.size(); i++) {
                Locacao locacao = locacoes.get(i - 1);
                System.out.println(String.format(i + "-> " + locacao.toString()));
            }
            System.out.println("selecione a locacao a ser encerrada");
            int locacaoSelecionada = this.lerInt();
            dadosLocacao.getLocacaoId(locacaoSelecionada - 1);
            System.out.println("a locacao foi selecionada");
            return locacoes.get(locacaoSelecionada - 1);
        }
        return null;
    }
    private void listarLocacoes() {
        List<Locacao>  locacoes = dadosLocacao.getLocacoes();
        if (locacoes.isEmpty()) {
            System.out.println("Ainda não foram cadastradas locacoes");
        } else {
            for (int i = 1; i <= locacoes.size(); i++) {
                Locacao locacao = locacoes.get(i - 1);
                System.out.println(String.format(i + "-> " + locacao));
            }
        }
    }
    private LocalDate lerLocalDate(){
        while (true) {
            try {
                String dataLocacao = t.next();
                return LocalDate.parse(dataLocacao);
            } catch (DateTimeParseException excecao) {
                t.nextLine();
                System.err.println("!!!Digite uma data válida!!!");
            }
        }
    }
    private LocalDate lerLocalDateEntrega(){
        while (true) {
            try {
                String dataEntrega = t.next();
                return LocalDate.parse(dataEntrega);
            } catch (DateTimeParseException excecao) {
                t.nextLine();
                System.err.println("!!!Digite uma data válida!!!");
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
    private Float lerFloat() {
        while (true) {
            try {
                return t.nextFloat();
            } catch (InputMismatchException excecao) {
                t.nextLine();
                System.err.println("!!!Digite um valor valido!!!");
            }
        }
    }
}