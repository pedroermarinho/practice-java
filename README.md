# practice-java

Repositório de estudos e práticas em Java/Kotlin, cobrindo desde fundamentos até arquiteturas distribuídas. Cada subprojeto representa um tópico específico estudado de forma isolada.

---

## Microserviços & Arquitetura Distribuída

| Projeto | Linguagem | Tecnologias | Descrição |
|---------|-----------|-------------|-----------|
| [`ms-course/`](ms-course/) | Java | Spring Boot, Eureka, Ribbon, Feign | Curso de microserviços com service discovery, load balancing e HTTP declarativo. Contém 3 serviços: |
| &nbsp;&nbsp;↳ [`hr-eureka-server/`](ms-course/hr-eureka-server/) | Java | Spring Cloud Eureka | Servidor de registro e descoberta de serviços |
| &nbsp;&nbsp;↳ [`hr-worker/`](ms-course/hr-worker/) | Java | Spring Boot, JPA | Serviço de trabalhadores exposto via REST |
| &nbsp;&nbsp;↳ [`hr-payroll/`](ms-course/hr-payroll/) | Java | Spring Boot, Feign, Ribbon | Serviço de folha de pagamento com Feign + load balancing |
| [`rabbitmq/`](rabbitmq/) | **Kotlin** | Spring Boot, RabbitMQ, Docker | Mensageria assíncrona com publishers, workers, RPC (request/reply), Dead Letter Queue e topologia de exchanges |

---

## Concorrência & Threads

| Projeto | Linguagem | Tecnologias | Descrição |
|---------|-----------|-------------|-----------|
| [`threads/`](threads/) | Java | Java 21, Virtual Threads | Estudo aprofundado de concorrência. Cobre: |
| &nbsp;&nbsp;↳ Aula 1 | Java | `CompletableFuture`, `CountDownLatch`, `CyclicBarrier`, `Semaphore`, `Phaser`, `ForkJoin`, Virtual Threads | Primitivas de sincronização e paralelismo |
| &nbsp;&nbsp;↳ Aula 2 | Java | `ExecutorService`, Virtual Threads | CPU-bound vs IO-bound tasks, lifecycle do executor |
| &nbsp;&nbsp;↳ Aula 3 | Java | `ConcurrentHashMap`, `CopyOnWriteList`, `BlockingQueue` | Coleções thread-safe e padrão produtor/consumidor |
| &nbsp;&nbsp;↳ Aula 4 | Java | `CountDownLatch`, `CyclicBarrier` | Coordenação de múltiplas threads |

---

## APIs REST & Spring

| Projeto | Linguagem | Tecnologias | Descrição |
|---------|-----------|-------------|-----------|
| [`cursomc/`](cursomc/) | Java | Spring Boot, JPA, REST | API de e-commerce com Spring Boot |
| [`reactve-flascards/`](reactve-flascards/) | Java | Spring WebFlux, Docker | API reativa com programação non-blocking (WebFlux) |
| [`rinha-backend-2024-q1-spring-boot-jpa/`](rinha-backend-2024-q1-spring-boot-jpa/) | Java | Spring Boot, JPA, Nginx, Docker | Implementação para a Rinha de Backend 2024 Q1 com Nginx como load balancer e foco em performance |

---

## Clean Architecture & Design Patterns

| Projeto | Linguagem | Tecnologias | Descrição |
|---------|-----------|-------------|-----------|
| [`escola-curso-clean-architecture-alura/`](escola-curso-clean-architecture-alura/) | Java | Maven | Clean Architecture aplicada a um sistema escolar (domínio + infra separados) |
| [`alura_design_patterns_loja/`](alura_design_patterns_loja/) | Java | Maven | Design Patterns (GoF) em um sistema de loja: Strategy, Decorator, Observer, etc. |
| [`2051-solid-java-projeto_inicial/`](2051-solid-java-projeto_inicial/) | Java | Maven | Princípios SOLID na prática |

---

## Testes

| Projeto | Linguagem | Tecnologias | Descrição |
|---------|-----------|-------------|-----------|
| [`2108-java-testes-unitarios-tdd-projeto_inicial/`](2108-java-testes-unitarios-tdd-projeto_inicial/) | Java | JUnit, TDD | Testes unitários com abordagem Test-Driven Development |
| [`2066-java-testes-mock-projeto_inicial/`](2066-java-testes-mock-projeto_inicial/) | Java | JUnit, Mockito | Testes com Mocks usando Mockito |

---

## JPA & Persistência

| Projeto | Linguagem | Tecnologias | Descrição |
|---------|-----------|-------------|-----------|
| [`jpa/`](jpa/) | Java | JPA, Hibernate | Fundamentos de JPA e mapeamento objeto-relacional |
| [`jpa-mavem/`](jpa-mavem/) | Java | JPA, Maven | JPA com Maven como gerenciador de dependências |
| [`EJPA-1/`](EJPA-1/) | Java | JPA | Estudos avançados de JPA |
| [`ejpa-ecommerce/`](ejpa-ecommerce/) | Java | JPA, Maven | Modelo de e-commerce mapeado com JPA |

