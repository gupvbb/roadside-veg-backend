# 🌿 RoadGreen - API REST

API REST desenvolvida em **Spring Boot** para monitoramento da vegetação em rodovias.

---

##  Objetivo

O sistema tem como objetivo simular o monitoramento de áreas rodoviárias utilizando sensores que coletam dados ambientais, auxiliando na prevenção de riscos como excesso de vegetação.

---
##  Integrantes

- Nicolas Cipriano RM562278
- Nicolas Alves    RM561692
- Gustavo Pereira  RM563280
- Pedro de Castro  RM561825
- Thiago Almeida   RM565365
- Gustavo Henrique RM563874

---
##  Tecnologias utilizadas

- Java 17
- Spring Boot
- Spring Web
- Spring Data JPA
- H2 Database

---
##  Conceito de Sensor

No sistema **RoadGreen**, sensores representam dispositivos físicos instalados ao longo das rodovias.

Esses sensores são responsáveis por coletar informações como:

- Crescimento da vegetação
- Umidade
- Estado da vegetação

No projeto, esse conceito é modelado através de:

- **AreaRoadGreen** → localização do sensor
- **Medicao** → dados coletados

---

##  Arquitetura

O projeto segue o padrão em camadas:

- Model - Representa o banco de dados
- Repository - comunicação com o banco
- Service - lógica do sistema: Processamento de dados
- Controller - porta de entrada da API: Receber requisições HTTP, retornar respostas
- DTO - controlar o que entra e sai da API: 
---

##  Endpoints da API

### 📍 Área

- `POST /areas` → Criar área
- `GET /areas` → Listar áreas
- `GET /areas/{id}` → Buscar por ID
- `PUT /areas/{id}` → Atualizar
- `DELETE /areas/{id}` → Deletar

---

###  Medição

- `POST /medicoes` → Criar medição
- `GET /medicoes` → Listar medições
- `GET /medicoes/{id}` → Buscar por ID
- `PUT /medicoes/{id}` → Atualizar
- `DELETE /medicoes/{id}` → Deletar

---

##  Banco de Dados

Utilizado **H2 Database** para persistência dos dados.

---


