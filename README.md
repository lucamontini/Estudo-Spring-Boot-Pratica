# Spring Boot na Prática 🚀

Projeto prático desenvolvido para fins de estudo e aprofundamento em **Spring Boot**, acompanhando a aula da instrutora **Michelli Brito**:

📺 **Vídeo de Referência:** [Spring Boot com IA Coding na Prática | Curso Completo 2026](https://youtu.be/01yqAcaYsL0)

---

## 📌 Sobre o Projeto

Uma API RESTful de **cadastro de livros** construída do zero ao longo do curso. O projeto cobre os conceitos fundamentais do ecossistema Spring Boot — desde a configuração do datasource até a integração com IA generativa para geração automática de resenhas.

### O que a API faz

- **CRUD completo de livros** (`POST`, `GET`, `PUT`, `DELETE`) exposto em `/books`
- **Geração automática de resenha** via IA (Spring AI) no momento do cadastro
- **Validação de entrada** com Bean Validation (`@NotNull`, `@Size`, `@Min/@Max`)
- **Versionamento de API** via header HTTP (`X-API-VERSION`, default `v1`)
- **Banco de dados PostgreSQL** hospedado no [Neon](https://neon.tech), com schema gerenciado pelo Hibernate (`ddl-auto: update`)

---

## 🛠️ Stack

| Camada | Tecnologia |
|---|---|
| Linguagem | Java 25 |
| Framework | Spring Boot 4.1.1 |
| Web | Spring Web MVC |
| Persistência | Spring Data JPA + Hibernate |
| Validação | Spring Boot Starter Validation |
| IA | Spring AI 2.0 |
| Banco de dados | PostgreSQL (Neon) |
| Build | Apache Maven (Maven Wrapper `./mvnw`) |
| Testes | JUnit 5 |

---

## 📂 Estrutura de Pacotes

```text
src/main/java/com/example/spring_boot_na_pratica/
├── configs/
│   └── WebConfig.java          # Versionamento de API via header HTTP
├── controllers/
│   └── BookController.java     # Endpoints REST de /books
├── dtos/
│   └── BookRecordDto.java      # Record de entrada com validações
├── models/
│   └── BookModel.java          # Entidade JPA mapeada para tb_books
├── repositories/
│   └── BookRepository.java     # Interface Spring Data JPA
├── services/
│   ├── BookService.java        # Regras de negócio do CRUD
│   └── ReviewService.java      # Geração de resenha via IA
└── SpringBootNaPraticaApplication.java
```

---

## 🔌 Endpoints

| Método | Rota | Descrição |
|---|---|---|
| `POST` | `/books` | Cadastra um livro e gera a resenha via IA |
| `GET` | `/books` | Lista todos os livros |
| `GET` | `/books/{id}` | Busca um livro por UUID |
| `PUT` | `/books/{id}` | Atualiza os dados de um livro |
| `DELETE` | `/books/{id}` | Remove um livro |

### Exemplo de payload (`POST /books`)

```json
{
  "title": "Clean Code",
  "author": "Robert C. Martin",
  "publisher": "Prentice Hall",
  "publicationYear": 2008
}
```

### Exemplo de resposta

```json
{
  "id": "3fa85f64-5717-4562-b3fc-2c963f66afa6",
  "title": "Clean Code",
  "author": "Robert C. Martin",
  "publisher": "Prentice Hall",
  "publicationYear": 2008,
  "review": "Resenha gerada automaticamente pela IA..."
}
```

---

## ⚙️ Pré-requisitos

- **JDK 25** configurado no `JAVA_HOME`
- **Git** instalado
- Instância **PostgreSQL** acessível (local, Docker ou [Neon](https://neon.tech))

---

## 🚀 Como Executar

### 1. Clonar o repositório

```bash
git clone <URL_DO_REPOSITORIO>
cd spring-boot-na-pratica
```

### 2. Configurar variáveis de ambiente

Crie um arquivo `.env` na raiz do projeto com as credenciais do banco:

```properties
DB_URL=jdbc:postgresql://<host>:<port>/<database>
DB_USER=<usuario>
DB_PASSWORD=<senha>
```

> O arquivo `.env` já está no `.gitignore` — nunca suba credenciais para o repositório.

### 3. Executar a aplicação

```bash
./mvnw spring-boot:run
```

A aplicação sobe na porta `8080` → `http://localhost:8080`

### 4. Executar os testes

```bash
./mvnw -q verify
```

---

## 📐 Convenções do Projeto

- **Sem Lombok** — construtores, getters e setters escritos à mão
- **Injeção por construtor** — sem `@Autowired` em campos
- **`BeanUtils.copyProperties`** para copiar DTO → entidade
- **Identificadores UUID** nas chaves primárias
- **Tabelas prefixadas** com `tb_` (ex.: `tb_books`)
- **Lógica de negócio** exclusivamente na camada de serviço

---

## 🤝 Créditos

- Aula ministrada por **Michelli Brito**
- [Spring Boot com IA Coding na Prática | Curso Completo 2026](https://youtu.be/01yqAcaYsL0)

---

## 📄 Licença

Este projeto está sob a licença **MIT**. Consulte o arquivo [LICENSE](LICENSE) para mais informações.

