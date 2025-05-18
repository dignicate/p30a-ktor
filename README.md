# p30a-ktor

## Setup

local.properties
```
sdk.dir=/path/to/Android/sdk
```
put this file in the root of your project

## 🐳 Running with Docker

This project includes a `Dockerfile` for running the Ktor server inside a container.

### 🚧 Prerequisites

- Docker installed
- Gradle installed (or use the Gradle wrapper `./gradlew`)

---

### 📦 Build and Run Manually

To build the Ktor app and run it in Docker:

```bash
# 1. Build the application (creates installDist output)
./gradlew installDist

# 2. Build the Docker image
docker build -t my-ktor-app .

# 3. Run the container (exposes port 8080)
docker run -p 8080:8080 my-ktor-app
```

---

## 🧪 Running with Docker Compose

If you'd like to launch both the Ktor app and MongoDB container together:

```bash
# 1. Build the app
./gradlew installDist

# 2. Prepare Docker context
mkdir -p docker-context
cp -r build/install/ktor-app/bin docker-context/
cp -r build/install/ktor-app/lib docker-context/
cp Dockerfile docker-context/
echo "# dummy .dockerignore" > docker-context/.dockerignore

# 3. Start containers
docker compose up --build
```

This setup expects that your app is configured to connect to `mongo:27017`.
