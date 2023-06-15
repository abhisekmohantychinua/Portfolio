FROM openjdk:17-alpine AS build
WORKDIR /workspace/app
COPY . /workspace/app
COPY .env /workspace/app/src/main/resources/.env
RUN chmod +x gradlew 
RUN ./gradlew clean build

FROM openjdk:17-alpine
VOLUME /tmp
ARG DEPENDENCY=/workspace/app/build/libs/*-SNAPSHOT.jar
COPY --from=build ${DEPENDENCY} app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]
EXPOSE 8080
