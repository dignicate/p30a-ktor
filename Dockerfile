# ./gradlew installDist
# docker build -t my-ktor-app .
# docker run -p 8080:8080 my-ktor-app

# Use the official Java 17 base image (eclipse-temurin is stable and recommended)
FROM eclipse-temurin:17-jdk

# Set the working directory inside the container
WORKDIR /app

# Copy the application binaries and libraries
COPY ./build/install/ktor-app/bin/ ./bin/
COPY ./build/install/ktor-app/lib/ ./lib/

# Make the startup script executable (needed especially on macOS Docker)
RUN chmod +x ./bin/ktor-app

# Run the application
ENTRYPOINT ["./bin/ktor-app"]