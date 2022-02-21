package br.com.fundatec.locadoraveiculo.model;

import br.com.fundatec.locadoraveiculo.enums.TipoDocumento;
import br.com.fundatec.locadoraveiculo.enums.TipoPessoa;

public class Cliente {
    private String nome;
    private TipoPessoa tipoPessoa;
    private TipoDocumento tipoDocumento;
    private Long documento;
    private String razaoSocial;
    private Long cnpj;
    private Endereco endereco;

    public Cliente(String nome, TipoDocumento tipoDocumento, Long documento, Endereco endereco) {
        this.nome = nome;
        this.tipoPessoa = TipoPessoa.FISICA;
        this.tipoDocumento = tipoDocumento;
        this.documento = documento;
        this.endereco = endereco;
    }

    public Cliente(String razaoSocial, Long cnpj, Endereco endereco) {
        this.tipoPessoa = TipoPessoa.JURIDICA;
        this.razaoSocial = razaoSocial;
        this.cnpj = cnpj;
        this.endereco = endereco;
    }

    @Override
    public String toString() {
        if (tipoPessoa.equals((TipoPessoa.FISICA))) {
            return "Cliente{" +
                    "nome = '" + nome + '\'' + ", tipoDocumento = " + tipoDocumento + ", documento = " + documento +
                    ", endereco = " + endereco.getLogradouro() + ", " + endereco.getNumeroCasa() + ", " +
                    endereco.getComplemento() + ", " + endereco.getBairro() + ", " + endereco.getCidade() + ", " +
                    endereco.getUf() + ", " + endereco.getCep() + '}';
        } else if (tipoPessoa.equals(TipoPessoa.JURIDICA)) {
            return "Cliente{" +
                    "razaoSocial = " + razaoSocial + ", cnpj = " + cnpj +
                    ", endereco = " + endereco.getLogradouro() + ", " + endereco.getNumeroCasa() + ", " +
                    endereco.getComplemento() + ", " + endereco.getBairro() + ", " + endereco.getCidade() + ", " +
                    endereco.getUf() + ", " + endereco.getCep() + '}';
        }
        return null;
    }

}
