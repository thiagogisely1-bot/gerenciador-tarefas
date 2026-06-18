# Gerenciador de Tarefas

Projeto backend em Spring Boot com Thymeleaf, JPA e PostgreSQL.

## Requisitos

- Java 17 ou superior
- Maven 3.9 ou superior, ou Maven Wrapper configurado
- PostgreSQL

## Banco de dados

Crie o banco antes de iniciar a aplicacao:

```sql
CREATE DATABASE freela_manager;
```

Confira usuario e senha em `src/main/resources/application.properties`.

## Rodar

Com Maven instalado:

```bash
mvn spring-boot:run
```

Depois acesse:

```text
http://localhost:8080/tarefas
```
