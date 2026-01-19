# Use the OpenJDK 17 slim image as the base image
FROM openjdk:11

# Set the working directory inside the container
WORKDIR /app

# Copy the built JAR file into the container
COPY build/libs/dra_crud_postgres-0.0.1-SNAPSHOT.jar app.jar

# Expose the port your application runs on
EXPOSE 8080

# Command to run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
