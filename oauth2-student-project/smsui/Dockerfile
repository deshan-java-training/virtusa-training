FROM openjdk:8
ADD target/smsui-0.0.1-SNAPSHOT.jar student-ui.jar
EXPOSE 8095
ENTRYPOINT ["java", "-jar", "student-ui.jar"]