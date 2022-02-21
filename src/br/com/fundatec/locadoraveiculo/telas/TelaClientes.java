package br.com.fundatec.locadoraveiculo.telas;

import br.com.fundatec.locadoraveiculo.bancodedados.DadosClientes;
import br.com.fundatec.locadoraveiculo.enums.TipoDocumento;
import br.com.fundatec.locadoraveiculo.enums.TipoPessoa;
import br.com.fundatec.locadoraveiculo.model.Cliente;
import br.com.fundatec.locadoraveiculo.model.Endereco;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TelaClientes {

    private Scanner t = new Scanner(System.in);
    private DadosClientes dadosClientes = DadosClientes.criar();
    public void MostrarTelaClientes(){
        boolean decisão = true;
        while (decisão) {
            int resposta = 0;
            System.out.println("opção 1: cadastrar Clientes (Pessoa Física ou Pessoa Jurídica)");
            System.out.println("opção 2: listar Clientes");
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
                    System.out.println("esse cliente é uma pessoa fisica ou juridica?");
                    var tipoPessoa = this.lerTipoPessoa();
                    String razaoSocial = "";
                    long cnpj;
                    if (tipoPessoa.equals(TipoPessoa.JURIDICA)){
                        System.out.println("qual a sua razao social");
                        this.lerString();
                        System.out.println("qual o seu CNPJ");
                        cnpj = this.lerLong();
                        System.out.println("qual o numero do estabelecimento");
                        int numeroCasa = this.lerInt();
                        System.out.println("qual a rua em que ele se localiza??");
                        String logradouro = this.lerString();
                        System.out.println("Informe algum complemento");
                        String complemento = this.lerString();
                        System.out.println("qual o bairro?");
                        String bairro = this.lerString();
                        System.out.println("qual a cidade?");
                        String cidade = this.lerString();
                        System.out.println("qual a UF?");
                        String uf = this.lerString();
                        System.out.println("qual o CEP?");
                        Long cep = this.lerLong();
                        Endereco endereco = new Endereco(logradouro, numeroCasa, complemento, bairro, cidade, uf, cep);
                        this.cadastrarClienteJuridico( razaoSocial, cnpj, endereco);
                    } else if (tipoPessoa.equals(TipoPessoa.FISICA)) {
                        System.out.println("qual o nome do cliente a ser cadastrado?");
                        t.nextLine();
                        String nome = this.lerString();
                        System.out.println("qual o tipo do seu documento? CPF, CNH ou RG?");
                        var tipoDocumento = this.lerTipoDocumento();
                        System.out.println("qual o numero do seu documento?");
                        Long documento = this.lerLong();
                        System.out.println("qual o numero da casa?");
                        int numeroCasa = this.lerInt();
                        System.out.println("qual a rua?");
                        String logradouro = this.lerString();
                        System.out.println("Informe algum complemento");
                        String complemento = this.lerString();
                        System.out.println("qual o bairro?");
                        String bairro = this.lerString();
                        System.out.println("qual a cidade?");
                        String cidade = this.lerString();
                        System.out.println("qual a UF?");
                        String uf = this.lerString();
                        System.out.println("qual o CEP?");
                        Long cep = this.lerLong();
                        Endereco endereco = new Endereco(logradouro, numeroCasa, complemento, bairro, cidade, uf, cep);
                        this.cadastrarCliente(nome, tipoDocumento, documento, endereco);
                    }
                }
                case 2 -> {
                    System.out.println("lista de clientes");
                    this.listarClientes();
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

    }
    public void cadastrarCliente(String nomeCliente, TipoDocumento tipoDocumento, Long documento,
                                 Endereco endereco) {
        dadosClientes.adicionar(new Cliente(nomeCliente, tipoDocumento, documento, endereco));
    }
    public void cadastrarClienteJuridico( String razaoSocial, Long cnpj, Endereco endereco){
       dadosClientes.adicionar(new Cliente(razaoSocial, cnpj, endereco));
    }
    public void listarClientes() {
        for (Cliente elemento : dadosClientes.getClientes()){
            System.out.println("a seguir, a lista de clientes com suas informacoes");
            System.out.println(elemento.toString());
        }
        if (dadosClientes.getClientes().isEmpty()){
            System.out.println("ainda não existe nenhum cliente cadastrado");
        }
    }
    private TipoPessoa lerTipoPessoa() {
        while (true) {
            try {
                String tipoPessoa = t.next();
                return TipoPessoa.valueOf(tipoPessoa.toUpperCase());
            } catch (IllegalArgumentException excecao) {
                System.out.println(
                        "Tipo de pessoa invalida, digite uma das opções válidas. (FISICA ou JURIDICA)");
            }
        }
    }
    private TipoDocumento lerTipoDocumento() {
        while (true) {
            try {
                String tipoDocumento = t.next();
                return TipoDocumento.valueOf(tipoDocumento.toUpperCase());
            } catch (IllegalArgumentException excecao) {
                System.out.println(
                        "Tipo de documento inválido, digite uma das opções válidas. (CPF, CNH ou RG)");
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

    private Long lerLong() {
        while (true) {
            try {
                return t.nextLong();
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