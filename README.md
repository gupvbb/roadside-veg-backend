
# 🌿 RoadGreen API

API REST desenvolvida em Spring Boot para o monitoramento de áreas de vegetação próximas a rodovias.

A API é responsável por armazenar, processar e disponibilizar informações das áreas monitoradas e das medições realizadas pelo sistema RoadGreen Mobile.

---

## 👥 Integrantes

- Nicolas Cipriano — RM562278
- Nicolas Alves — RM561692
- Gustavo Pereira — RM563280
- Pedro de Castro — RM561825
- Thiago Almeida Souza — RM565365
- Gustavo Henrique — RM563874

---

# 🎯 Objetivo do sistema

O RoadGreen tem como objetivo auxiliar no monitoramento da vegetação presente em áreas próximas a rodovias.

A API permite:

- Cadastrar e consultar áreas monitoradas;
- Registrar medições;
- Consultar medições;
- Simular novas coletas;
- Calcular o status das medições;
- Atualizar o status das áreas;
- Disponibilizar os dados para o aplicativo mobile.

---

# 🛠️ Tecnologias utilizadas

- Java 17
- Spring Boot
- Spring Web
- Spring Data JPA
- H2 Database
- Maven

---

# 🏗️ Arquitetura

O backend utiliza uma organização em camadas:

src/main/java/com/RoadGreen/
├── config/
├── controller/
├── dto/
├── model/
├── repository/
└── service/

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

## Cálculo de Status da Vegetação

Ao registrar uma medição, o sistema calcula automaticamente o status da área com base em dois parâmetros: **densidade da vegetação** e **altura da vegetação**.

| Status | Densidade | Altura | Próxima Intervenção |
|--------|-----------|--------|-------------------|
| 🟢 **NORMAL** | até 50% | até 1.0m | 30 dias |
| 🟡 **ATENÇÃO** | 51% a 70% | 1.01m a 1.5m | 15 dias |
| 🔴 **URGENTE** | acima de 70% | acima de 1.5m | 7 dias |

> O status é atualizado automaticamente toda vez que uma medição é registrada ou simulada. Basta **uma** das condições ser verdadeira para o status ser aplicado (densidade **OU** altura).
 
---

##  Endpoints da API

### 📍 Área

- `POST /areas` → Criar área
- `GET /areas` → Listar áreas
- `GET /areas/{id}` → Buscar por ID


---

## Como testar

### 1. Rodando o projeto

Execute o projeto pelo IntelliJ ou via terminal:

```bash
./mvnw spring-boot:run
```
A API estará disponível em: `http://localhost:8080/h2-console`

##  Banco de Dados

Utilizado **H2 Database** para persistência dos dados.

---


