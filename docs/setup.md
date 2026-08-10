# Guia de Inicialização e Ambientes - Library API

## Sumário

- [1. Introdução](#1-introdução)
- [2. Pré-requisitos](#2-pré-requisitos)
- [3. Inicialização em ambiente de desenvolvimento](#3-inicialização-em-ambiente-de-desenvolvimento)
- [4. Execução de testes automatizados](#4-execução-de-testes-automatizados)
- [5. Configuração para ambiente de produção](#5-configuração-para-ambiente-de-produção)
- [6. Documentação OpenAPI / Swagger UI](#6-documentação-openapi--swagger-ui)

## 1. Introdução

Este documento especifica o procedimento de setup, configuração de variáveis de ambiente e execução do projeto Library API nos perfis de desenvolvimento (`dev`), teste (`test`) e produção (`prod`).

## 2. Pré-requisitos

| Requisito               | Versão recomendada     | Descrição                                       |
|-------------------------|------------------------|-------------------------------------------------|
| Java                    | JDK 21                 | Ambiente de execução Java                       |
| Maven                   | 3.9+ (ou via `./mvnw`) | Gerenciador de compilação e dependências        |
| Docker & Docker Compose | v2+                    | Provisionamento do PostgreSQL em ambiente local |

## 3. Inicialização em ambiente de desenvolvimento

O perfil padrão de desenvolvimento local é o `dev`, ativado em `src/main/resources/application.properties`.

### Passo 1: Iniciar o banco de dados PostgreSQL

Na raiz do repositório, execute o Docker Compose:

```bash
docker compose up -d
```

O container provisionará o PostgreSQL na porta `5432` com a base `library`, usuário `library_user` e senha `library_pass`.

### Passo 2: Executar a aplicação

Rode o comando Maven Wrapper para compilar e iniciar o servidor:

```bash
./mvnw spring-boot:run
```

A aplicação iniciará na porta `8080`. Em ambiente `dev`, o componente `DataSeeder` popula o banco de dados com usuários e empréstimos de demonstração.

**Credenciais dos usuários gerados:**
- Senha padrão para todos os usuários semeados: `senha123`
- Administradores: `admin1@library.com`, `admin2@library.com`
- Clientes: `cliente1@library.com`, `cliente2@library.com`

## 4. Execução de testes automatizados

Os testes automatizados utilizam a base de dados H2 em memória (`MODE=PostgreSQL`) e perfil `test`, não necessitando do container PostgreSQL em execução.

Para rodar toda a suíte de testes:

```bash
./mvnw test
```

## 5. Configuração para ambiente de produção

No perfil `prod`, a aplicação lê as configurações sensíveis via variáveis de ambiente, desativa a geração de SQL no log, define `ddl-auto=validate` e desabilita a execução do `DataSeeder`.

### Variáveis de ambiente exigidas

| Variável | Descrição | Exemplo / Padrão |
|---|---|---|
| `SPRING_PROFILES_ACTIVE` | Perfil ativo do Spring | `prod` |
| `SPRING_DATASOURCE_URL` | URL JDBC de conexão ao banco | `jdbc:postgresql://<host>:5432/<database>` |
| `SPRING_DATASOURCE_USERNAME` | Usuário do banco de dados | `library_user` |
| `SPRING_DATASOURCE_PASSWORD` | Senha do banco de dados | `senha_segura` |
| `JWT_SECRET` | Segredo para assinatura do JWT ($\ge 256$ bits) | `string_secreta_com_minimo_32_caracteres` |
| `PORT` | Porta HTTP do servidor | `8080` (opcional) |

Um modelo destas variáveis está disponível no arquivo `.env.example` na raiz do repositório.

### Compilação e execução do pacote de produção

1. Gere o arquivo JAR compilado:
```bash
./mvnw clean package -DskipTests
```

2. Execute o artefato gerado informando o perfil `prod`:
```bash
java -jar -Dspring.profiles.active=prod target/library-0.0.1-SNAPSHOT.jar
```

## 6. Documentação OpenAPI / Swagger UI

Com a aplicação em execução, a interface interativa da documentação Swagger UI está disponível no seguinte endereço:

`http://localhost:8080/swagger-ui.html`