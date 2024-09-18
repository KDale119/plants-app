FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app
COPY target/Plants-0.0.1-SNAPSHOT.jar plants.jar
EXPOSE 8080
CMD ["java", "-jar", "-Dsping.profiles.active=cloud", "plants.jar"]