<h1  align="center">Desafio Backend | Ília</h1>  

## Descrição do Projeto 

<p  align="justify"> Desafio Backend para a empresa Ília. Criar uma Web API para controle de ponto, seguindo o contrato Open API fornecido pela empresa, que permite realizar as seguintes ações.</p> 

### Registrar os horários da jornada diária de trabalho :heavy_check_mark:

- [x] Apenas 4 horários podem ser registrados por dia.

- [x] Deve haver no mínimo 1 hora de almoço.

- [x] Sábado e domingo não são permitidos como dia de trabalho. 

## Tecnologias utilizadas :

- Java 11;
- Spring Boot;
- Spring Data JPA;
- H2 Database in-memory;

## Como rodar o projeto 

No terminal de sua preferência clone o projeto:
```
https://github.com/LuanSouz/Desafio.git
```

Configurações dos projetos nas IDEs

> Este projeto é um projeto Maven. Com isso, o processo de configuração dele é o padrão de qualquer projeto maven.

Basta importar um novo projeto maven apontando para o pom localizado na raíz do projeto. 

### Criação das imagens Docker
docker-compose up -d  Ponto-Eletronico

Cria a imagem da API do projeto. 


### Acessando Banco de Dados H2:
> http://localhost:8080/h2-console
>
>**JDBC URL:** jdbc:h2:mem:controleponto
> **user:** sa
> **password (sem senha):**

### Endpoint aplicação:

Para inserção de uma data, recomendo utilizar uma API Client, tais como **Postman** ou **Insomnia** 
> Registrar um ponto
> **POST** http://localhost:8080/batidas
> 
> Postman no projeto "**Controle de Ponto API.postman_collection.json**"

### Limpar, compilar, executar testes de unidade e cobertura, qualidade de código

./gradlew clean Limpa os dados gerados pelo build do projeto, como o jar da aplicação.

./gradlew build -x test Roda o build do projeto. O "-x test" é para não rodar os testes durante o build.

./gradlew test Executa todos os testes do projeto.

./gradlew sonarqube Executa a análise da qualidade do código, e a mesma ficará disponível no SonarCloud. Obs: é necessário as credendiais, mas o projeto possui essa step incluída na pipeline, então qualquer interação com o repositório será analisada pelo Sonar.
