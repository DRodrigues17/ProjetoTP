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

    public Locacao(Cliente cliente, Veiculo veiculo, LocalDate dataLocacao, SituacaoLocacao situacaoLocacao) {
        this.cliente = cliente;
        this.veiculo = veiculo;
        this.dataLocacao = dataLocacao;
        this.situacaoLocacao = situacaoLocacao;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public LocalDate getDataLocacao() {
        return dataLocacao;
    }

    public SituacaoLocacao getSituacaoLocacao() {
        return situacaoLocacao;
    }

    @Override
    public String toString() {
        return "Locacao [cliente=" + cliente.toString() + ", dataEntrega=" + dataEntrega + ", dataLocacao=" + dataLocacao
                + ", situacao=" + situacaoLocacao + ", valor=" + valor + ", veiculo=" + veiculo.toString() + "]";
    }
}