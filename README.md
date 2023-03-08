# coding-challenge-rewardsService

**Build & Deploy**

This project requires JDK 11 to build and run the application. 

**Run & Test Locally from command line**

To run locally you must use the following Grade commands to first compile and then run the project:

To compile (and run included JUnit tests) run the following from command line:
**/gradlew clean build**

To run the project (this starts Spring Boot's embedded Tomcat server) run the following from command line:
**./gradlew bootRun**

Your local app runs on port 8080, by default. You can test the app using: 
http://localhost:8082/api/rewards/{customerId}

**sample data set**

![data](https://user-images.githubusercontent.com/127347353/223863440-95b05255-b447-47b8-84ab-d3d4ea4783bd.PNG)

results for customerId 1
```json
{
  "FEBRUARY 2023": 0,
  "MARCH 2023": 2,
  "JANUARY 2023": 540
}
```
results for customerId 2
```json
{
  "FEBRUARY 2023": 186,
  "JANUARY 2023": 0,
  "MARCH 2023": 2
}
```
results for customerId 3
```json
{
  "FEBRUARY 2023": 250,
  "MARCH 2023": 2,
  "JANUARY 2023": 890
}
```

