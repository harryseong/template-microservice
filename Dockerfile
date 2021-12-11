FROM openjdk:14-alpine
LABEL maintainer="harryseong@gmail.com"
VOLUME /tmp
EXPOSE 8080
ARG JAR_FILE=target/template-microservice-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} template-microservice.jar
ENTRYPOINT ["java","-Djava.sdokcecurity.egd=file:/dev/./urandom","-jar","/template-microservice.jar"]
