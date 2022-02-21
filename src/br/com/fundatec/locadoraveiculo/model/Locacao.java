package br.com.fundatec.locadoraveiculo.model;

import br.com.fundatec.locadoraveiculo.enums.SituacaoLocacao;
import java.math.BigDecimal;
import java.time.LocalDate;

public class Locacao {
    private Cliente cliente;
    private Veiculo veiculo;
    private LocalDate dataLocacao;
    private LocalDate dataEntrega = null;
    private BigDecimal valor = null;
    private SituacaoLocacao situacaoLocacao;

    public Locacao(Cliente cliente, Veiculo veiculo, LocalDate dataLocacao,
                   LocalDate dataEntrega, BigDecimal valor, SituacaoLocacao situacaoLocacao) {
        this.cliente = cliente;
        this.veiculo = veiculo;
        this.dataLocacao = dataLocacao;
        this.dataEntrega = dataEntrega;
        this.valor = valor;
        this.situacaoLocacao = situacaoLocacao;
    }

    public Cliente getCliente() {return cliente;}

    public Veiculo getVeiculo() {return veiculo;}

    public LocalDate getDataLocacao() {return dataLocacao;}

    public LocalDate getDataEntrega() {return dataEntrega;}

    public BigDecimal getValor() {return valor;}

    public SituacaoLocacao getSituacaoLocacao() {return situacaoLocacao;}
}