# coding-challenge-rewardsService

## Build and Deploy

This project requires JDK 11 to build and run the application. 

## Compile and Run

To compile and run the project, use the following Gradle commands from the command line:
```
./gradlew clean build   # Compile and run included JUnit tests
./gradlew bootRun       # Run the project (starts Spring Boot's embedded Tomcat server)
./gradlew test          # Run the JUnit tests
```
## Actuator Endpoints

The following Actuator endpoints are enabled:

- `/actuator/health`: Check the health of the application
- `/actuator/status`: Check the status of the application

To call these endpoints, use your web browser and send a request to the corresponding URL:

```
http://localhost:8080/actuator/health   # Health endpoint
http://localhost:8080/actuator/status   # Status endpoint
```

## Local Testing

Your local app runs on port 8080 by default. You can test the app using the following URL:
``` 
http://localhost:8080/api/rewards/{customerId}   # Test API endpoint
```

## Sample Data

Here is a sample data set you can use to test the app:

![data](https://user-images.githubusercontent.com/127347353/223863440-95b05255-b447-47b8-84ab-d3d4ea4783bd.PNG)


## Results

Here are some sample results for various customer IDs:

Customer ID 1
```json
{
  "FEBRUARY 2023": 0,
  "MARCH 2023": 2,
  "JANUARY 2023": 540
}
```
Customer ID 2
```json
{
  "FEBRUARY 2023": 186,
  "JANUARY 2023": 0,
  "MARCH 2023": 2
}
```
Customer ID 3
```json
{
  "FEBRUARY 2023": 250,
  "MARCH 2023": 2,
  "JANUARY 2023": 890
}
```

