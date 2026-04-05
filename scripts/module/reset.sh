#!/bin/bash

# shellcheck disable=SC1091
source "$(dirname "$0")/common.sh"

echo "Stopping services and removing volumes..."
docker compose down -v
