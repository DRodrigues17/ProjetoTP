package br.com.fundatec.locadoraveiculo.bancodedados;

import br.com.fundatec.locadoraveiculo.enums.TipoCarro;
import br.com.fundatec.locadoraveiculo.model.Veiculo;

import java.util.LinkedList;
import java.util.List;

public class DadosVeiculos {

    private static DadosVeiculos instancia;
    private List<Veiculo> veiculos;

    private DadosVeiculos() {
        this.veiculos = new LinkedList<>();
        cadastrarVeiculos();
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

    private void cadastrarVeiculos() {
        veiculos.add(new Veiculo("ABC0001", "Fiat", "palio", 0f, 5.0, 50.0, TipoCarro.HATCH));
        veiculos.add(new Veiculo("ABC0002", "Chevrolet", "agile", 0f, 5.0, 50.0, TipoCarro.HATCH));
        veiculos.add(new Veiculo("ABC0003", "Chevrolet", "Onyx", 0f, 5.0, 50.0, TipoCarro.HATCH));
        veiculos.add(new Veiculo("ABC0004", "Subaru", "WRX", 0f, 5.0, 50.0, TipoCarro.HATCH));
        veiculos.add(new Veiculo("ABC0005", "Chevrolet", "monza", 0f, 5.0, 50.0, TipoCarro.HATCH));
    }
}
