# Spring Boot Docker Refresh Fail

This sample replicates an issue where Refresh fails when mcr.microsoft.com/java/jdk:11-zulu-alpine, when the container has >2 CPUs.

## Prerequisite

* A [Java Development Kit (JDK)](https://docs.microsoft.com/java/azure/jdk/?view=azure-java-stable), version 8.
* [Apache Maven](http://maven.apache.org/), version 3.0 or later.
* Docker

## How to run

### Run the application

1. Build the application

    ```console
    mvn clean package
    ```

1. Build the docker container.

    ```console
    docker build -t spring-boot-docker-refresh-fail .
    ```

1. Run the newly built container.

    ```console
    docker run -p 8080:8080 -i -i spring-boot-docker-refresh-fail /bin/bash
    ```

1. Once the application has fully started goto http://localhost:8080 to check the returned value, which will be the startup date of the property source.

1. Goto http://localhost:8080/refresh, which will trigger a Refresh inside of a CompletableFuture.

1. Goto http://localhost:8080, and you will see the updated datetime.

1. Update docker to use 4 CPUs instead of the default 2.

1. After Docker restarts, re-run steps 3-6, but this time the date will not be updated and the log will show.

    ```console
    INFO 1 --- [onPool-worker-3] o.s.c.e.event.RefreshEventListener       : Refresh keys changed: []
    ```
