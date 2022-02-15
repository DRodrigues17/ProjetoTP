package br.com.fundatec.locadoraveiculo.model;

public class Endereco {
    private String logradouro;
    private int numeroCasa;
    private  String complemento;
    private String bairro;
    private String cidade;
    private String uf;
    private int cep;

    public Endereco(String logradouro, int numeroCasa, String complemento,
                    String bairro, String cidade, String uf, int cep) {
        this.logradouro = logradouro;
        this.numeroCasa = numeroCasa;
        this.complemento = complemento;
        this.bairro = bairro;
        this.cidade = cidade;
        this.uf = uf;
        this.cep = cep;
    }

    public String getLogradouro() {return logradouro;}

    public int getNumeroCasa() {return numeroCasa;}

    public String getComplemento() {return complemento;}

    public String getBairro() {return bairro;}

    public String getCidade() {return cidade;}

    public String getUf() {return uf;}

    public int getCep() {return cep;}


}
