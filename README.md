# OrangeHRM Automation using TestNG & Selenium
A TestNG automation project for the HR management system - https://opensource-demo.orangehrmlive.com/
## Project Summery
This project aims to automate the testing of the HR management system using TestNG framework. It performs various actions such as creating employees, searching for employees, updating employee information, and more.

## Technology Used
* Java
* Intellij idea
* Allure

## Pre requisites 
* JDK 11
* TestNG framework
* Selenium WebDriver
* Browser driver (e.g., ChromeDriver) compatible with your browser version

## Test Scenario:
1. Login as a admin to https://opensource-demo.orangehrmlive.com/
2. Go to PIM menu and create a new employee. Save the employee firstname, lastname, employeeid, username and password into JSONArray file. Generate random password which meets following criteria: For a strong password, please use a hard to guess combination of text with upper and lower case characters, symbols and numbers. Assert if employee is created successfully.
3. Now go to the dashboard again and search by the employee id to check if the employee is found
4. Now go to the Directory menu and search by employee name and check if the employee is found and Logout the session.
5. Now login with the newly created employee creds
6. Assert your full name is showing besides the profile icon.
7. Go to my info
8. Scroll down and select Gender and Blood Type as O+ and save it. Then logout the user.

## How to run this project:
1. clone this project
2. To run Master suite (regression testing) hit this command gradle clean test -PsuiteFile="MasterSuite.xml"
3. To run SmokeMaster suite (smoke testing) hit this command gradle clean test -PsuiteFile="SmokeMasterSuite.xml"
4. To generate allure report hit these command
5. allure generate allure-results --clean -output
6. allure serve allure-results

## Test Cases
https://docs.google.com/spreadsheets/d/1PerVcIdQjeocqQQaDA4h0bQ_6rrWwhOY/edit?usp=sharing&ouid=110318663577610864826&rtpof=true&sd=true

## Allure Report
![Screenshot_2](https://github.com/user-attachments/assets/372c19ec-e5f1-473a-b70a-c48302763a81)






