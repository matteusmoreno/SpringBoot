# Library Management System

[![Java](https://img.shields.io/badge/Java-11-blue)](https://www.java.com/)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-2.5.4-brightgreen)](https://spring.io/projects/spring-boot)
[![MySQL](https://img.shields.io/badge/MySQL-8-blue)](https://www.mysql.com/)

## Descrição

Este é um sistema de gerenciamento de uma biblioteca, desenvolvido em Java com Spring Boot. O sistema permite cadastrar, listar, atualizar e inativar livros na biblioteca.

## Recursos

- Cadastrar um novo livro com título, autor, editora e ano de publicação.
- Listar livros disponíveis para empréstimo.
- Listar livros indisponíveis (inativos).
- Atualizar informações de um livro existente.
- Inativar um livro (torná-lo indisponível).
- Ativar um livro (torná-lo disponível novamente).

## Tecnologias utilizadas

- Java 11
- Spring Boot 2.5.4
- MySQL 8

## Como executar o projeto

1. Clone o repositório para a sua máquina local:

```properties
git clone https://github.com/seu_usuario/library-management.git
```


2. Certifique-se de ter o Java 11 e o MySQL 8 instalados em sua máquina.

3. Configure o arquivo `application.properties` com as credenciais corretas do seu banco de dados MySQL:

```properties
spring.datasource.url=jdbc:mysql://localhost/library
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
```


4. Execute o projeto com o seguinte comando na raiz do projeto:

```properties
./mvnw spring-boot:run
```


5. O sistema estará disponível em [http://localhost:8080/livros](http://localhost:8080/livros).

## Endpoints

- `POST /livros`: Cadastrar um novo livro.
- `GET /livros/ativos`: Listar livros disponíveis.
- `GET /livros/inativos`: Listar livros indisponíveis.
- `PUT /livros`: Atualizar informações de um livro.
- `DELETE /livros/desativar/{id}`: Inativar um livro.
- `DELETE /livros/ativar/{id}`: Ativar um livro.

## Contribuição

Se você quiser contribuir com melhorias ou correções para o projeto, fique à vontade para abrir um pull request. Sua contribuição será muito bem-vinda!

