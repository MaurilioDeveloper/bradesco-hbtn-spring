# 🧪 Projeto Spring - Mocking com JUnit 5 e Mockito

## 🎯 Objetivo
Criar um projeto Spring Boot com **injeção de dependências**, **mock de repositório** e **testes unitários** usando **JUnit 5** e **Mockito**.

---

## 🧩 Estrutura do Projeto

spring-mocking/1x01/
├── pom.xml
├── README.md
├── src/
│ ├── main/
│ │ ├── java/com/example/demo/
│ │ │ ├── model/Produto.java
│ │ │ ├── repository/ProdutoRepository.java
│ │ │ └── service/ProdutoService.java
│ │ └── resources/application.properties
│ └── test/
│ └── java/com/example/demo/service/ProdutoServiceTest.java

yaml
Copiar código

---

## ⚙️ Dependências utilizadas

- **Spring Boot Starter Web**
- **Spring Boot Starter Data JPA**
- **Spring Boot DevTools**
- **H2 Database**
- **Spring Boot Starter Test** (JUnit 5 + Mockito)

---

## 🚀 Como executar

```bash
# Entrar na pasta do projeto
cd spring-mocking/1x01

# Executar os testes
mvn test

# (opcional) Rodar a aplicação
mvn spring-boot:run
🧠 Lógica do Projeto
A aplicação contém:

ProdutoService — classe de serviço responsável pela regra de negócio.

ProdutoRepository — interface que simula acesso ao banco via JPA.

ProdutoServiceTest — classe de teste com Mockito para isolar o comportamento do repositório.

Métodos testados:
Método	Descrição	Comportamento esperado
buscarPorId(Long id)	Busca um produto pelo ID	Retorna o produto se existir, ou lança exceção se não

🧪 Testes unitários (Mockito)
✅ Caso 1 — Produto encontrado
Mock configurado: when(findById(1L)).thenReturn(Optional.of(produto))

Validação: o produto retornado é o esperado

❌ Caso 2 — Produto não encontrado
Mock configurado: when(findById(99L)).thenReturn(Optional.empty())

Validação: exceção RuntimeException("Produto não encontrado") é lançada

💡 Conceitos aplicados
Injeção de dependência com @Autowired

Mock de dependências com @Mock e @InjectMocks

Teste de exceções com assertThrows

Uso de Optional em repositórios JPA

Separação de camadas (model, repository, service)

👨‍💻 Autor
Desenvolvido como parte do módulo Spring Boot - Mocking e Testes Unitários (bradesco-hbtn-spring).

