#!/bin/bash

# Exit immediately if a command exits with a non-zero status.
set -e

# Find the repository root
REPO_ROOT=$(git rev-parse --show-toplevel)
cd "${REPO_ROOT}"

# Load environment variables
# shellcheck disable=SC1091
source "${REPO_ROOT}/scripts/.env.sh"
