#!/bin/bash

ENV=$1

if [ -z "$ENV" ]; then
  echo "Usage: $0 [dev|prd]"
  exit 1
fi

# 環境変数を渡してビルド＆実行
ENV=$ENV ./gradlew run
