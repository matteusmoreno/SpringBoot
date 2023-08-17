# Projeto Pokedex

Este projeto é um exercício educacional focado na construção de uma API Pokedex usando Spring Boot e MySQL. O aplicativo fornece endpoints para registrar, atualizar, listar e gerenciar dados de Pokémon.

![Java](https://img.shields.io/badge/Java-17-blue)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.1.2-brightgreen)
![MySQL](https://img.shields.io/badge/MySQL-8-blue)
![Swagger](https://img.shields.io/badge/Swagger-2.2.0-orange)

## Tecnologias Utilizadas

- [Java](https://www.java.com/)
- [Spring Boot](https://spring.io/projects/spring-boot)
- [MySQL](https://www.mysql.com/)
- [Swagger](https://swagger.io/)

## Funcionalidades

- Registrar novo Pokémon com detalhes como nome, tipo, descrição e foto.
- Atualizar detalhes de Pokémon.
- Listar todos os Pokémon ativos.
- Obter detalhes de Pokémon por ID ou nome.
- Ativar ou desativar Pokémon.

## Começando

1. Clone este repositório:

   git clone https://github.com/matteusmoreno/pokedex.git

2. Crie um banco de dados MySQL chamado `pokedex`.

3. Configure a conexão MySQL em `src/main/resources/application.properties`:

   spring.datasource.url=jdbc:mysql://localhost/pokedex
   spring.datasource.username=seu-nome-de-usuário
   spring.datasource.password=sua-senha

4. Compile e execute o aplicativo:

   ./mvnw spring-boot:run

5. Acesse a documentação do Swagger em [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html) para interagir com a API.

## Endpoints

- POST /pokemon/register - Registrar um novo Pokémon.
- GET /pokemon/listall - Listar todos os Pokémon ativos.
- GET /pokemon/getpokemonbyid/{id} - Obter detalhes de Pokémon por ID.
- GET /pokemon/getpokemonbyname/{name} - Obter detalhes de Pokémon por nome.
- PUT /pokemon/update - Atualizar detalhes de Pokémon.
- DELETE /pokemon/desactivate/{id} - Desativar um Pokémon.
- DELETE /pokemon/activate/{id} - Ativar um Pokémon.

## Contribuidores

Este projeto é mantido por [Matteus Moreno](https://github.com/matteusmoreno).

## Licença

Este projeto está licenciado sob a Licença MIT. Sinta-se à vontade para usar e modificar o código para fins educacionais.
