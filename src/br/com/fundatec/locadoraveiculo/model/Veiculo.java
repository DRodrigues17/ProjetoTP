package br.com.fundatec.locadoraveiculo.model;

import br.com.fundatec.locadoraveiculo.enums.TipoCarro;

public  class Veiculo {
    private String placa;
    private String marca;
    private String modelo;
    private Float quilometragem;
    private Double valorKmRodado;
    private Double valorDiaria;
    private TipoCarro tipoCarro;

    public Veiculo(String placa, String marca, String modelo, Float quilometragem, Double valorKmRodado,
                   Double valorDiaria, TipoCarro tipoCarro) {
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.quilometragem = quilometragem;
        this.valorKmRodado = valorKmRodado;
        this.valorDiaria = valorDiaria;
        this.tipoCarro = tipoCarro;
    }

    public String getPlaca() {return placa;}

    public String getMarca() {return marca;}

    public String getModelo() {return modelo;}

    public Float getQuilometragem() {return quilometragem;}

    public Double getValorKmRodado() {return valorKmRodado;}

    public Double getValorDiaria() {return valorDiaria;}

    public TipoCarro getTipoCarro() {return tipoCarro;}

    public void alterarQuilometragem(Float kmAtual){
        this.quilometragem = kmAtual;
    }

    @Override
    public String toString() {
        return "Veiculo{" +
                "placa='" + placa + '\'' + ", marca='" + marca + '\'' + ", modelo='" + modelo + '\'' +
                ", quilometragem=" + quilometragem + ", valorKmRodado=" + valorKmRodado +
                ", valorDiaria=" + valorDiaria + ", tipoCarro=" + tipoCarro + '}';
    }
}
