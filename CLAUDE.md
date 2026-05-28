# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Project Overview

**PoE Data Visualizer** — a full-stack web app for visualizing Path of Exile item pricing trends. Spring Boot backend + React TypeScript frontend, packaged as a single JAR via Maven.

## Build & Run Commands

### Full build (backend + frontend)
```
mvn clean install
```

### Run the app
```
mvn clean compile exec:java
```
App runs at `http://localhost:8080`.

### Backend only
```
mvn clean compile
mvn test                  # Run Java tests
mvn validate              # Run Checkstyle
```

### Frontend only (from `frontend/`)
```
npm install               # Install deps
npm run dev               # Vite dev server with HMR
npm run build             # Production build → src/main/resources/static/
npm run lint              # ESLint
npx @tanstack/router-cli generate   # Regenerate routeTree.gen.ts (required after adding/renaming routes)
```

## Architecture

### Monorepo layout
- **`src/`** — Spring Boot backend (Java 17)
- **`frontend/`** — React 19 + TypeScript frontend (Vite)
- **`AncillaryFunctions/`** — Separate Maven module for GGG API ingestion and AWS Secrets Manager integration

### Integrated build pipeline
Maven's `frontend-maven-plugin` wires the two together:
1. Installs a pinned Node.js (v24.13.1) + npm into `target/` — do not rely on system Node for builds
2. Runs `npm ci`, generates TanStack routes, then runs `npm run build`
3. Vite outputs compiled assets to `src/main/resources/static/`
4. Spring Boot packages those static files into the JAR

### Request flow
- `GET /` → `HomeController` returns the `"index"` view (serves the React SPA)
- All other API calls from React hit Spring Boot REST endpoints (e.g. `GET /items/getItemsByCustomParameters`)
- React fetches data via the `useChartData` hook (`frontend/src/hooks/fetchChartData.ts`) backed by TanStack React Query

### Backend layers
- **Controllers** (`src/main/java/com/PhamKornbluhGroup/controllers/`) — REST endpoints; no service layer; call DAOs directly
- **DAOs** (`src/main/java/com/PhamKornbluhGroup/DAO/`) — interfaces for database access
- **MyBatis impls** (`src/main/java/com/PhamKornbluhGroup/mybatismysqlimpl/`) — SQL mapper interfaces
- **SQL mappers** (`src/main/resources/mappers/`) — XML mapper files split into `ingestionMappers/` and `filtrationMappers/`
- **DTOs** (`src/main/java/com/PhamKornbluhGroup/DTO/`) — rich domain objects with custom Jackson deserializers in `src/main/java/com/PhamKornbluhGroup/jsonParsing/`

### Frontend routing
TanStack Router uses file-based routing. Route files live in `frontend/src/routes/`. After adding or renaming a route file, regenerate the route tree with `npx @tanstack/router-cli generate` (or it runs automatically during `mvn install`).

### AWS / Secrets
`src/main/java/com/PhamKornbluhGroup/SecretsHelper.java` wraps AWS Secrets Manager. Database credentials are not stored in `application.properties` in production — they are retrieved at runtime from AWS.

## Key Configuration Files

| File | Purpose |
|---|---|
| `pom.xml` | Root Maven config; orchestrates frontend build via `frontend-maven-plugin` |
| `AncillaryFunctions/pom.xml` | Separate module build; independent from root |
| `src/main/resources/application.properties` | Spring Boot + HikariCP (max 10 / min 5 idle connections) |
| `src/main/resources/mybatisconfig.xml` | MyBatis setup: Log4j2, custom enum type handlers (FactionId, FrameType, DisplayMode), mapper registrations |
| `src/main/resources/log4j2.xml` | Logging config |
| `frontend/vite.config.ts` | Build output target, TanStack Router plugin, React Compiler |
| `.github/workflows/main.yml` | CI: runs `mvn validate` (Checkstyle) then `mvn test` |
