FROM    gradle:8-jdk17-alpine
WORKDIR /app
COPY    build.gradle .
COPY    gradlew .
COPY    settings.gradle .
COPY    gradle gradle
COPY    .env ./src/main/resources/
COPY    gradlew.bat .
COPY    src src
RUN     ./gradlew clean build --no-daemon
COPY    ./build/libs/Portfolio-0.0.1-SNAPSHOT.jar App.jar
EXPOSE  8080
ENTRYPOINT  ["java","-jar","App.jar"]