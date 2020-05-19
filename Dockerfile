FROM mcr.microsoft.com/java/jdk:11-zulu-alpine
ADD target/spring-boot-docker-refresh-fail-0.1.0.jar app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom -Xmx300m","-jar","/app.jar"]