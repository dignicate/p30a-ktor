#!/bin/bash

# Configurable command keywords
CMD_SHELL="shell"
CMD_EXEC="exec"

# Find the MongoDB container
MONGO_CONTAINER=$(docker ps --format '{{.Names}}' | grep mongo | head -n 1)

# Usage message
print_usage() {
  echo "Usage:"
  echo "  $0 $CMD_SHELL            # Start interactive MongoDB shell"
  echo "  $0 $CMD_EXEC <file.js>   # Execute JavaScript file in MongoDB"
  exit 1
}

# No arguments: show usage
if [ $# -eq 0 ]; then
  print_usage
fi

# Check container
if [ -z "$MONGO_CONTAINER" ]; then
  echo "❌ MongoDB container not found."
  exit 1
fi

# Handle subcommands
case "$1" in
  "$CMD_SHELL")
    echo "💬 Starting mongosh in $MONGO_CONTAINER"
    docker exec -it "$MONGO_CONTAINER" mongosh
    ;;
  "$CMD_EXEC")
    if [ -z "$2" ]; then
      echo "❌ Missing file path."
      print_usage
    fi
    JS_FILE="$2"
    if [ ! -f "$JS_FILE" ]; then
      echo "❌ File not found: $JS_FILE"
      exit 1
    fi
    echo "📄 Executing $JS_FILE in $MONGO_CONTAINER"
    docker cp "$JS_FILE" "$MONGO_CONTAINER":/tmp/temp_script.js
    docker exec -it "$MONGO_CONTAINER" mongosh /tmp/temp_script.js
    ;;
  *)
    echo "❌ Unknown command: $1"
    print_usage
    ;;
esac
