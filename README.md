# Projeto Spring - Padrões de CEP - DIO

<div align="center">
  <p>Projeto desenvolvido para demonstrar a utilização de padrões de projeto em uma aplicação Spring Boot, com integração à API ViaCEP para consulta de endereços por CEP.</p>
  <img src="https://img.shields.io/badge/SpringBoot-2.7-green" alt="Spring Boot">
  <img src="https://img.shields.io/badge/Java-11+-blue" alt="Java">
  <img src="https://img.shields.io/badge/License-MIT-yellow" alt="License">
</div>

## 📋 Índice

- [Sobre](#sobre)
- [Funcionalidades](#funcionalidades)
- [Tecnologias Utilizadas](#tecnologias-utilizadas)
- [Pré-requisitos](#pré-requisitos)
- [Como Executar](#como-executar)
- [Endpoints da API](#endpoints-da-api)
- [Padrões de Projeto Utilizados](#padrões-de-projeto-utilizados)
- [Contribuição](#contribuição)
- [Licença](#licença)

## 🧠 Sobre

Este projeto tem como objetivo demonstrar a implementação de **padrões de projeto** em uma aplicação Java com Spring Boot, integrada à API de CEP (ViaCEP). Ele exemplifica boas práticas de arquitetura, design e manutenibilidade.

## ✅ Funcionalidades

- Consulta de endereço por CEP via API externa (ViaCEP).
- Armazenamento local de CEPs consultados.
- Implementação de padrões como Strategy, Factory, Singleton, etc.
- Tratamento de exceções personalizado.
- Validação de dados com Bean Validation.

## 💻 Tecnologias Utilizadas

- **Java 11+**
- **Spring Boot 2.7.x**
- **Maven**
- **Hibernate / JPA**
- **H2 Database (em memória)**
- **Lombok**
- **JUnit / Mockito**
- **ViaCEP API**

## ⚙️ Pré-requisitos

Antes de rodar o projeto, certifique-se de ter instalado:

- [Java 11 ou superior](https://openjdk.java.net/)
- [Maven](https://maven.apache.org/download.cgi)
- Git

## 🚀 Como Executar

1. Clone este repositório:
   ```bash
   git clone https://github.com/cashot01/projeto-spring-padroes-cep.git

2. Acesse o diretório do projeto:
   ```bash
   cd projeto-spring-padroes-cep

3. Compile e execute com Maven:
   ```bash
   mvn spring-boot:run

4. Acesse a aplicação:
   ```bash
   http://localhost:8080


## 🌐 Endpoints da API

A API oferece dois principais endpoints para consulta e persistência de endereços por CEP.

### 1. Buscar endereço por CEP
- **Método**: `GET`
- **Endpoint**: `/endereco/{cep}`
- **Descrição**: Consulta o endereço associado ao CEP informado. Se o CEP já existir no banco de dados local, retorna do cache; caso contrário, busca na API ViaCEP e salva localmente.
- **Parâmetro de caminho**:
  - `cep` (string, obrigatório): CEP no formato `00000000` ou `00000-000`.

#### Exemplo de requisição:
```http
GET http://localhost:8080/endereco/01001000
```

### 2. Salvar um novo endereço

- **Método**: `POST`  
- **Endpoint**: `/endereco`  
- **Descrição**: Persiste manualmente um endereço no banco de dados local. Útil para testes ou inserção controlada de dados.  
- **Content-Type**: `application/json`

#### Exemplo de requisição:
```http
POST http://localhost:8080/endereco
Content-Type: application/json
```

## 🛠️ Padrões de Projeto Utilizados

- **Strategy**: Utilizado para definir diferentes estratégias de busca de CEP (ex: cache local vs. chamada à API externa).
- **Factory**: Aplicado na criação de clientes HTTP ou serviços de consulta, permitindo fácil substituição de implementações.
- **Repository Pattern**: Isola a lógica de persistência, facilitando testes e manutenção.
- **Singleton**: Garante que apenas uma instância do serviço de integração com ViaCEP seja criada.
- **DTO (Data Transfer Object)**: Usado para transferir dados entre camadas sem expor entidades diretamente.

Esses padrões ajudam a tornar o código mais modular, testável e alinhado com os princípios SOLID.

## 🤝 Contribuição

Se desejar contribuir com o projeto, siga os passos abaixo:

1. Faça um fork do projeto.
2. Crie uma branch com sua feature:  
   ```bash
   git checkout -b feature/nova-funcionalidade
   ```
## 📄 Licença
Este projeto está licenciado sob a MIT License. Veja o arquivo LICENSE para mais detalhes.
