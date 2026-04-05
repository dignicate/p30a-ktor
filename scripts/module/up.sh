#!/bin/bash

# shellcheck disable=SC1091
source "$(dirname "$0")/common.sh"

echo "Building the application..."
./gradlew installDist

echo "Starting services..."
docker compose up --build -d
