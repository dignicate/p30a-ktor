# Use the official Java 17 base image (eclipse-temurin is stable and recommended)
FROM eclipse-temurin:17-jdk

# Set the working directory inside the container
WORKDIR /app

# Copy all files from build/install/{project-name} into the container
COPY build/install/ktor-app/ ./

# Make the startup script executable (needed especially on macOS Docker)
RUN chmod +x ./bin/ktor-app

# Run the application
ENTRYPOINT ["./bin/ktor-app"]
