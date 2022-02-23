package br.com.fundatec.locadoraveiculo.model;

import br.com.fundatec.locadoraveiculo.enums.SituacaoLocacao;

import java.lang.instrument.UnmodifiableModuleException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Locacao {
    private Cliente cliente;
    private Veiculo veiculo;
    private LocalDate dataLocacao;
    private LocalDate dataEntrega = null;
    private BigDecimal valor = null;
    private SituacaoLocacao situacaoLocacao;

    public Locacao(Cliente cliente, Veiculo veiculo, LocalDate dataLocacao) {
        this.cliente = cliente;
        this.veiculo = veiculo;
        this.dataLocacao = dataLocacao;
        this.situacaoLocacao = SituacaoLocacao.ATIVA;
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

    public BigDecimal getValor() {return valor;}

    public SituacaoLocacao getSituacaoLocacao() {
        return situacaoLocacao;
    }

    public void encerrar(LocalDate dataEntrega, Float kmAtual){
        this.situacaoLocacao = SituacaoLocacao.ENCERRADA;

        Long numeroDiarias = ( ChronoUnit.DAYS.between(dataLocacao, dataEntrega) + 1);
        this.dataEntrega = dataEntrega;
        Float diferenca = kmAtual.floatValue() - veiculo.getQuilometragem().floatValue();
        BigDecimal diarias = new BigDecimal((numeroDiarias));
        BigDecimal valorDiaria = new BigDecimal(veiculo.getValorDiaria().toString());
        BigDecimal km = new BigDecimal(diferenca.toString());
        BigDecimal valorKm = new BigDecimal(veiculo.getValorKmRodado());
        this.valor = diarias.multiply(valorDiaria).add(km.multiply(valorKm));

        veiculo.alterarQuilometragem(kmAtual);
        System.out.println(" a diferenca na quilometragem e " + diferenca);
        System.out.println("o numero de diarias e " + diarias);
        System.out.println("o valor por diaria é " + valorDiaria);
        System.out.println("o valor por quilometragem é " + valorKm);
        System.out.println(" a locacao esta encerrada e seu valor é " + valor);
    }

    @Override
    public String toString() {
        return "Locacao [cliente=" + cliente.toString() + ", dataEntrega=" + dataEntrega + ", dataLocacao=" + dataLocacao
                + ", situacao=" + situacaoLocacao + ", valor=" + valor + ", veiculo=" + veiculo.toString() + "]";
    }
}