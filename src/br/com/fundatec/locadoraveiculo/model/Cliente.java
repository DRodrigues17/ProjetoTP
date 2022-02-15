package br.com.fundatec.locadoraveiculo.model;

import br.com.fundatec.locadoraveiculo.enums.TipoDocumento;
import br.com.fundatec.locadoraveiculo.enums.TipoPessoa;

public class Cliente {
    private String nome;
    private TipoPessoa tipoPessoa;
    private TipoDocumento tipoDocumento;
    private Long documento;
    private String razaoSocial;
    private Endereco endereco;

    public Cliente( String nome, TipoPessoa tipoPessoa, TipoDocumento tipoDocumento,
                    Long documento, String razaoSocial, Endereco endereco) {
        this.nome = nome;
        this.tipoPessoa = tipoPessoa;
        this.tipoDocumento = tipoDocumento;
        this.documento = documento;
        this.razaoSocial = razaoSocial;
        this.endereco = endereco;
    }


    public String getNome() {return nome;}

    public TipoPessoa getTipoPessoa() {return tipoPessoa;}

    public TipoDocumento getTipoDocumento() {return tipoDocumento;}

    public Long getDocumento() {return documento;}

    public String getRazaoSocial() {return razaoSocial;}

    public Endereco getEndereco() {return endereco;}
}
