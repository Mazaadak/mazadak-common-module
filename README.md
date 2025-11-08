# Mazadak Common Module

### Shared library for all Mazadak microservices  
Centralized **Exception Handling** for consistent behavior across all services.

---

## What’s inside

| Category | Description |
|-----------|-------------|
| **Exception Handling** | `MazadakException` base class, domain exceptions (`InvalidBidException`, `UnauthorizedException`, etc.), and a global `@RestControllerAdvice` handler |
| **Configuration** | Auto-configures exception handling when added as a dependency (no setup needed) |
---

## How to Use in Your Service

### 1. Add the GitHub Packages repository
In your service’s `pom.xml`, add the **Mazadak GitHub Maven registry**:

```xml
<repositories>
  <repository>
    <id>github</id>
    <name>Mazadak GitHub Packages</name>
    <url>https://maven.pkg.github.com/Mazaadak/mazadak-common-module</url>
  </repository>
</repositories>
````

---

### 2. Add the dependency

```xml
<dependency>
  <groupId>com.mazadak</groupId>
  <artifactId>mazadak-common-module</artifactId>
  <version>1.0.7</version> <!-- replace with the latest version -->
</dependency>
```

> 💡 Check the [Mazadak Packages](https://github.com/Mazaadak/mazadak-common-module/packages/2728003) latest version number.

---

### 3. Add `com.mazadak.common` to component scanning

If your Spring Boot application restricts component scanning (for example, by specifying packages in `@ComponentScan` or using a base package in `@SpringBootApplication`), add `com.mazadak.common` so the common module's auto-configured exception handler is detected.

Example (main application class):

```java
@SpringBootApplication
@ComponentScan(basePackages = {"com.yourapp", "com.mazadak.common"})
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
```

If you rely on package scanning by convention and your application root package already includes `com.mazadak.common`, no change is necessary.

---

### 4. Authenticate (only once per developer)

GitHub Packages for Maven **requires authentication** — even for public packages.

#### Add credentials to your Maven config:

- **Windows:** `%USERPROFILE%\.m2\settings.xml`
- **macOS/Linux:** `~/.m2/settings.xml`

```xml
<settings>
    <servers>
        <server>
            <id>github</id>
            <username>${env.GITHUB_USERNAME}</username>
            <password>${env.GITHUB_TOKEN}</password>
        </server>
    </servers>
</settings>
```

> Generate a token at: [https://github.com/settings/tokens](https://github.com/settings/tokens)

**Token scopes:**

* ✅ `read:packages`
* ✅ `repo` *(if this repo is private)*

#### To Set Environment Variables
   - **macOS/Linux**:
     ```bash
     export GITHUB_USERNAME=your-username
     export GITHUB_TOKEN=ghp_xxx
     ```
   - **Windows PowerShell**:
     ```powershell
     setx GITHUB_USERNAME your-username
     setx GITHUB_TOKEN ghp_xxx
     ```

---

### 5. Build your service

In your service repo:

```bash
mvn clean package
```

---


## Auto-Configuration

The global exception handler (`@RestControllerAdvice`) is **auto-registered** in every service that includes this dependency.
No need to modify `@ComponentScan` or add imports.

To disable it in a service:

```yaml
mazadak:
  exception:
    enabled: false
```
