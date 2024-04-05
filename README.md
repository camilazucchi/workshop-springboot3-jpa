# Projeto Web Services com Spring Boot e JPA/Hibernate
Este projeto foi realizado durante o curso de Java completo pela <a href="https://www.udemy.com/course/java-curso-completo">DevSuperior</a>.

## Objetivos
- Criar projeto Spring Boot com Spring Initializr
- Implementar o modelo de domínio
- Estruturar camadas lógicas: resource, service e repository
- Configurar banco de dados de teste (H2)
- Povoar o banco de dados
- Realizar um CRUD - Create, Retrieve, Update e Delete
- Implementar tratamento de exceções personalizadas

## Tecnologias utilizadas
- Spring Boot
- Apache Tomcat
- Maven
- H2
- Postman
- PostgreSQL

## Instalação
Para rodar o projeto na sua máquina é necessário:
1. Clonar o projeto utilizando o comando ``git clone https://github.com/camilazucchi/workshop-springboot3-jpa``
2. Abrir o projeto clonado
3. Iniciar o projeto Spring através da classe ``CourseApplication``
4. Abrir o banco de dados H2 através da URL disponibilizada no arquivo ``application-test.properties``

## Uso
Após iniciar o projeto, você pode realizar chamadas de API utilizando o Postman, para criar, recuperar, atualizar e excluir recursos. Por exemplo:
- Para recuperar os usuários: GET /users
- Para recuperar os pedidos: GET /orders
- Para recuperar as categorias: GET categories
- Para recuperar os produtos: GET /products
- Para cadastrar um usuário: PUT /users
- Para atualizar um usuário: PUT /users/{id}
- Para deletar um usuário: DELETE /users/{id}