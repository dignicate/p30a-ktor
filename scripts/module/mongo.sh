#!/bin/bash

# shellcheck disable=SC1091
source "$(dirname "$0")/common.sh"

SUBCOMMAND=$1
shift

case $SUBCOMMAND in
shell)
  docker compose exec mongo mongosh
  ;;
exec)
  if [ -z "$1" ]; then
    echo "Usage: $0 mongo exec <script_path>"
    exit 1
  fi
  SCRIPT_PATH=$1
  docker compose exec -T mongo mongosh <"$SCRIPT_PATH"
  ;;
*)
  echo "Usage: $0 mongo <shell|exec>"
  exit 1
  ;;
esac
