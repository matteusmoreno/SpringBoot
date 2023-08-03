# XBank Project

XBank é um projeto de exemplo para uma aplicação de banco digital, onde os usuários podem criar contas, realizar transações, depositar e sacar dinheiro.

## Tecnologias utilizadas

- Java 11
- Spring Boot 2.5.3
- MySQL
- Spring Data JPA
- Spring Web
- Spring Cloud OpenFeign
- Lombok
- Hibernate Validator
- Feign para integração com API externa (ViaCep)

## Estrutura do projeto

O projeto está dividido em módulos:

- **xbank**: Contém a aplicação Spring Boot principal e as configurações gerais do projeto.
- **xbank-client**: Módulo relacionado às funcionalidades de gerenciamento de clientes, incluindo CRUD e validações.
- **xbank-account**: Módulo relacionado às funcionalidades de gerenciamento de contas bancárias, incluindo CRUD, transações, depósitos e saques.

## Como executar

### Requisitos

- Java 11
- MySQL (ou outro banco de dados compatível)
- Uma IDE Java (por exemplo, IntelliJ, Eclipse) ou o Maven instalado para executar via linha de comando.

### Configuração do banco de dados

Certifique-se de que você tenha um banco de dados MySQL configurado e apropriado. As configurações de conexão com o banco de dados são definidas no arquivo `application.properties` dentro do módulo `xbank`. Verifique e ajuste as configurações, se necessário:

```properties
spring.datasource.url=jdbc:mysql://localhost/xbank?createDatabaseIfNotExist=true
spring.datasource.username=root
spring.datasource.password=your_password_here
```


### Executando o projeto

1. Clone o repositório do GitHub para o seu ambiente local.
2. Importe o projeto para a sua IDE favorita (se estiver utilizando uma).
3. Certifique-se de que o banco de dados esteja configurado e ativo.
4. Execute a classe `XbankApplication` localizada no módulo `xbank` para iniciar o projeto.

### Endpoints da API

A API do XBank possui os seguintes endpoints principais:

- `POST /client`: Criação de um novo cliente.
- `GET /client`: Lista todos os clientes ativos.
- `GET /client/{id}`: Exibe os detalhes de um cliente específico.
- `PUT /client/{id}`: Atualiza o nome do cliente específico.
- `DELETE /client/desactivate/{id}`: Desativa um cliente específico.
- `DELETE /client/activate/{id}`: Ativa um cliente específico.

- `POST /account`: Criação de uma nova conta.
- `GET /account`: Lista todas as contas ativas.
- `GET /account/{id}`: Exibe os detalhes de uma conta específica.
- `PUT /account/{id}`: Atualiza o status de uma conta específica para ativo.
- `DELETE /account/desactivate/{id}`: Desativa uma conta específica.
- `DELETE /account/activate/{id}`: Ativa uma conta específica.
- `POST /transaction/transfer`: Realiza uma transferência entre contas.
- `POST /transaction/deposit`: Realiza um depósito em uma conta específica.
- `POST /transaction/withdraw`: Realiza um saque de uma conta específica.

## Observações

Este projeto é apenas um exemplo didático e não foi implementado em um ambiente de produção. Não foram adicionados recursos como autenticação, autorização ou segurança. Lembre-se de configurar corretamente todas as camadas de segurança e autenticação ao desenvolver um sistema real.

