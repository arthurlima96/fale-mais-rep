# Telzir - FaleMais

[![Build Status](https://travis-ci.org/arthurlima96/fale-mais-rep.svg?branch=master)](https://travis-ci.org/arthurlima96/fale-mais-rep)

A empresa de telefonia Telzir, especializada em chamadas de longa distância nacional, vai colocar um novo produto no mercado chamado FaleMais. 

## Requerimentos

Para construir e executar você precisa:

- [JDK 1.8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
- [Maven 3](https://maven.apache.org)
- [GIT](https://git-scm.com/downloads)

## Componentes da Aplicação

A aplicação foi desenvolvida utilizando os componentes abaixo:

- Java
- SpringBoot
- JUnit
- Travis CI
- H2-Database
- Swagger
- Bootstrap
- HTML
- CSS

## Instalação do projeto

- Faça o download dos arquivos do projeto
```shell
git clone https://github.com/arthurlima96/fale-mais-rep.git
```
## Execução dos testes

Abrindo o terminal e digitando o comando abaixo é possivel executar os testes da aplicação

```shell
mvn test
```

## Executação da aplicação localmente

Existe algumas formas de executar uma aplicação Spring Boot localmente. Um dos caminhos é executar o método `main` da classe `br.com.telzir.falemais.FaleMaisApplication` na sua IDE.

Uma outra alternativa para isso é usar o [Spring Boot Maven plugin](https://docs.spring.io/spring-boot/docs/current/reference/html/build-tool-plugins-maven-plugin.html) da seguinte forma:

Abrindo o terminal e digitando

```shell
mvn spring-boot:run
```

Feito isso, basta abrir o navegador e digitar o endereço <a href="http://localhost:8080" target="_blank">`http://localhost:8080`</a>

Caso não consiga executar localmente a aplicação, acesse <a href="https://telzir-arthur-lima.herokuapp.com/" target="_blank">`https://telzir-arthur-lima.herokuapp.com/`</a>, a aplicação ficará em execução para ser avaliada

---