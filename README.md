# Selenium 4 features

***

## Test Framework

This repository contains test code to execute new Selenium 4 features. Java is used along with with TestNG framework. 

### Pre-requisites

* [Git](http://gitscm.com/)
* [Java SE 12+](https://www.oracle.com/java/technologies/downloads/)
* [Intellij](https://www.jetbrains.com/idea/download/#section=mac)
* [Maven Depedencies](https://mvnrepository.com/)

### Setup

Clone this GIT repository to the local machine as follows:

```javascript
git clone git@github.com:sbmallik/selenium4.git
cd selenium4
```

Configure a new Maven project in Intellij and use the above location. Add the `dependencies` section inside the `pom.xml` file as per this [file](https://github.com/sbmallik/selenium4/blob/main/pom.xml#L16-L33). 
The dependencies are `TestNG`, `Selenium Java` and `WebDriverManager`. Next, reload the Maven dependencies within the project.

## Running Tests

Since this repository is created for demonstration purpose only, the files are exepected to be executed individually from the IDE. Please use the `Intellij` run feature in this regard. 
