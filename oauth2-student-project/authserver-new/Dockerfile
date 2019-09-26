FROM openjdk:8
ADD target/authserver-new-0.0.1-SNAPSHOT.jar student-oauthserver.jar
EXPOSE 8099
ENTRYPOINT ["java", "-jar", "student-oauthserver.jar"]