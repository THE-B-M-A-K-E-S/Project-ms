FROM openjdk:17
EXPOSE 8082
ADD target/project-ms.jar project-ms.jar
ENTRYPOINT ["java", "-jar", "project-ms.jar"]