# Selenium - Page Object Model
This is a sample project to demonstrate what is page object model framework  and how it can used in selenium (This is only one way of implementing page object framework ).

**junit** is used as test framework.
Sample application used for automation is [http://accountsdemo.herokuapp.com/](http://accountsdemo.herokuapp.com/).

### Dependency
1. Java
2. Maven

###libraries used
1. Selenium
2. Junit
3. log4j

### Steps to clone execute the tests
```
git clone https://github.com/reachbharathan/Java-Junit-POM-AccountsDemo.git
cd Selenium-Page-Object-Model-Junit-Java
mvn clean test
```


### How to use this repo
1. First have a look into the http://accountsdemo.herokuapp.com/ repo and create a test account  register the
2. Go to testSuite1 folder and go through the each @test in the class by step order
3. Then proceed to testSuite2 and go through the class by step order
4. Right click and Run each @test from any of the ide like intelliJ or eclipse and understand the test scenario flow
5. Execute `mvn clean test site` from root folder, index.html report will be generated in target folder
6. The entire test suite can be executed from a single test runner file "TestRunner"

#### Note
1. For ease of use i have used chrome driver, ensure to reference to correct path of the chrome driver in the properties file depending on the path and OS
2. This is just a sample project feel free to add more tests and mocks if interested.






