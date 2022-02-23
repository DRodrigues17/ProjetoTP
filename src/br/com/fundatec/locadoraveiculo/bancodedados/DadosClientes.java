package br.com.fundatec.locadoraveiculo.bancodedados;

import br.com.fundatec.locadoraveiculo.enums.TipoDocumento;
import br.com.fundatec.locadoraveiculo.model.Cliente;
import br.com.fundatec.locadoraveiculo.model.Endereco;

import java.util.LinkedList;
import java.util.List;

public class DadosClientes {

    private static DadosClientes instancia;
    private List<Cliente> clientes;

    private DadosClientes() {
        this.clientes = new LinkedList<>();
        cadastrarClientes();
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

    public Cliente getClienteId(int i) {return clientes.get(i);}

    private void cadastrarClientes() {
        clientes.add(new Cliente("Ezilmar", TipoDocumento.CNH, 95173392L, new Endereco("Rua das laranjeiras", 18674, "casa sem reboco", "JD Carvalho", "Porto Alegre", "RS", 95173392L)));
        clientes.add(new Cliente("Daniel", TipoDocumento.CPF, 995173392L,  new Endereco("Rua dos andradas", 223, "", "centro histórico", "Porto Alegre", "RS", 95173392L)));
        clientes.add(new Cliente("Moacir", TipoDocumento.RG, 95173392L, new Endereco("rua 20", 1890, "Apto 301", "IPE 2", "Porto Alegre", "RS", 95173392L)));
        clientes.add(new Cliente("Fundatec", 95173392L,  new Endereco("cristiano fisher", 930, "Apto 402", "Jardim São Pedro", "Porto Alegre", "RS", 95173392L)));

    }
}
