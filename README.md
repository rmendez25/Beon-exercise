# BEONDemo

## Overview
BEONDemo is a Java-based automation framework for both UI and API testing. It leverages Selenium WebDriver for browser automation and Rest-Assured for API validation. TestNG is used as the test runner.

## Technology Stack
- Java 17
- Maven
- Selenium WebDriver
- Rest-Assured
- TestNG
- Hamcrest (assertions)
- Jackson (JSON serialization)

## Project Structure
```
pom.xml                  # Maven configuration and dependencies
src/
  main/
    java/                # (Reserved for application code)
    resources/           # (Reserved for application resources)
  test/
    java/
      api/               # API test classes, POJOs, utilities
      ui/                # UI test classes, page objects, base classes
      resources/         # Test data (e.g., createPet.json)
target/                  # Build output
```

### Key Packages
- `ui.base`    : Base classes for UI tests (WebDriver setup, common actions)
- `ui.pages`   : Page Object Model classes (e.g., GoogleHomePage)
- `ui.tests`   : UI test cases (e.g., DemoTest)
- `api.pojo`   : Data models for API payloads
- `api.seeders`: Test data generators for API
- `api.tests`  : API test cases (e.g., CrudApiTest)
- `api.util`   : API utility classes (e.g., RestUtils)

## How to Run
1. **Install dependencies:**
   ```sh
   mvn clean install
   ```
2. **Run all tests:**
   ```sh
   mvn test
   ```
3. **Run a specific test class:**
   ```sh
   mvn -Dtest=ui.tests.DemoTest test
   mvn -Dtest=api.tests.CrudApiTest test
   ```

## Setup Instructions
- Ensure you have Java 17+ and Maven installed.
- Chrome browser and chromedriver should be available for UI tests.
- API tests assume a running Pet API at the configured endpoint.

## Author
- [Your Name]

---
For more details, see the Javadoc comments in the source code.

