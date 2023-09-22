
# Automation Exercise

It covers all functional test cases of the following testing website
    Url = https://automationexercise.com/





## Overview

- This is simple project to showcase Web Test Automation in Java.
- The project struture is based on hybrid testing framework.
- App Url = https://automationexercise.com/
- TestCases = https://automationexercise.com/test_cases
- Project uses Selenium WebDriver
- Skills: UI Test Automation, Page Object Factory, TestNG
- Languages: Java
- SCM: Git
- Build/Dependency Management: Maven
- Testing: Data-Driven (Excel sheet Integration using apache poi)
- Assertion Lib: Selenium, WebDriver


## Prerequisite for running :
    1. Eclipse IDE should be installed.
    2. Java should be installed.
    3. Selenium
    4. Maven should be installed.
    5. Using TestNG framework for Test Cases
## Installation Steps
*  Create Maven Project in Eclipse IDE:
   - Lunch Eclipse IDE >> File >> New >> Project
   - Select Maven Project and click Next
   - Check Create a Simple Project and click Next
   - Enter Group Id and Artifact Id and click Next
   - Add Selenium Java and TestNG dependencies to pom.xml
   - Create package >> Create Class >> Add test cases.
   - Create Test Suite XML file.
        - Right click on the project >> TestNG >> Convert to TestNG >> Change xml file name on Location field (Default testng.xml will be created).
   - Run Tests from Command Line using Maven




 
## Running tests :

To run test using maven, open Command Line

```bash
  mvn clean test -DsuiteXMLFile=testng.xml
```
    