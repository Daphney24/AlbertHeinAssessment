# AlbertHeinAssessment

Tech Stack: Java , RestAssured , TestNG, Maven

Assessment:
Digital Savings API service for a new feature in the app and website a new backend service needs to be created. The mobile appie app and the website are going to use this service and can show the amount of stamps a user gathered. Users can save stamps to get discounts on themepark (Efteling) tickets, or tableware. 
Digital Savings Service URL + userID ---> returns stamps 
Requirements: 
- Amount of stamps can be retrieved 
- Number of full cards can be retrieved 
- A userID is needed to get the information 
- The service always returns the promotion

To Do:
Automate two testcases in a language and tool of choice. Put the code on GitHub or send it with a .zip file.
(1)Test the endpoint is working
(2)Test that the number of stamps is returned when end poibt is hit
(3)Test if promotion is not numm, ie Promotion exists
(4)Test response is Not Found when incorrect userID is passed in URL


Framework Architecture
--------------
    PayconiqAssessment
	   |
       |_src/main/java
       |  |_org.base.test
       |  |  |_BaseTest.java   
       |  |_utils
       |  |  |_ExtentReportListener.java
	   |_src/main/resources
       |  |_config.properties
	   |_src/test/java
       |  |_org.payconiq.test
	   |  |  |_AlbertheinApiTest.java
       |  |_org.alberthein.model.test
       |  |  |_Customer.java
       |  |  |_Promotion.java

   
Building Up the Framework
--------------
	
* Step 1 : Create a maven project
* Step 2 : Add dependencies in pom.xml
* Step 3 : Add testing plugin
* Step 4 : Create tests
* Step 5 : Run and Verify

**Note the run and verify are only applicable if API exist

### Installation (pre-requisites)
1. JDK 1.8+ (make sure Java class path is set)
2. Maven (make sure .m2 class path is set)
3. IDE (Eclipse, IntelliJ, etc)
4. TestNG
5. Rest Assured Dependencies
6. Git

Setup Instructions
--------------
Clone the repo from below copmmand or download zip and set it up in your local workspace.
```
git clone https://github.com/Daphney24/AlbertHeinAssessment.git
```

Verify Installation and Running test
--------------
Use Maven:
	
Go to your project directory from terminal and hit following commands
```
mvn test
```

**Note: The above step is only aplicable if API exists
	
	
### Reporters
	
Once you ran your tests, the reports are generates in Extent Reports Format to communicate pass/failure.To look at the results in IDE, open the folder 
test-output/Report/test/ExtentReport.html

**Note: The above step is only valid if API exists.
