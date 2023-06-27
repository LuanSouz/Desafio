<h1  align="center"> Backend </h1>  

## Descrição do Projeto 

<p  align="justify"> Uma Web API para controle de ponto, seguindo o contrato Open API fornecido pela empresa, que permite realizar as seguintes ações.</p> 

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

