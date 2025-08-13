# BFF Agendador de Tarefas

## 📋 Descrição

O **BFF Agendador de Tarefas** é um Backend for Frontend (BFF) desenvolvido em Java com Spring Boot que atua como uma camada intermediária para gerenciamento de tarefas e usuários. Este projeto faz parte do Curso Java Nauta e implementa uma arquitetura moderna com integração a microserviços através do OpenFeign.

## 🚀 Tecnologias Utilizadas

- **Java 21** - Linguagem de programação
- **Spring Boot 3.5.0** - Framework principal
- **Spring Cloud 2025.0.0** - Ecossistema de microserviços
- **OpenFeign** - Cliente HTTP declarativo para comunicação entre serviços
- **SpringDoc OpenAPI** - Documentação automática da API
- **Lombok** - Redução de código boilerplate
- **Gradle** - Gerenciador de dependências e build
- **JUnit 5** - Framework de testes

## 🏗️ Arquitetura

O projeto segue uma arquitetura em camadas bem definida:


## 📚 Funcionalidades

### 🔐 Gestão de Usuários
- Cadastro de novos usuários
- Autenticação e login
- Busca de usuários por email
- Atualização de dados pessoais
- Gerenciamento de endereços
- Gerenciamento de telefones
- Exclusão de usuários

### 📝 Gestão de Tarefas
- Criação de tarefas
- Busca de tarefas por período
- Busca de tarefas por email do usuário
- Atualização de tarefas
- Alteração de status de notificação
- Exclusão de tarefas

## 🔧 Pré-requisitos

- Java 21 ou superior
- Gradle 7.x ou superior

## 🚀 Como Executar

### 1. Clone o repositório
```bash
   git clone https://github.com/JeanHeberth/bff-agendador-tarefas.git
cd bff-agendador-tarefas
```

### 2. Execute a aplicação
```bash
    ./gradlew bootRun
```

### 3. Acesse a documentação da API
Após iniciar a aplicação, acesse:


## 📖 Documentação da API

A API está documentada com OpenAPI 3.0 e pode ser acessada através do Swagger UI. A documentação inclui:

- Descrição detalhada de todos os endpoints
- Exemplos de requisições e respostas
- Códigos de status HTTP
- Esquemas de autenticação

### Principais Endpoints

#### Usuários
- `POST /usuario` - Cadastrar usuário
- `POST /usuario/login` - Realizar login
- `GET /usuario` - Buscar usuário por email
- `PUT /usuario` - Atualizar dados do usuário
- `DELETE /usuario/{email}` - Deletar usuário

#### Tarefas
- `POST /tarefas` - Criar tarefa
- `GET /tarefas/eventos` - Buscar tarefas por período
- `GET /tarefas` - Buscar tarefas por email
- `PUT /tarefas` - Atualizar tarefa
- `PATCH /tarefas` - Alterar status de notificação
- `DELETE /tarefas` - Deletar tarefa

## 🔒 Segurança

A aplicação implementa:
- Autenticação baseada em token
- Configurações de segurança personalizadas
- Proteção de endpoints sensíveis

## 🧪 Testes

Para executar os testes:
```bash
 ./gradlew test
```

## 📦 Build

Para gerar o build da aplicação:
```bash
 ./gradlew build
```

## 🤝 Contribuição

Este projeto faz parte do Curso Java Nauta. Para contribuir:

1. Faça um fork do projeto
2. Crie uma branch para sua feature (`git checkout -b feature/AmazingFeature`)
3. Commit suas mudanças (`git commit -m 'Add some AmazingFeature'`)
4. Push para a branch (`git push origin feature/AmazingFeature`)
5. Abra um Pull Request

## Swagger UI

A documentação da API está disponível no Swagger UI. Após iniciar a aplicação, acesse:

```
http://localhost:8080/swagger-ui.html
```

## 📄 Licença

Este projeto é parte do material educacional do Curso Java Nauta.

## 📞 Contato

Para dúvidas ou sugestões relacionadas ao projeto, entre em contato através dos canais do Curso Java Nauta.

---

**Desenvolvido por Jean Heberth com ❤️ durante o Curso Java Nauta**