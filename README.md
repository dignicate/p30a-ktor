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

# 2. Prepare Docker context (flattened structure)
mkdir docker-context
cp -r build/install/ktor-app/bin docker-context/
cp -r build/install/ktor-app/lib docker-context/
cp Dockerfile docker-context/

# 3. Build the Docker image
cd docker-context
docker build -t my-ktor-app .

# 4. Run the container (exposes port 8080)
docker run -p 8080:8080 my-ktor-app
```

---

### Running with Docker Compose (includes MongoDB)

To spin up Ktor and MongoDB together:

1. Make sure the following `docker-compose.yml` exists in the project root:

```yaml
version: '3.8'

services:
  mongo:
    image: mongo:5.0
    container_name: dev-mongo
    ports:
      - "27018:27017"
    volumes:
      - mongo-data:/data/db
    networks:
      - app-network

  ktor:
    image: my-ktor-app:latest
    container_name: dev-ktor
    build:
      context: ./docker-context
      dockerfile: Dockerfile
    depends_on:
      - mongo
    ports:
      - "8080:8080"
    environment:
      - MONGO_URI=mongodb://mongo:27017
    networks:
      - app-network

volumes:
  mongo-data:

networks:
  app-network:
```

2. Build and launch:

```bash
docker compose up --build
```

3. The Ktor app should now be available at `http://localhost:8080`, and it will connect to MongoDB via the container-internal name `mongo`.

---

### Notes

- For production server deployment, you may set `mongo.host1.url=172.17.0.1` and `mongo.host1.port=27018` if using host MongoDB.
- Make sure the application reads Mongo settings correctly from `mongo.properties` or environment variables.
