# AI Instructions

This repository provides an open API built with Kotlin and Ktor.

## Project shape

- `controller`: HTTP-facing entrypoints. Handle request parsing, validation, response mapping, and error translation.
- `domain`: business rules and application use cases. Keep this layer free of framework and persistence concerns.
- `data`: persistence and external integration. Put repository implementations, DTOs, and database access here.

## Dependency rules

- `controller` may depend on `domain`.
- `data` may depend on `domain`.
- `domain` must not depend on `controller` or `data`.
- Use Koin for dependency wiring only. Keep object creation and module registration in DI modules.

## Implementation guidance

- Prefer small, explicit use cases in `domain`.
- Keep Ktor-specific types out of `domain`.
- Keep database or transport DTOs out of `controller` unless they are response/request models.
- Validate input as early as practical, and keep validation rules close to the use case when they are business rules.
- Use `suspend` for I/O paths.
- Preserve API compatibility where possible, since this project is intended for public use.
- Treat Swagger/OpenAPI as part of the public API contract. Keep route behavior and `src/main/resources/openapi/documentation.yaml` aligned.
