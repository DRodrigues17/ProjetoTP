package br.com.fundatec.locadoraveiculo.bancoDeDados;

import br.com.fundatec.locadoraveiculo.model.Cliente;

import java.util.LinkedList;
import java.util.List;

public class DadosClientes {

    private static DadosClientes instancia;
    private List<Cliente> clientes;

    private DadosClientes() {
        this.clientes = new LinkedList<>();
    }
    public static DadosClientes criar(){
        if(instancia == null){
            instancia = new DadosClientes();
        }
        return instancia;
    }

    public void adicionar(Cliente cliente){
        this.clientes.add(cliente);
    }

    public List<Cliente> getClientes() {return clientes;}
}
