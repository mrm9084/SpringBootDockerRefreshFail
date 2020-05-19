FROM mcr.microsoft.com/java/jdk:11-zulu-alpine
RUN apk update && apk add bash
ADD target/azure-app-config-docker-0.1.0.jar app.jar
ADD bootstrap.properties bootstrap.properties
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom -Xmx300m","-jar","/app.jar", "-Dspring.config.location=./bootstrap.properties"]