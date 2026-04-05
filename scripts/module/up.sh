#!/bin/bash

# shellcheck disable=SC1091
source "$(dirname "$0")/common.sh"

echo "Starting services..."
docker compose up --build -d
