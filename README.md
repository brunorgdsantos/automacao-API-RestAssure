<h1 align="center">Testes API Gerenciador Produtos Eletrônicos</h1>

<p>Automação de testes de API criada para o desafio técnico do DBServer</p>

## Tecnologias utilizadas
- [Java](https://www.java.com/pt-BR/)
- [Spring Boot](https://spring.io/projects/spring-boot)
- [Rest-Assured](https://mvnrepository.com/artifact/io.rest-assured/rest-assured)
- [Junit 5](https://mvnrepository.com/artifact/org.junit.jupiter/junit-jupiter-api)
- [Allure Report](https://docs.qameta.io/allure/#_junit_5)
- [Jenkins](https://www.jenkins.io/)
- [Lombok](https://mvnrepository.com/artifact/org.projectlombok/lombok)
- [Gson](https://mvnrepository.com/artifact/com.google.code.gson/gson)
- [Docker](https://www.docker.com/)

## Como executar os testes
<p>Os testes podem ser iniciados executando o comando abaixo no terminal da IDE:</p>

```java
    mvn clean test
```
<p>Os testes também podem ser iniciados executando a classe TestsRunner ao clicar no botão de execução da própria IDE.</p>

## Relatório de testes
<p>Os relatórios com os resultados de testes estão sendo gerados de forma automática pelo Allure Report, para exibi-los basta executar o comando abaixo no terminal da IDE:</p>

```java
    mvn allure:report
```

<p>Da mesma maneira, foi adicionada uma etapa (job) na pipeline para publicar os relatórios de testes do Allure no GitLab Pages sempre que um push for feito na branch main, conforme as evidências a seguir:</p>

- [Relatório](https://brunorgdsantos.gitlab.io/-/db-server-desafio-tecnico-2025/-/jobs/9232825581/artifacts/public/index.html)

- [Job Pipeline](https://gitlab.com/brunorgdsantos/db-server-desafio-tecnico-2025/-/pipelines/1686817908)
  
<p>É importante ressaltar que apenas pessoas autorizadas podem visualizar as informações acima, uma vez que o repositório está configurado como privado.</p>

## Integrações CI
<p>A seguinte automação de testes foi desenvolvida com duas pipelines de execução automática, sendo uma delas na própria pipeline do GitLab, denominada tests, conforme ilustrado na imagem abaixo:</p>

- [Job GitLab Pipeline](https://gitlab.com/brunorgdsantos/db-server-desafio-tecnico-2025/-/pipelines/1686817908)

<p>A outra integração é realizada pelo Jenkins, e ambos executam os testes utilizando o JUnit:</p>

- [Jenkins](https://drive.google.com/file/d/12EtrQ-MfQwShXnY7dpax9NuqT2s143Hc/view?usp=sharing)

<p>É importante destacar que apenas uma das duas opções é suficiente, porém, ambas foram implementadas nesta automação apenas para fins de conhecimento</p>

## Plano de teste e estratégia de testes
<p>Para o plano de testes teremos como objetivo validar a API de gerenciamento de produtos eletrônicos. Para isso, cobriremos os seus principais endpoints (GET /test, GET /users, POST /auth/login, GET /auth/products, POST /products/add, GET /products, GET /products/{id}), realizando testes nas requests/responses e comparando-as com a documentação, a fim de verificar se estão conforme os requisitos esperados. Inicialmente, utilizaremos o Postman para testes manuais e, posteriormente, adotaremos o RestAssured com JUnit para a execução de testes automáticos. Por último, serão configuradas pipelines para a execução automática dos testes. O teste a ser implementado será de regressão. Dessa forma, os endpoints que estiverem de acordo com a documentação serão considerados como testes aprovados, enquanto aqueles que apresentarem inconsistências em relação aos requisitos definidos serão considerados como testes falhos. Todos esses processos de testes serão desenvolvidos para garantir que a aplicação está funcionando corretamente de acordo com a documentação.</p>

## Bugs
Os endpoints listados a seguir apresentam divergências ou inconsistências em relação aos requisitos apresentados na [documentação da API](https://sicredi-desafio-qe.readme.io/reference/get-test). Portanto, é recomendável repassar os resultados dos testes para o time de desenvolvimento e produto para possíveis alinhamentos e a criação de subtarefas de correção de bugs (subtask-bug) ao longo da sprint:

- **[GET /users]** - Apresenta divergências entre a documentação e os campos que estão sendo apresentados no response, a saber: *stateCode*, *country* e *domain*.
- **[POST /auth/login]** - Há uma divergência no status code da API, sendo *201* como requerido na documentação e *200* na resposta da API. Da mesma forma, há inconsistência na nomenclatura do campo, sendo *token* na documentação e *accessToken* na resposta da API.
- **[GET /auth/products]** - Há muitos campos sendo retornados nas respostas da API que, aparentemente, não deveriam ser exibidos de acordo com a documentação. Campos a saber: *weight*, *dimensions*, *warrantyInformation*, *availabilityStatus*, *reviews*, *sku*, *returnPolicy*, *minimumOrderQuantity*, *meta*, dentro outros,
 
