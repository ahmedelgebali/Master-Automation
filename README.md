## Master Automation Practical Project
I made this personal project to practice and apply web automation using Selenium and Java. the goal here isn’t to build something huge, but rather to get more hands-on experience with writing automated tests, structuring a clean framework, and trying out different and new features step by step.

### Project Overview    
I built this as a kind of learning playground. The idea is to simulate real test scenarios you'd face in a web app — like user registration, login, working with products, adding things to a cart, going through checkout, and similar flows. It’s all about testing the main stuff that users would usually do on a site.
The structure follows the POM, so each page has its own class with the elements and the actions for it to help keep things organized and make the test code easier to work with later on.

#### Features

- **POM**: organizes page elements and actions in dedicated classes, making tests easier to read and maintain.
- **TestNG Testing Framework**: utilizes TestNG for structuring and executing test cases.
- **Reusable Base Class**: `BaseTest` sets up common configurations and test environment settings.
- **Modular Test Cases**: independent test classes are created for different modules, such as Home, Products, and Signup, providing modularity and ease of maintenance.

### Project Structure

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

### Getting started

#### prerequisites

- **Java**: make sure an updated JDK is installed.
- **Maven**: ensure Apache Maven is installed.

### Installation

1. clone this repository:
   ```bash
   git clone https://github.com/ahmedelgebali/Master-Automation
   ```
2. cavigate to the project directory:
   ```bash
   cd Master-Automation
   ```
3. install dependencies with Maven:
   ```bash
   mvn install
   ```

#### Running Tests

run the tests using Maven or directly from your IDE.

To run tests via Maven:
```bash
mvn test
```

#### Documentation

- [Test Cases](docs/TestCases.md): detailed list of test cases with steps and expected outcomes.
- Test cart: https://docs.stripe.com/testing 

## Contributing

contributions are welcome!

connect with me: ```elgebalia34@gmail.com```
