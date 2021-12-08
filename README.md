# Robusta Test Automation Assignment

* Test [Ta3limy](https://www.ta3limy.com/) website by Implementing a test automation framework using **SHAFT_Engine** fot **GUI** front-end testing.
* Implementing modular design by Applying the Page Object Model design pattern (POM).
* Implementing method chaining by Applying the fluent design.
* Externalizing test data using JSON files And Applying data driven testing (DDT).

### Important notes to be known
* Captcha
    * According to the official documentation of selenium:
      </br> “CAPTCHA, short for Completely Automated Public Turing test to tell Computers and Humans Apart, is explicitly designed to prevent automation, **so do not try!**
    * [source](https://www.selenium.dev/documentation/test_practices/discouraged/captchas/)
* OTP (one time password)
    * According to the official documentation of selenium:
      </br>Two-Factor Authentication shouldn't be automated. a solution is to be disabled in lower environments, and a **magic code** should be provided from the development team to be used in testing.
    * [source](https://www.selenium.dev/documentation/test_practices/discouraged/two_factor_authentication/)
* However, **for the sake of this assignment**, I've implemented a solution for automating "Captcha". it will make the test more **flaky** as it's **not** considered to be a best practice.

# Technologies

* JDK-17
* [Maven](https://maven.apache.org/) as a build tool.
* [TestNG](https://testng.org/) as a unit test framework.
* [SHAFT_ENGINE](https://github.com/MohabMohie/SHAFT_ENGINE) which is a Test Automation Engine that provides a unified high-level interface to any of the underlying test automation frameworks.
* [Selenium WebDriver](https://www.selenium.dev/documentation/en/) for GUI testing.
* [Allure Report Framework](https://docs.qameta.io/allure/) for generating test execution report.
* [Docker](https://docs.docker.com/)
* [Selenium Grid](https://www.selenium.dev/documentation/grid/) for remote execution.
* [GitLab](https://docs.gitlab.com/) as a version control software.


# Run the Test
## 1. LOCALLY
Prerequisites: jdk-17 and maven should be installed

### 1.1 Run the Test locally using Eclipse IDE

* Import this project to your eclipse.
* Run the test cases/classes
* The report will be generated automatically after running the test.

### 1.2 Run the Test locally using IntelliJ IDEA

* Import this project to your intellij.
* Kindly, refer to this [link](https://github.com/MohabMohie/using_SHAFT_ENGINE) and follow the steps to add the listeners in intellij.
* Run the test cases/classes
* The report will be generated automatically after running the test.

### 1.3 Run the Test locally using the Terminal or CMD

* Clone or download the project.
* At the root directory of the project (e.g. downloads/projectName/); run the following command ```mvn test```
* The report will be generated automatically after running the test.

------------------

#### Important Note (for local execution):
- By default, the report will be automatically generated, but you can check the result of the test by running "generate_allure_report.bat" or "generate_allure_report.sh" files.

## 2. REMOTELY
Prerequisites: Docker should be installed

### 2.1. Run the Test remotely using Selenium-Grid and Docker
* Clone or download the project.
* To start selenium-grid using docker-compose; at the root directory of the project, run the following command <br />
```
docker-compose -f src/main/resources/docker-compose.yml up --scale chrome=2 --remove-orphans -d
```
* Open [http://localhost:4444/grid/console](http://localhost:4444/grid/console) to monitor selenium grid.
* Run the test using the following command <br />
```
mvn test -DexecutionAddress="localhost:4444" -DtargetOperatingSystem="Linux-64" -DmaximumPerformanceMode="2"
```
* To generate the report: <br />
    - run "generate_allure_report.sh" file if you're using linux/mac. <br />
    - run "generate_allure_report.bat" file if you're using windows.

* To end selenium grid; at the root directory, run the following
```
docker-compose -f src/main/resources/docker-compose.yml down --remove-orphans
```

