package br.com.fundatec.locadoraveiculo.model;

import br.com.fundatec.locadoraveiculo.enums.TipoCarro;

public  class Veiculo {
    private String placa;
    private String marca;
    private String modelo;
    private double quilometragem;
    private double valorKmRodado;
    private double valorDiaria;
    private TipoCarro tipoCarro;

    public Veiculo(String placa, String marca, String modelo, double quilometragem, double valorKmRodado,
                   double valorDiaria, TipoCarro tipoCarro) {
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

    public double getQuilometragem() {return quilometragem;}

    public double getValorKmRodado() {return valorKmRodado;}

    public double getValorDiaria() {return valorDiaria;}

    public TipoCarro getTipoCarro() {return tipoCarro;}

    @Override
    public String toString() {
        return "Veiculo{" +
                "placa='" + placa + '\'' + ", marca='" + marca + '\'' + ", modelo='" + modelo + '\'' +
                ", quilometragem=" + quilometragem + ", valorKmRodado=" + valorKmRodado +
                ", valorDiaria=" + valorDiaria + ", tipoCarro=" + tipoCarro + '}';
    }
}
