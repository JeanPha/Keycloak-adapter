FROM openjdk:17-jdk-slim
ARG JAR_FILE=target/keycloack-adapter-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} app_keycloack.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app_keycloack.jar"]