FROM openjdk:17
COPY build/libs/Portfolio-0.0.1-SNAPSHOT.jar App.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/App.jar"]
