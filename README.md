# Master Automation Project

This project is an automated testing suite for a web application built with Selenium and Java. It aims to validate the functionality and performance of various features within the application by implementing test cases for critical workflows such as user registration, login, product management, and more.

## Project Overview

This project aims to provide a robust and reusable framework for web application testing. Using Selenium WebDriver and Java, this framework facilitates testing of UI elements and workflows, ensuring they work as expected across different scenarios. The project is modularized with a clear separation between page classes (Page Object Model) and test classes, enhancing readability, maintainability, and scalability.

### Features

- **POM**: Organizes page elements and actions in dedicated classes, making tests easier to read and maintain.
- **TestNG Testing Framework**: Utilizes TestNG for structuring and executing test cases.
- **Reusable Base Class**: `BaseTest` sets up common configurations and test environment settings.
- **Modular Test Cases**: Independent test classes are created for different modules, such as Home, Products, and Signup, providing modularity and ease of maintenance.

## Project Structure

```
Master-Automation

├── .docs/
│   └── TestCases.md
├── .idea/
├── src/
│   ├── main/
│   │   └── java/
│   │       └── pages/
│   │           ├── Base.java
│   │           ├── Cart.java
│   │           ├── ContactUs.java
│   │           ├── Home.java
│   │           ├── Login.java
│   │           ├── Products.java
│   │           └── Signup.java
│   └── test/
│       ├── java/
│       │   ├── Properties/
│       │   │   └── PropReader.java
│       │   ├── practice/
│       │   ├── tests/
│       │   │   ├── BaseTest.java
│       │   │   ├── ContactUsTest.java
│       │   │   ├── HomeTest.java
│       │   │   ├── LoginTest.java
│       │   │   ├── ProductsTest.java
│       │   │   ├── SignupTest.java
│       │   │   └── checkCode.java
│       │   └── utils/
│       │       └── jsonReader.java
│       └── resources/
│           ├── config/
│           │   └── prop.properties
│           └── data/
│               └── testData.json
│
├── .gitignore                
├── pom.xml                    
└── README.md        
```

## Getting Started

### Prerequisites

- **Java**: Make sure JDK 8 or higher is installed.
- **Maven**: Ensure Apache Maven is installed for dependency management.

### Installation

1. Clone this repository:
   ```bash
   git clone https://github.com/ahmedelgebali/Master-Automation
   ```
2. Navigate to the project directory:
   ```bash
   cd Master-Automation
   ```
3. Install dependencies with Maven:
   ```bash
   mvn install
   ```

### Running Tests

Run the tests using Maven or directly from your IDE.

To run tests via Maven:
```bash
mvn test
```

### Documentation

- [Test Cases](docs/TestCases.md): Detailed list of test cases with steps and expected outcomes.
- Test cart: https://docs.stripe.com/testing 

## Contributing

Contributions are welcome!

Connect with me: ```elgebalia34@gmail.com```
