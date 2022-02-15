package br.com.fundatec.locadoraveiculo.telas;

import br.com.fundatec.locadoraveiculo.bancoDeDados.DadosClientes;
import br.com.fundatec.locadoraveiculo.enums.TipoDocumento;
import br.com.fundatec.locadoraveiculo.enums.TipoPessoa;
import br.com.fundatec.locadoraveiculo.model.Cliente;
import br.com.fundatec.locadoraveiculo.model.Endereco;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TelaDeClientes {

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
                    System.out.println("qual o nome do cliente a ser cadastrado?");
                    t.nextLine();
                    String nome = t.nextLine();
                    System.out.println("esse cliente é uma pessoa fisica ou juridica?");
                    System.out.println("PESSOA_FISICA ou PESSOA_JURIDICA? digite tal como lhe foi mostrado");
                    var tipoPessoa = TipoPessoa.valueOf(t.next());
                    String razaoSocial;
                    if (tipoPessoa.equals(TipoPessoa.PESSOA_JURIDICA)){
                        System.out.println("qual a sua razao social");
                        t.nextLine();
                        razaoSocial = t.nextLine();
                    } else{
                        razaoSocial = "NAO TEM";
                    }
                    System.out.println("qual o tipo do seu documento?");
                    System.out.println("CPF, CNPJ ou RG?");
                    var tipoDocumento = TipoDocumento.valueOf(t.next());
                    System.out.println("qual o numero do seu documento?");
                    Long documento = t.nextLong();
                    System.out.println("qual o numero da casa?");
                    int numeroCasa = t.nextInt();
                    t.nextLine();
                    System.out.println("qual o endereco do cliente ?");
                    String logradouro = t.nextLine();
                    System.out.println("Informe algum complemento");
                    String complemento = t.nextLine();
                    System.out.println("qual o bairro?");
                    String bairro = t.nextLine();
                    System.out.println("qual a cidade?");
                    String cidade = t.nextLine();
                    System.out.println("qual a UF ?");
                    String uf = t.next().toUpperCase();
                    System.out.println("qual o CEP?");
                    int cep = t.nextInt();
                    Endereco endereco = new Endereco(logradouro, numeroCasa, complemento, bairro, cidade, uf, cep);
                    this.cadastrarCliente(nome, tipoPessoa, tipoDocumento, documento, razaoSocial, endereco);
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
    public void cadastrarCliente(String nomeCliente, TipoPessoa tipoPessoa, TipoDocumento tipoDocumento, Long documento,
                                 String razaoSocial, Endereco endereco) {
        dadosClientes.adicionar(new Cliente(nomeCliente, tipoPessoa, tipoDocumento, documento, razaoSocial, endereco));
    }
    public void listarClientes() {
        for (Cliente elemento : dadosClientes.getClientes()){
            System.out.println("as informacoes a seguir sao, nome do cliente, tipo de pessoa, tipo de documento, " +
                    "documento, razao social, do cliente e endereco do cliente");
            System.out.println(elemento.getNome()+", "+elemento.getTipoPessoa()+", "+elemento.getTipoDocumento()+", "+
                    elemento.getDocumento()+", "+elemento.getRazaoSocial()+", "+elemento.getEndereco().getLogradouro()
                    +", "+elemento.getEndereco().getNumeroCasa()+", "+elemento.getEndereco().getComplemento()
                    +", "+elemento.getEndereco().getBairro()+", "+elemento.getEndereco().getCidade()
                    +", "+elemento.getEndereco().getUf()+", "+elemento.getEndereco().getCep());
        }
    }
}