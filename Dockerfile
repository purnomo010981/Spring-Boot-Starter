FROM openjdk:8-jdk-alpine
EXPOSE 8080
ADD target/springboot-0.0.1-SNAPSHOT.jar springboot-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/springboot-0.0.1-SNAPSHOT.jar"]