# Spring Cloud Azure Config Docker Sample

This sample describes how to use [spring-cloud-starter-azure-appconfiguration-config](../../spring-cloud-azure-starters/spring-cloud-starter-azure-appconfiguration-config/) to load configuration properties from Azure Configuration Service to Spring Environment.

## Prerequisite

* A [Java Development Kit (JDK)](https://docs.microsoft.com/java/azure/jdk/?view=azure-java-stable), version 8.
* [Apache Maven](http://maven.apache.org/), version 3.0 or later.
* Docker

## How to run

### Configure the bootstrap.properties

Create an Environment Variable matching the one listed or overwrite the placeholder value and update the Dockerfile.

### Run the application

1. Build the application using:

```console
mvn clean package
```

1. Build the docker container.

```console
docker build -t azureAppConfigContainer .
```

1. Run the newly built container.

```console
docker run -e CONNECTION_STRING=%CONNECTION_STRING% -p 8080:8080 -i -i azureAppConfigContainer /bin/bash
```

1. Once the application has fully started goto http://localhost:8080 to check the returned value.

## More details

Please refer to this [README](../../spring-cloud-azure-starters/spring-cloud-starter-azure-appconfiguration-config/) about more usage details.
