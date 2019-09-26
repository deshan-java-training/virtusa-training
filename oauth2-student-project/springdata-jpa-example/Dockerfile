FROM openjdk:8
ADD target/spring-app-docker.jar spring-app-docker.jar
EXPOSE 8083
ENTRYPOINT ["java", "-jar", "spring-app-docker.jar"]