# Spring-Chat-Socket

Esta API é desenvolvida utilizando Spring Boot, integrando comunicação em tempo real por meio de WebSocket e autenticação segura com JWT (JSON Web Token).

## Funcionalidades

- Comunicação em tempo real entre clientes através de WebSocket.
- Autenticação de usuários utilizando JWT.
- Gerenciamento de mensagens em salas de chat.

## Tecnologias Utilizadas

- **Spring Boot**: Framework principal para o desenvolvimento da API.
- **WebSocket**: Protocolo de comunicação para mensagens em tempo real.
- **JWT (JSON Web Token)**: Implementação de autenticação segura.
- **Maven**: Gerenciamento de dependências.

## Pré-requisitos

Certifique-se de ter as seguintes ferramentas instaladas em sua máquina:

- Java 17 ou superior
- Maven 3.8 ou superior
- Banco de Dados configurado (opcional, dependendo da implementação de persistência utilizada)

## Como Executar

1. Clone o repositório:
   ```bash
   git clone https://github.com/winycios/Spring-Chat-Socket.git
   cd spring-chat-socket
   ```

2. Compile o projeto:
   ```bash
   mvn clean install
   ```

3. Inicie a aplicação:
   ```bash
   mvn spring-boot:run
   ```

4. Acesse a aplicação em `http://localhost:8080`.


## Licença

Este projeto é licenciado sob a [MIT License](LICENSE).

---

Desenvolvido com ❤️ por Winyc.
