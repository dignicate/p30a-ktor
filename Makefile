DOCKER_CONTEXT_DIR := docker-context

.PHONY: docker-up

docker-up:
	@echo "▶ Step 1: Build Ktor with Gradle"
	./gradlew installDist

	@echo "▶ Step 2: Prepare docker-context directory"
	rm -rf $(DOCKER_CONTEXT_DIR)
	mkdir $(DOCKER_CONTEXT_DIR)
	cp -r build/install/ktor-app/bin $(DOCKER_CONTEXT_DIR)/
	cp -r build/install/ktor-app/lib $(DOCKER_CONTEXT_DIR)/
	cp Dockerfile $(DOCKER_CONTEXT_DIR)/

	@echo "▶ Step 3: Run docker compose"
	docker compose up --build
