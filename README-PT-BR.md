The README you are accessing is in Portuguese-BR, if you prefer to access the README in English, [click here](README.md)

# Developer Allocator

Este projeto é uma **API** construída com **Java e Spring**, projetada para gerenciar o relacionamento entre **Desenvolvedores** e **Projetos**.
A API foi implementada seguindo as melhores práticas de arquitetura, documentação e controle de versão.

## Relacionamento entre Entidades
- Um **Desenvolvedor** pode ser vinculado a apenas **um Projeto**.
- Um **Projeto** pode conter **vários Desenvolvedores**.
- Relacionamento: **Um-Para-Muitos** (Projeto → Desenvolvedores).

## Tecnologias Utilizadas
- **Java e Spring** – desenvolvimento robusto e escalável
- **Swagger** – documentação de API clara e interativa
- **Banco de Dados H2** – testes rápidos e eficientes
- **Migração** – versionamento de banco de dados
- **Git e GitHub** – controle de versão de código-fonte
- **Arquitetura em Camadas** – separação de responsabilidades e código organizado

- ## Estrutura do Projeto
- `controller/` → Camada da API
- `service/` → Lógica de negócio
- `repository/` → Acesso e persistência de dados
- `model/` → Definições de entidades

## Documentação
1. Clone este repositório:
   ```bash
   git clone https://github.com/PedroConsoni/Developer-Allocator.git
   cd Developer-Allocator
   ```
2. Execute a aplicação com Maven:
      ```
      ./mvnw spring-boot:run
      ```
3. Abra seu navegador e acesse:
   ```
   http://localhost:8080/swagger-ui/index.html#/
   ```
