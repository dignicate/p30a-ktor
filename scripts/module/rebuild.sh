#!/bin/bash

# shellcheck disable=SC1091
source "$(dirname "$0")/common.sh"

echo "Building the application..."
./gradlew installDist

echo "Rebuilding services..."
docker compose up --build -d --force-recreate
