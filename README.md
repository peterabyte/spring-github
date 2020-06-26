# Spring GitHub

## Overview

This is a simple web application based on *Spring Boot* to understand the basics of *GitHub API v3*.

## Dependencies

### Runtime dependencies

*[Spring Dynamic Language Support](http://docs.spring.io/spring/docs/current/spring-framework-reference/html/dynamic-language.html)*: Spring 2.0 introduces comprehensive support for using classes and objects that have been defined using a dynamic language (such as Groovy) with Spring. This support allows you to write any number of classes in a supported dynamic language, and have the Spring container transparently instantiate, configure and dependency inject the resulting objects.

*[Spring Boot](http://projects.spring.io/spring-boot/)*: Spring Boot makes it easy to create stand-alone, production-grade Spring based Applications that you can "just run".

* *Web*: Starter for building web, including RESTful, applications using Spring MVC. Uses Tomcat as the default embedded container.

* *Actuator*: Spring Boot Actuator includes a number of additional features to help you monitor and manage your application when it’s pushed to production.

*[Thymeleaf](http://www.thymeleaf.org/)*: Thymeleaf is a modern server-side Java template engine for both web and standalone environments.

*[hub4j/github-api](https://github.com/hub4j/github-api)*: This library defines an object oriented representation of the GitHub API.

*[GitHub REST API v3](https://developer.github.com/v3/)*: This describes the resources that make up the official GitHub REST API v3.

### Dev dependencies

*[gradle](https://gradle.org/)*: Gradle is an open source build automation system that builds upon the concepts of Apache Ant and Apache Maven and introduces a Groovy-based domain-specific language (DSL) instead of the XML form used by Apache Maven of declaring the project configuration.

## How to

### Setup

The following software should be installed on your computer.

* Java

* gradle

### Start

To run the web application locally without building a jar first you can use the command `gradle bootRun`. This will start the web application with the specified *port* and *debug port* located in the *build.gradle* file. 
