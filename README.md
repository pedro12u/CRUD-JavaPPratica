# 📘 Prova Prática - CRUD Java (API RESTful com DTO)
Este projeto foi desenvolvido como **prova prática da disciplina de Programação Avançada**, ministrada pelo professor **Eliel Nascimento**, com o objetivo de demonstrar a criação de uma **API RESTful completa (CRUD)** em **Java**, utilizando o padrão **DTO**, e com testes realizados via **Postman**.

## 🧪 Objetivo da Prova
Implementar uma API em Java que permita operações básicas de **Create**, **Read**, **Update** e **Delete** sobre uma entidade, seguindo os princípios REST, utilizando DTOs para comunicação entre as camadas e testes manuais via Postman.
---

## 🔧 Tecnologias Utilizadas
- Java 17+
- Spring Boot
- Spring Web
- Spring Data JPA
- H2 Database
- DTO Pattern
- Postman (para testes)

> Todos os endpoints foram testados via Postman com sucesso.

---

## 🧾 Padrão DTO

A aplicação segue o padrão DTO (Data Transfer Object), desacoplando o modelo da entidade do modelo utilizado na comunicação com o cliente, promovendo maior segurança e clareza na API.

Exemplo:
```java
public class UsuarioDTO {
    private String nome;
    private String email;
}
```

🧪 Testes com Postman
Os testes da API foram realizados no Postman e incluem:
- Testes de criação e leitura de trabalho/pessoa
- Testes de atualização com dados válidos e inválidos
- Testes de exclusão e verificação de resposta
- Testes de retorno para trabalho/pessoa inexistente

🧑‍🏫 Informações da Prova
- Aluno: Pedro Toscano
- Professor: Eliel Nascimento
- Disciplina: Programação Avançada
- Data da Prova: 17/04/2025

✅ Considerações Finais
O projeto foi desenvolvido com foco nas boas práticas de API REST, uso adequado de DTOs, estruturação em camadas, testes via Postman e documentação clara do código. A prova atende a todos os requisitos propostos pelo professor Eliel Nascimento.
