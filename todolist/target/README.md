# ToDo List App

![Java](https://img.shields.io/badge/Java-11-blue)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-2.5.4-brightgreen)

## Descrição

Este é um aplicativo de gerenciamento de tarefas (To-Do List) desenvolvido em Java com Spring Boot. Ele permite que os usuários criem, visualizem, editem e excluam tarefas.

## Recursos

- Criar uma nova tarefa, fornecendo título, descrição, data de vencimento e prioridade.
- Visualizar a lista de tarefas cadastradas.
- Editar detalhes de uma tarefa existente.
- Excluir tarefas concluídas ou não desejadas.
- Marcar tarefas como concluídas.
- Armazenamento de dados no banco de dados MySQL.

## Tecnologias utilizadas

- Java 11
- Spring Boot 2.5.4
- MySQL

## Como executar o projeto

1. Clone o repositório para a sua máquina local:

```properties
git clone https://github.com/seu_usuario/todo-list-app.git
```

2. Certifique-se de ter o Java 11 e o MySQL instalados em sua máquina.

3. Configure o arquivo `application.properties` com as credenciais corretas do seu banco de dados MySQL:

```properties
spring.datasource.url=jdbc:mysql://localhost/to_do_list
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
```


4. Execute o projeto com o seguinte comando na raiz do projeto:

```properties
./mvnw spring-boot:run
```


5. O aplicativo estará disponível em [http://localhost:8080/todolist](http://localhost:8080/todolist).

## Endpoints

- `POST /todolist`: Cria uma nova tarefa.
- `GET /todolist`: Retorna a lista de tarefas cadastradas.
- `GET /todolist/{id}`: Retorna os detalhes de uma tarefa específica.
- `PUT /todolist`: Atualiza os detalhes de uma tarefa existente.
- `DELETE /todolist/{id}`: Desativa uma tarefa (não exclui permanentemente).

## Contribuição

Se você quiser contribuir com melhorias ou correções para o projeto, fique à vontade para abrir um pull request. Sua contribuição será muito bem-vinda!

