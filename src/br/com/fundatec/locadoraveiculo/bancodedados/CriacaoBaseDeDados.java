package br.com.fundatec.locadoraveiculo.bancoDeDados;


import br.com.fundatec.locadoraveiculo.enums.*;
import br.com.fundatec.locadoraveiculo.model.*;

public class CriacaoBaseDeDados {

    public static void inicializarBase() {
        cadastrarVeiculos();
        cadastrarClientes();
    }

    private static void cadastrarVeiculos() {
        DadosVeiculos cadastro = DadosVeiculos.criar();

        cadastro.adicionar(new Veiculo("ABC0001", "VW", "Gol", 0f, 5.0, 50.0, TipoCarro.HATCH));
        cadastro.adicionar(new Veiculo("ABC0002", "Fiat", "Palio", 0f, 5.0, 50.0, TipoCarro.HATCH));
        cadastro.adicionar(new Veiculo("ABC0003", "Chevrolet", "Onyx", 0f, 5.0, 50.0, TipoCarro.HATCH));
        cadastro.adicionar(new Veiculo("ABC0004", "Toyota", "Etios", 0f, 5.0, 50.0, TipoCarro.HATCH));
        cadastro.adicionar(new Veiculo("ABC0005", "Renault", "Sandero", 0f, 5.0, 50.0, TipoCarro.HATCH));
        cadastro.adicionar(new Veiculo("ABC0005", "Peugeot", "207", 0f, 5.0, 50.0, TipoCarro.HATCH));
        cadastro.adicionar(new Veiculo("ABC0006", "VW", "Virtus", 0f, 7.0, 60.0, TipoCarro.SEDAN));
        cadastro.adicionar(new Veiculo("ABC0007", "Fiat", "Siena", 0f, 7.0, 60.0, TipoCarro.SEDAN));
        cadastro.adicionar(new Veiculo("ABC0008", "Chevrolet", "Cobalt", 0f, 7.0, 60.0, TipoCarro.SEDAN));
        cadastro.adicionar(new Veiculo("ABC0009", "Toyota", "Corolla", 0f, 8.0, 65.0, TipoCarro.SEDAN));
        cadastro.adicionar(new Veiculo("ABC0010", "Renault", "Logan", 0f, 7.0, 60.0, TipoCarro.SEDAN));
        cadastro.adicionar(new Veiculo("ABC0011", "Jeep", "Compass", 0f, 11.0, 100.0, TipoCarro.SUV));
        cadastro.adicionar(new Veiculo("ABC0012", "VW", "T-Cross", 0f, 11.0, 95.0, TipoCarro.SUV));
        cadastro.adicionar(new Veiculo("ABC0013", "Hyundai", "Creta", 0f, 11.0, 95.0, TipoCarro.SUV));
        cadastro.adicionar(new Veiculo("ABC0014", "Honda", "HRV", 0f, 11.0, 95.0, TipoCarro.SUV));
        cadastro.adicionar(new Veiculo("ABC0015", "Ford", "Ranger", 0f, 12.5, 110.0, TipoCarro.PICKUP));
        cadastro.adicionar(new Veiculo("ABC0016", "VW", "Amarok", 0f, 12.0, 115.0, TipoCarro.PICKUP));
    }
    private static void cadastrarClientes() {
        DadosClientes cadastro = DadosClientes.criar();

        cadastro.adicionar(new Cliente("Gabriel", TipoDocumento.CNH, Long.valueOf("100568997") , new Endereco("Rua Silva", 139, "Apto 301", "Lindóia", "Porto Alegre", "RS", Long.valueOf("91039404"))));
        cadastro.adicionar(new Cliente("Luiz", TipoDocumento.CPF, Long.valueOf("01259866384"),  new Endereco("Rua Moura", 223, "Apto 301", "Humaitá", "Porto Alegre", "RS", Long.valueOf("91039404"))));
        cadastro.adicionar(new Cliente("Daniel", TipoDocumento.RG, Long.valueOf("36985742023"), new Endereco("Rua Costa", 1890, "Apto 301", "Centro", "Porto Alegre", "RS", Long.valueOf("91039404"))));
        cadastro.adicionar(new Cliente("Google", Long.valueOf("12321225211"),  new Endereco("Avenida Julho", 20, "Apto 122", "Lindóia", "Porto Alegre", "RS", Long.valueOf("91039404"))));
        cadastro.adicionar(new Cliente("Fundatec", Long.valueOf("42952093910"),  new Endereco("Avenida Cristovão", 930, "Apto 402", "Jardim São Pedro", "Porto Alegre", "RS", Long.valueOf("91039404"))));

    }
}