<h1 align="center">Testes API Gerenciador Produtos Eletrônicos</h1>

<p>Automação de testes de API criada para o desafio técnico DBServer</p>

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
<p>Os relatórios de testes estão sendo gerados de forma automática pelo Allure Report, para exibi-los basta executar o comando abaixo no terminal da IDE:</p>

```java
    mvn allure:report
```

<p>Da mesma maneira, foi adicionada uma etapa (job) na pipeline para publicar os relatórios de testes do Allure no GitLab Pages sempre que um push for feito na branch main, conforme as evidências a seguir:</p>

- [Relatório](https://brunorgdsantos.gitlab.io/-/db-server-desafio-tecnico-2025/-/jobs/9232825581/artifacts/public/index.html)

- [Job](https://gitlab.com/brunorgdsantos/db-server-desafio-tecnico-2025/-/pipelines/1686817908)
  
<p>É importante ressaltar que apenas pessoas autorizadas podem visualizar as informações acima, uma vez que o repositório está configurado como privado.</p>
