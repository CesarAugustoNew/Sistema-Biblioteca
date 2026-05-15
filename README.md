# 📚 Sistema de Gerenciamento de Biblioteca (Java + MySQL)

Projeto desenvolvido em Java utilizando JDBC e MySQL com o padrão DAO (Data Access Object).

O sistema permite o gerenciamento de:

- 📖 Livros
- 👤 Usuários
- 📚 Empréstimos de livros

A aplicação funciona via terminal/console utilizando um menu interativo.

---
# Modelagem Banco de Dados
<img width="1536" height="1024" alt="image" src="https://github.com/user-attachments/assets/a5fa66f6-96e1-42df-b460-c93a1290ff41" />

---
# 📁 Estrutura do projeto

```bash
src/main/java
│
├── Database
│   └── sqlConn.java
│
├── dao
│   ├── ILivroDAO.java
│   └── IUsuarioDAO.java
│
├── daoImplements
│   ├── LivroDAOImplements.java
│   └── UsuarioDAOImplements.java
│
├── model
│   ├── Livro.java
│   └── Usuario.java
│
└── org.example
    └── App.java
```

---

# 🛠️ Tecnologias utilizadas

- Java SE
- JDBC
- MySQL
- Maven
- MySQL Connector/J

---

# 📌 Funcionalidades

## 📖 CRUD de Livros

O sistema permite:

- Cadastrar livros
- Listar livros
- Buscar livro por ID
- Excluir livro

### Dados do livro:
- ID
- Nome
- Autor
- Editora

---

## 👤 CRUD de Usuários

O sistema permite:

- Cadastrar usuários
- Listar usuários
- Buscar usuário por ID
- Excluir usuário

### Dados do usuário:
- ID
- Nome
- Endereço
- Telefone
- Livro emprestado

---

# 🔗 Relacionamento entre tabelas

Cada usuário pode possuir um livro associado através da chave estrangeira:

```sql
FOREIGN KEY (idLivro)
REFERENCES livro(idLivro)
```

Isso simula um sistema de empréstimo de livros.

---

# 🎯 Desafio implementado

✅ Listar usuários associados a um determinado livro.

O sistema possui uma funcionalidade específica para:

- Buscar todos os usuários que possuem um livro emprestado.

---

# ⚙️ Conceitos aplicados

Durante o desenvolvimento do projeto foram utilizados conceitos importantes do desenvolvimento backend:

- Programação Orientada a Objetos (POO)
- JDBC
- CRUD
- DAO Pattern
- Encapsulamento
- Relacionamento entre tabelas
- Foreign Key
- Organização em camadas
- Manipulação de banco de dados
- PreparedStatement
- ResultSet
- Tratamento de exceções
- Conexão Java + MySQL

---

# 🗄️ Banco de Dados

O sistema utiliza o banco:

```sql
sistema_biblioteca
```

---

# 🧱 Estrutura das tabelas

## 📖 Tabela Livro

| Campo | Tipo |
|---|---|
| idLivro | INT |
| nome | VARCHAR |
| autor | VARCHAR |
| editora | VARCHAR |

---

## 👤 Tabela Usuário

| Campo | Tipo |
|---|---|
| idUsuario | INT |
| nome | VARCHAR |
| endereco | VARCHAR |
| telefone | VARCHAR |
| idLivro | INT |

---

# 🚀 Como executar o projeto

## 1️⃣ Clonar o repositório

```bash
git clone URL_DO_REPOSITORIO
```

---

## 2️⃣ Criar o banco de dados MySQL

Execute o script SQL do projeto no MySQL Workbench.

---

## 3️⃣ Configurar conexão com o banco

Na classe:

```java
sqlConn.java
```

configure:

```java
url
user
password
```

---

## 4️⃣ Executar o projeto

Execute a classe:

```java
App.java
```

---

# 📋 Menu do sistema

```txt
1. Cadastrar Livro
2. Listar Livros
3. Buscar Livro
4. Excluir Livro

5. Cadastrar Usuário
6. Listar Usuários
7. Buscar Usuário
8. Excluir Usuário

9. Listar usuários por livro

0. Sair
```

---

# 🚀 Melhorias futuras

- Atualizar livros
- Atualizar usuários
- Sistema de devolução de livros

---

# 🎯 Objetivo do projeto

O principal objetivo deste projeto foi praticar:

- Conexão Java com MySQL
- JDBC
- CRUD
- DAO Pattern
- Relacionamento entre tabelas
- Organização de código
- Estruturação de sistemas backend
- Manipulação de dados no banco
