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
Os testes podem ser iniciados executando o comando abaixo no terminal da IDE:

```java
    mvn clean test
```
Os testes também podem ser iniciados executando a classe TestsRunner ao clicar no botão de execução da própria IDE.

## Relatório de testes
Os relatórios com os resultados de testes estão sendo gerados de forma automática pelo Allure Report, para exibi-los basta executar o comando abaixo no terminal da IDE:

```java
    mvn allure:serve
```

Da mesma maneira, foi adicionada uma etapa (job) na pipeline para publicar os relatórios de testes do Allure no GitLab Pages sempre que um push for feito na branch main, conforme as evidências a seguir:

- [Relatório](https://brunorgdsantos.gitlab.io/-/db-server-desafio-tecnico-2025/-/jobs/9232825581/artifacts/public/index.html)

- [Job Pipeline](https://gitlab.com/brunorgdsantos/db-server-desafio-tecnico-2025/-/pipelines/1686817908)

A step inicial da pipeline, chamada "test", é responsável por executar todos os testes da automação em um container Docker. A segunda step, denominada "allure report" é responsável por gerar o relatório automático de testes. A etapa final, chamada "allure_report_pages", é responsável por disponibilizar o relatório de testes para visualização no GitLab Pages.

É importante ressaltar que apenas pessoas autorizadas podem visualizar as informações acima, uma vez que o repositório está configurado como privado.

## Integrações CI
A seguinte automação de testes foi desenvolvida com duas pipelines de execução automática, sendo uma delas na própria pipeline do GitLab, denominada tests, conforme ilustrado na imagem abaixo:

- [Job GitLab Pipeline](https://gitlab.com/brunorgdsantos/db-server-desafio-tecnico-2025/-/pipelines/1686817908)

A outra integração é realizada pelo Jenkins, e ambos executam os testes utilizando o JUnit:

- [Jenkins](https://drive.google.com/file/d/12EtrQ-MfQwShXnY7dpax9NuqT2s143Hc/view?usp=sharing)

É importante destacar que apenas uma das duas opções é suficiente, porém, ambas foram implementadas nesta automação apenas para fins de conhecimento

## Plano de teste e estratégia de testes
Para o plano de testes tivemos como objetivo validar a API de gerenciamento de produtos eletrônicos. Para isso, foram validados os seus principais endpoints (GET /test, GET /users, POST /auth/login, GET /auth/products, POST /products/add, GET /products, GET /products/{id}), realizando testes nas requests/responses e comparando-as com a documentação, a fim de verificar se estavam conforme os requisitos esperados. Inicialmente, foi utilizado o Postman para testes manuais e, posteriormente, foi adotado o RestAssured com JUnit para a execução de testes automáticos. Por último, foram configuradas pipelines para a execução automática dos testes. Dessa forma, os endpoints que estavam de acordo com a documentação foram considerados como testes aprovados, enquanto aqueles que apresentavam inconsistências em relação aos requisitos definidos foram considerados como testes falhos. A cobertura funcional dos cenários, incluindo fluxos de exceção também foram validados. Todos esses processos de testes foram desenvolvidos para garantir que a aplicação está funcionando corretamente de acordo com a [documentação](https://sicredi-desafio-qe.readme.io/reference/get-test) .

## Bugs
Os endpoints listados a seguir apresentam divergências ou inconsistências em relação aos requisitos apresentados na [documentação da API](https://sicredi-desafio-qe.readme.io/reference/get-test). Portanto, é recomendável repassar os resultados dos testes para o time de desenvolvimento e produto para possíveis alinhamentos e a criação de subtarefas de correção de bugs (subtask-bug) ao longo da sprint:

- **[GET /users]** - Apresenta divergências entre a documentação e os campos que estão sendo apresentados no body do response, a saber: *stateCode*, *country* e *domain*.
- **[POST /auth/login]** - Há uma pequena divergência no status code da API, sendo *201* como requerido na documentação e *200* na resposta da API. Da mesma forma, há divergência na nomenclatura de campo, sendo *token* na documentação e *accessToken* na resposta da API.
- **[GET /auth/products]** - Há muitos campos sendo retornados nas respostas da API que, aparentemente, não deveriam ser exibidos de acordo com a documentação. Campos a saber: *weight*, *dimensions*, *warrantyInformation*, *availabilityStatus*, *reviews*, *sku*, *returnPolicy*, *minimumOrderQuantity*, *meta*, dentro outros. Da mesma forma, não foi identificado nenhum cenário em que o *Response - 403 Forbidden* seja retornado. Portanto, é necessário verificar em qual situação essa resposta deveria ocorrer.
- **[POST /products/add]** - O campo *discountPercentage* está presente no body do response, porém, de acordo com a documentação, ele não deveria ser exibido.
- **[GET /products/{id}]** - O campo *meta.qrCode* está retornando informações diferentes quando comparado à documentação para o produto de *id:1*.

## Melhorias
Há divergências entre a documentação e os campos retornados nos responses da API. Ou seja, muitos dos endpoints testados apresentam divergências ou inconsistências em relação aos requisitos documentados da API. Portanto, é recomendável repassar os resultados dos testes com o time de desenvolvimento e produto para possíveis alinhamentos e a criação de subtarefas de correção de bugs. Da mesma forma, a análise dos requisitos deve ser verificada com mais frequência para evitar problemas futuros.
 