---

## Reflexão & Metaprogramação

| Projeto | Linguagem | Tecnologias | Descrição |
|---------|-----------|-------------|-----------|
| [`alurator/`](alurator/) | Java | Reflection API | Exploração da API de Reflection do Java |
| [`alurator-playground-java-reflection/`](alurator-playground-java-reflection/) | Java | Reflection API | Playground para experimentos com Java Reflection |
| [`estoque-api-java-reflection/`](estoque-api-java-reflection/) | Java | Reflection API | API de estoque construída usando Reflection |

---

## Estruturas de Dados

| Projeto | Linguagem | Tecnologias | Descrição |
|---------|-----------|-------------|-----------|
| [`estrutura-de-dados-alura-lista-ligada/`](estrutura-de-dados-alura-lista-ligada/) | Java | Maven | Implementação de Lista Ligada do zero |
| [`estrutura-de-dados-alura-vetor/`](estrutura-de-dados-alura-vetor/) | Java | Maven | Implementação de Vetor/Array dinâmico do zero |
| [`estrutura-de-dados-pilha/`](estrutura-de-dados-pilha/) | Java | Maven | Implementação de Pilha (Stack) do zero |

---

## Projetos Acadêmicos (UNIPDS)

| Projeto | Linguagem | Tecnologias | Descrição |
|---------|-----------|-------------|-----------|
| [`unipds/agencia-viagem-ai/`](unipds/agencia-viagem-ai/) | Java | Quarkus, LangChain4j, Ollama, pgVector | Agência de viagens com IA generativa usando LLM local (Ollama) e busca vetorial (pgVector) |
| [`unipds/quarkus-kafka-florinda-eats/`](unipds/quarkus-kafka-florinda-eats/) | Java | Quarkus, Kafka, Docker | Sistema de pedidos com mensageria Kafka. Contém 3 microsserviços: |
| &nbsp;&nbsp;↳ [`pedidos/`](unipds/quarkus-kafka-florinda-eats/pedidos/) | Java | Quarkus, Kafka | Serviço de criação e gerenciamento de pedidos |
| &nbsp;&nbsp;↳ [`pagamentos/`](unipds/quarkus-kafka-florinda-eats/pagamentos/) | Java | Quarkus, Kafka, MySQL, Flyway | Serviço de processamento de pagamentos |
| &nbsp;&nbsp;↳ [`notas-fiscais/`](unipds/quarkus-kafka-florinda-eats/notas-fiscais/) | Java | Quarkus, Kafka | Serviço de emissão de notas fiscais |
| [`unipds/unipdi-kubernetes/`](unipds/unipdi-kubernetes/) | YAML | Kubernetes | Manifests K8s para deploy de aplicação com MongoDB (Pod, Deployment, HPA, ConfigMap, Secret) |

---

## Web (JSP/Servlet)

| Projeto | Linguagem | Tecnologias | Descrição |
|---------|-----------|-------------|-----------|
| [`curso-jsp/`](curso-jsp/) | Java | JSP, Servlet | Curso de desenvolvimento web com JSP e Servlets |
| [`jsp/`](jsp/) | Java | JSP, Maven | Estudos complementares de JSP |
| [`Servers/`](Servers/) | — | Tomcat | Configuração de servidor Tomcat |

---

## Outros

| Projeto | Linguagem | Tecnologias | Descrição |
|---------|-----------|-------------|-----------|
| [`aluguel-de-carro-fx/`](aluguel-de-carro-fx/) | Java | JavaFX, Maven | Sistema de aluguel de carros com interface gráfica JavaFX |
| [`aluno/`](aluno/) | Java | — | Sistema simples de cadastro de alunos |
| [`aula1/`](aula1/) | Java | Gradle | Exercícios introdutórios de Java |
| [`unipds/`](unipds/) | Java | — | Projetos acadêmicos (UNIPDS) — ver seção acima |

---

## Stack principal

![Java](https://img.shields.io/badge/Java-ED8B00?style=flat&logo=openjdk&logoColor=white)
![Kotlin](https://img.shields.io/badge/Kotlin-7F52FF?style=flat&logo=kotlin&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-6DB33F?style=flat&logo=spring-boot&logoColor=white)
![Quarkus](https://img.shields.io/badge/Quarkus-4695EB?style=flat&logo=quarkus&logoColor=white)
![RabbitMQ](https://img.shields.io/badge/RabbitMQ-FF6600?style=flat&logo=rabbitmq&logoColor=white)
![Apache Kafka](https://img.shields.io/badge/Apache_Kafka-231F20?style=flat&logo=apache-kafka&logoColor=white)
![Docker](https://img.shields.io/badge/Docker-2496ED?style=flat&logo=docker&logoColor=white)
![Kubernetes](https://img.shields.io/badge/Kubernetes-326CE5?style=flat&logo=kubernetes&logoColor=white)
