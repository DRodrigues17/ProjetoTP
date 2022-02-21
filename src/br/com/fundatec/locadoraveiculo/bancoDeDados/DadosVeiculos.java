package br.com.fundatec.locadoraveiculo.bancoDeDados;

import br.com.fundatec.locadoraveiculo.model.Veiculo;

import java.util.LinkedList;
import java.util.List;

public class DadosVeiculos {

    private static DadosVeiculos instancia;
    private List<Veiculo> veiculos;

    private DadosVeiculos() {
        this.veiculos = new LinkedList<>();
    }
    public static DadosVeiculos criar(){
        if(instancia == null){
            instancia = new DadosVeiculos();
        }
        return instancia;
    }

    public void adicionar(Veiculo veiculo){
        this.veiculos.add(veiculo);
    }

    public List<Veiculo> getVeiculos() {return veiculos;}

    public Veiculo getVeiculoId(int i){return veiculos.get(i);}
}
