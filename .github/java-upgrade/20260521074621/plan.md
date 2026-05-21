# Upgrade Plan: periplus-automation-testing (20260521074621)

- **Generated**: 2026-05-21 07:47:00
- **HEAD Branch**: main
- **HEAD Commit ID**: N/A

## Available Tools

**JDKs**
- Java 1.8.0_432: C:\Users\Anand\.jdks\corretto-1.8.0_432\bin
- Java 22.0.2: C:\Program Files\Java\jdk-22\bin (current project JDK)
- Java 21: **<TO_BE_INSTALLED>** (required by Step 1)

**Build Tools**
- Maven 3.9.16: D:\19 JUTA LAPANGAN PEKERJAAN\apache-maven-3.9.16\bin
- Maven Wrapper: not present

## Guidelines

> Note: You can add any specific guidelines or constraints for the upgrade process here if needed, bullet points are preferred.

## Options

- Working branch: appmod/java-upgrade-20260521074621
- Run tests before and after the upgrade: true

## Upgrade Goals

- Upgrade Java runtime target to the latest LTS: Java 21

## Technology Stack

| Technology/Dependency    | Current | Min Compatible | Why Incompatible / Notes                    |
| ------------------------ | ------- | -------------- | -------------------------------------------- |
| Java                     | 22      | 21             | User requested latest LTS; project currently targets Java 22 |
| Maven                    | 3.9.16  | 3.9.0          | Compatible with Java 21                       |
| selenium-java            | 4.21.0  | 4.0.0          | Compatible with Java 21                      |
| testng                   | 7.9.0   | 7.0.0          | Compatible with Java 21                      |
| java-dotenv              | 5.2.2   | 5.0.0          | Compatible with Java 21                      |

## Derived Upgrades

- Java target must be set to 21 because the user requested the latest LTS runtime.
- Use `maven.compiler.release` rather than `maven.compiler.source`/`target` to ensure compilation against Java 21 platform APIs when building under JDK 22.

## Impact Analysis

### Dependency Changes

| File | Dependency | Current | Action | Target | Reason |
|------|-----------|---------|--------|--------|--------|
| pom.xml | maven.compiler.source | 22 | replace | use `maven.compiler.release` 21 | Ensure compilation against Java 21 standard library, not Java 22 APIs |
| pom.xml | maven.compiler.target | 22 | remove | (managed by `maven.compiler.release`) | Avoid source/target mismatch under JDK 22 |

### Source Code Changes

No source code changes are required for this upgrade. The project code is compatible with Java 21 and does not use Java 22-only language features.

### Configuration Changes

No application or CI configuration changes are required in the repository for this upgrade.

### CI/CD Changes

No CI/CD files were identified in the project that require Java version updates.

### Risks & Warnings

- **Missing target JDK 21**: Java 21 is not currently installed on the system. Step 1 installs it and verifies the build.
- **Build environment uses JDK 22**: The current environment can compile against Java 22, so using `maven.compiler.release=21` is required to avoid accidental Java 22 API usage.
- **No Maven wrapper**: The project relies on a local Maven 3.9.16 installation; this is acceptable for Java 21 but means the build uses the local Maven installation rather than a checked-in wrapper.

## Upgrade Steps

- Step 1: Setup Environment
  - **Rationale**: Install the required target JDK 21 and confirm Maven 3.9.16 is available for Java 21 compilation.
  - **Changes to Make**: Install Java 21 using the available JDK installer tool; verify `java -version` and `mvn -version`.
  - **Verification**: Use JDK 21 and `mvn -version`; expected result is Java 21 and Maven 3.9.16 available.

- Step 2: Setup Baseline
  - **Rationale**: Capture the current project build state using the existing JDK 22 environment before modifying the pom.
  - **Changes to Make**: None to source or build files.
  - **Verification**: `mvn clean compile test-compile -q && mvn clean test -q` using the current JDK 22.

- Step 3: Apply Java 21 Target Upgrade
  - **Rationale**: Update POM compiler configuration to target Java 21 and remove the existing Java 22-specific source/target settings.
  - **Changes to Make**: Modify `pom.xml` to replace `maven.compiler.source`/`target` with `maven.compiler.release=21`.
  - **Verification**: `mvn clean test-compile -q` using JDK 21.

- Step 4: Final Validation
  - **Rationale**: Ensure the project compiles and all tests pass under the target Java 21 runtime.
  - **Changes to Make**: No further code changes unless test failures require fixes.
  - **Verification**: `mvn clean test -q` using JDK 21.
