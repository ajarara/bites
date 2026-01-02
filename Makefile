.PHONY: help gradlew

# --- Pattern Rules ---

# Pattern for 'make build-jvm', 'make build-rust', etc.
build-%:
	@$(MAKE) --no-print-directory target-$* TASK=build

# Pattern for 'make test-jvm', 'make test-rust', etc.
test-%:
	@$(MAKE) --no-print-directory target-$* TASK=test

# --- Language Dispatcher ---

target-jvm:
	@if [ "$(TASK)" = "build" ]; then mvn -f jvm/pom.xml compile; \
	 else mvn -f jvm/pom.xml test; fi

target-go:
	@cd go && go $(TASK) ./...

target-rust:
	@cargo $(TASK) --manifest-path rust/Cargo.toml

target-c:
	@$(MAKE) -C c $(TASK)

# --- Special Cases ---

# Usage: make gradlew assembleDebug
gradlew:
	@echo "Unsupported -- use flatpak when you're home"
	false
	@cd android && ./gradlew $(filter-out $@,$(MAKECMDGOALS))

# --- Infrastructure ---

help:
	@echo "Polyglot Repo Commands:"
	@echo "  make build-[jvm|go|rust|c]"
	@echo "  make test-[jvm|go|rust|c]"
	@echo "  make gradlew [tasks]"

# Silence target errors for gradlew arguments
%:
	@:
