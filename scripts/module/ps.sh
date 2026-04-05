#!/bin/bash

# shellcheck disable=SC1091
source "$(dirname "$0")/common.sh"

echo "Service status:"
docker compose ps
