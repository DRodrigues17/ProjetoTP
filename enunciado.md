# Enunciado

# Diagrama

![dg-locadora](https://user-images.githubusercontent.com/91800053/224428713-e1fa70c0-c946-49d6-b9c8-ce2ce12ebce3.png)

## Entrega 1

### Pacotes
- br.com.fundatec.locadoraveiculo
- br.com.fundatec.locadoraveiculo.bancodedados
- br.com.fundatec.locadoraveiculo.enums
- br.com.fundatec.locadoraveiculo.model
- br.com.fundatec.locadoraveiculo.tela

### Classe Principal
- LocadoraVeiculo: responsável por iniciar e finalizar o programa.

### Telas
1. Tela Principal
	- Funcionalidades:
	  - opção 1: apresentar Tela de Veículos 
	  - opção 2: apresentar Tela de Clientes
	  - opção 3: apresentar Tela de Locações
	  - opção 0: Encerrar Programa (retornando à classe principal)
	  
2. Tela de Veículos
	- Funcionalides:
		- opção 1: cadastrar Veículos (Carro, Moto ou Caminhão)
		- opção 2: listar Veículos
		- opção 0: retornar ao Menu Principal
		
3. Tela de Clientes
	- Funcionalides:
		- opção 1: cadastrar Clientes (Pessoa Física ou Pessoa Jurídica)
		- opção 2: listar Clientes
		- opção 0: retornar ao Menu Principal
		
4. Tela de Locações
	- Funcionalides
		- opção 1: cadastrar Locações
		- opção 2: encerrar Locações
		- opção 3: listar Locações
		- opção 0: retornar ao Menu Principal

### Classes
- Veiculo
  - atributos:
   - placa: String
   - marca: String
   - modelo: String
   - tipoVeiculo: TipoVeiculo
   - kilometragem: float
   - valorKmRodado: Double
   - valorDiaria: Double
- Cliente
  - atributos:
   - tipoPessoa: TipoPessoa
   - nome: String
   - documento: Long
   - tipoDocumento: TipoDocumento
   - razaoSocial: String
   - cnpj: Long
   - endereco: Endereco
- Endereco
  - atributos:
   - logradouro: String
   - numero: Integer
   - complemento: String
   - bairro: String
   - cidade: String
   - uf: String
   - cep: Integer
### Classes de Enumeração (Enum)
 - TipoVeiculo
   - HATCH
   - SEDAN
   - SUV
   - PICKUP
- TipoDocumento
   - CPF
   - CNH
   - RG
- TipoPessoa
   - FISICA
   - JURIDICA

## Entrega 2

### Classes
- Locacao
  -Atributos:
   - cliente: Cliente
   - veiculo: Veiculo
   - dataLocacao: LocalDate
   - dataEntrega: LocalDate
   - valor: BigDecimal
   - situacao: SituacaoLocacao
### Enums
- SituacaoLocacao
   - ATIVA
   - ENCERRADA
### Regras
1. Cadastrar Locação
   - Deve ser indicado um cliente
   - Deve ser indicado um veículo
   - Deve ser informada a data de locação
   - Data de entrega deve ser nula
   - Valor deve nulo
   - Situação deve ser ATIVA
2. Encerrar locação
   - Só deve poder ser encerrada locações ativas
   - Deve receber como parâmetro a kilometragem atual do veículo
   - Ao encerrar a locação devemos:
   - Informar kilometragem atual do veículo
   - Informar a Data de entrega
   - Situação da locação deve ser alterado para ENCERRADA
   - Deve ser calculado o valor da locação que será dado pela fórmula: (valorDiaria * número de diárias) + ((kmAtual - kmAnterior) * valorKmRodado)
   - Atualizar kilometragem do veículo
3. Listar locações
   - Listar locações (como lista de veículos e lista de clientes)


### O que será avaliado?
1. Cadastro de veículos
2. Listagem de veículos
   - Quando não houver veículos cadastrados, deve ser mostrada uma mensagem: "Ainda não há veículos cadastrados".
3. Cadastro de clientes
   - Quando escolhido pessoa física, incluir somente os dados de pessoa física
   - Quando escolhido pessoa jurídica, incluir somente os dados de pessoa jurídica
4. Listagem de clientes
   - Quando não houver clientes cadastrados, deve ser mostrada uma mensagem: "Ainda não há clientes cadastrados".
5. Cadastro de Locação
   - Atenção aos dados informados no momento da criação da mesma
6. Encerramento de Locação
   - Deve alterar a situação da locação para FINALIZADA
   - Deve calcular e mostrar o valor da locação
   - Deve atualizar a kilometragem do veículo
7. Além das funcionalidades acima, devem ser validados todos dados de entrada (lidos de teclado) que não sejam String, em todos menus. O sistema não deve gerar exceção na leitura de dados
8. Mantenham uma identação correta, nomes de pacotes, classes e variáveis
9. E por último, um ponto bem importante é: cuidado com o encapsulamento de variáveis e métodos. Criem somente métodos que irão utilizar. Substituam getters/setters por métodos contrutores e somente utilizem getters/setters se houver necessidade.
