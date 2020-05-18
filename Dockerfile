FROM azul/zulu-openjdk-alpine:11
RUN apk update && apk add bash
ADD target/azure-app-config-docker-0.1.0.jar app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]