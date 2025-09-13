# Gemini Code Assistant Context

## Project Overview

This is a Java project demonstrating the use of virtual threads, a feature introduced in Java 21. The main application (`Java21Tut.java`) compares the performance of running a large number of simple tasks using both traditional platform threads and new virtual threads.

The project is configured to use Java 21 and is managed by Apache Maven.

## Building and Running

### Prerequisites

*   Java 21
*   Apache Maven

### Compilation

To compile the project, run the following command in the root directory:

```bash
mvn compile
```

### Running the Application

To run the application, use the following command:

```bash
mvn exec:java
```

This will execute the `main` method in `com.mycompany.java21.tut.Java21Tut`. The output will show "Hello World!", whether virtual threads are being used, and the total time taken to execute the tasks.

### Running Tests

To run the tests, use the following command:

```bash
mvn test
```

*(Note: There are currently no tests in this project.)*

## Development Conventions

*   The project follows standard Maven project structure.
*   Source code is located in `src/main/java`.
*   Tests are located in `src/test/java`.
