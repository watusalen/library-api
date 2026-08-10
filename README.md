# Library API - Projeto Prático de Gerenciamento de Biblioteca

Projeto de desenvolvimento de uma API RESTful para gerenciamento de acervo de biblioteca, elaborado com base nos conhecimentos adquiridos no curso de **Programação Orientada a Objetos com Java**, ministrado pelo **Prof. Nélio Alves**, com expansões de arquitetura e segurança.

---

## Sobre o Projeto e Motivação

O objetivo principal deste projeto foi consolidar e colocar em prática os fundamentos de Orientação a Objetos e desenvolvimento backend em Java, além de me desafiar a ir além do conteúdo visto em aula, explorando padrões de projeto e tecnologias utilizadas no mercado.

A aplicação simula o funcionamento completo de uma biblioteca, abrangendo o controle de acervo (livros, autores, categorias), gestão de usuários com diferentes níveis de acesso (`ADMIN` e `CLIENT`) e todo o fluxo de empréstimos e devoluções com validação de regras de negócio.

---

## Aprendizados e Conceitos Aplicados

### Conceitos de Java e Spring Boot
- **Programação Orientada a Objetos (POO)**: Encapsulamento, herança, polimorfismo, composição e modelos de domínio rico com comportamentos encapsulados nas entidades.
- **Arquitetura em Camadas**: Separação clara de responsabilidades entre `Controller`, `Service`, `Repository`, `Entity`, `DTO` (Requests/Responses) e `Mapper`.
- **Persistência de Dados**: Mapeamento objeto-relacional (ORM) com Spring Data JPA e Hibernate.
- **Tratamento Centralizado de Exceções**: Manipulação de erros de domínio e HTTP via `@RestControllerAdvice`.
- **Bean Validation**: Validação declarativa de contratos de entrada nos DTOs.

### Desafios e Pair Programming com IA
- **Autenticação e Autorização com JWT e Spring Security**: Esta foi a etapa mais desafiadora e complexa de todo o desenvolvimento. A configuração da cadeia de filtros do Spring Security e a implementação da emissão/validação stateless de tokens JWT foram realizadas em formato de *pair programming* com o assistente de IA (Antigravity). Essa cooperação permitiu entender o funcionamento de autenticação moderna em APIs REST sem comprometer a arquitetura do sistema.

---

## Estrutura de Documentação do Repositório

Toda a documentação técnica do projeto foi organizada dentro da pasta [`docs/`](docs/):

- [`docs/requisitos.md`](docs/requisitos.md): Requisitos funcionais (RF), não funcionais (RNF), regras de negócio (RN), casos de uso e contrato completo de endpoints HTTP.
- [`docs/arquitetura.md`](docs/arquitetura.md): Estrutura detalhada de pacotes, responsabilidades de cada camada e convenções de nomenclatura.
- [`docs/setup.md`](docs/setup.md): Instruções de inicialização, configuração de ambiente (Docker, PostgreSQL, H2), execução de testes automatizados e deploy em produção.

---

## Próximos Passos

Como evolução futura deste projeto, pretendo desenvolver uma interface web moderna utilizando **React**, consumindo todos os endpoints da Library API para proporcionar uma experiência visual completa aos usuários.