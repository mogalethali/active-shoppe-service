#FROM openjdk:8

#EXPOSE 8080

#ADD target/active-shoppe-services.jar active-shoppe-services.jar

#ENTRYPOINT ["java","-Dspring.data.mongodb.uri=mongodb://mongodb/activeshoppe_db","-jar","/active-shoppe-services.jar"]

FROM openjdk:8-jdk-alpine
USER root
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]