package br.com.fundatec.locadoraveiculo;

import br.com.fundatec.locadoraveiculo.bancoDeDados.CriacaoBaseDeDados;
import br.com.fundatec.locadoraveiculo.telas.TelaPrincipal;

public class LocadoraVeiculo {

    public static void main(String[] args) {
        CriacaoBaseDeDados.inicializarBase();
        TelaPrincipal telaPrincipal = new TelaPrincipal();
        telaPrincipal.MostrarMenu();
    }
}

