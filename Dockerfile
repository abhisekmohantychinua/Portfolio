# Use openjdk:17 as the base image
FROM openjdk:17 as builder

# Set the working directory
WORKDIR /app

# Copy the Gradle wrapper files
COPY gradlew .
COPY gradle gradle

# Copy the Gradle build files
COPY build.gradle .
COPY settings.gradle .

# Copy the source code
COPY src src

# Install findutils package
RUN microdnf install findutils

# Run the Gradle build inside the container
RUN chmod +x gradlew && \
    ./gradlew clean build

# Use openjdk:17 as the base image for the final runtime image
FROM openjdk:17

# Set the working directory
WORKDIR /app

# Copy the JAR file from the builder stage
COPY --from=builder /app/build/libs/Portfolio-0.0.1-SNAPSHOT.jar App.jar

# Expose port 8080
EXPOSE 8080

# Set the entrypoint to run the application
ENTRYPOINT ["java", "-jar", "App.jar"]
