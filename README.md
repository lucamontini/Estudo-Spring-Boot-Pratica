# Spring Boot na Prática 🚀

Projeto prático desenvolvido para fins de estudo e aprofundamento em **Spring Boot**, acompanhando a aula da instrutora **Michelli Brito**:

📺 **Vídeo de Referência:** [Spring Boot com IA Coding na Prática | Curso Completo 2026](https://youtu.be/01yqAcaYsL0)

---

## 📌 Sobre o Projeto

Este repositório contém o código e anotações práticas desenvolvidas ao longo do curso, com o objetivo de explorar os principais conceitos do ecossistema Spring Boot, arquitetura de APIs RESTful, persistência de dados e integração com ferramentas modernas de assistência por IA (*IA Coding*).

---

## 🛠️ Tecnologias e Dependências

- **Linguagem:** Java 25
- **Framework:** Spring Boot 4.1.1
- **Módulos do Spring:**
  - **Spring Web MVC:** Desenvolvimento de endpoints RESTful e controladores HTTP.
  - **Spring Data JPA:** Abstração e facilitação de acesso a dados e persistência relacional.
  - **Spring Boot Starter Validation:** Validação declarativa de dados com Bean Validation.
- **Banco de Dados:** PostgreSQL (driver `postgresql`)
- **Gerenciador de Dependências e Build:** Apache Maven (com Maven Wrapper `mvnw`)
- **Testes:** JUnit 5 e starters de teste do Spring Boot

---

## 📂 Estrutura do Projeto

```text
spring-boot-na-pratica/
├── src/
│   ├── main/
│   │   ├── java/com/example/spring_boot_na_pratica/
│   │   │   └── SpringBootNaPraticaApplication.java
│   │   └── resources/
│   │       └── application.yaml
│   └── test/
│       └── java/com/example/spring_boot_na_pratica/
│           └── SpringBootNaPraticaApplicationTests.java
├── pom.xml
├── mvnw
├── mvnw.cmd
├── LICENSE
└── README.md
```

---

## ⚙️ Pré-requisitos

Para clonar, compilar e executar esta aplicação localmente, você precisará de:

- **JDK 25** configurado no ambiente.
- **Git** instalado.
- Instância do **PostgreSQL** em execução (localmente ou via Docker).

---

## 🚀 Como Executar

### 1. Clonar o Repositório
```bash
git clone <URL_DO_SEU_REPOSITORIO>
cd spring-boot-na-pratica
```

### 2. Configurar o Banco de Dados
Ajuste as propriedades de conexão com o PostgreSQL no arquivo `src/main/resources/application.yaml`, configurando URL, usuário e senha conforme seu ambiente local:

```yaml
spring:
  application:
    name: spring-boot-na-pratica
  datasource:
    url: jdbc:postgresql://localhost:5432/seu_banco
    username: seu_usuario
    password: sua_senha
  jpa:
    hibernate:
      ddl-auto: update
    show-sql: true
```

### 3. Compilar o Projeto
Utilize o Maven Wrapper incluído no repositório:

```bash
# Linux/macOS
./mvnw clean compile

# Windows
mvnw.cmd clean compile
```

### 4. Executar a Aplicação
```bash
# Linux/macOS
./mvnw spring-boot:run

# Windows
mvnw.cmd spring-boot:run
```

A aplicação será inicializada por padrão na porta `8080` (acessível em `http://localhost:8080`).

### 5. Executar os Testes
```bash
# Linux/macOS
./mvnw test

# Windows
mvnw.cmd test
```

---

## 🤝 Créditos e Agradecimentos

- Agradecimentos à **Michelli Brito** pelo conteúdo educacional de alta qualidade compartilhado na comunidade.
- Link da aula: [Spring Boot com IA Coding na Prática | Curso Completo 2026](https://youtu.be/01yqAcaYsL0)

---

## 📄 Licença

Este projeto está sob a licença **MIT**. Consulte o arquivo [LICENSE](LICENSE) para obter mais informações.
