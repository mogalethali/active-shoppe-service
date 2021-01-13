FROM openjdk:8

EXPOSE 8080

ADD target/active-shoppe-services.jar active-shoppe-services.jar

ENTRYPOINT ["java","-Dspring.data.mongodb.uri=mongodb://mongodb/activeshoppe_db","-jar","/active-shoppe-services.jar"]