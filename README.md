# p30a-ktor

## 開発環境のセットアップ

このプロジェクトは Docker を利用して開発環境を構築します。

### 1. 前提ツールの確認

まず、お使いの環境に `docker` と `docker compose` がインストールされていることを確認してください。

```bash
docker --version
docker compose version
```

もしインストールされていない場合は、公式サイトの手順に従って [Docker Desktop](https://www.docker.com/products/docker-desktop/) をインストールしてください。

### 2. 開発用スクリプト

開発に必要な操作はすべて `scripts/devctl` スクリプトに集約されています。

主なコマンドは以下の通りです。

| コマンド                                         | 説明                                                           |
|----------------------------------------------| -------------------------------------------------------------- |
| `sh ./scripts/devctl up`                     | 必要な Docker イメージをビルドし、サービスを起動します。       |
| `sh ./scripts/devctl down`                   | サービスを停止します。                                         |
| `sh ./scripts/devctl restart`                | サービスを再起動します。                                       |
| `sh ./scripts/devctl logs`                   | サービスのログを表示します。（`-f` オプション付き）            |
| `sh ./scripts/devctl ps`                     | 現在のサービスの状態を表示します。                             |
| `sh ./scripts/devctl reset`                  | **DBデータを含む**すべてのコンテナとボリュームを削除します。   |
| `sh ./scripts/devctl mongo shell`            | 実行中の MongoDB コンテナに対して `mongosh` を起動します。     |
| `sh ./scripts/devctl mongo exec <script.js>` | 実行中の MongoDB コンテナで指定した JS スクリプトを実行します。|

### 3. データベースの初期化

MongoDB の `p30a` データベースに初期データを投入するには、以下のコマンドを実行します。
各スクリプトは既存データを削除してから投入するため、再実行できます。

```bash
# 国マスターデータを投入
sh ./scripts/devctl mongo exec scripts/db/full_insert_country_complete.js

# 企業マスターデータを投入
sh ./scripts/devctl mongo exec scripts/db/full_insert_company_complete.js
```

**注意:**
初回起動時に自動でデータが投入される仕組みは現在ありません。
`./scripts/devctl reset` を実行するとデータベースのデータもすべて消去されるため、再度上記コマンドでのデータ投入が必要です。

## 運用について

本番環境やステージング環境での操作は、従来通り `scripts/p30actl` を使用します。
`scripts/devctl` は開発用途に限定してください。
