Training List REST API
A Spring Boot REST API that returns an ArrayList of Training objects, each containing information about location, pin code, capacity, subjects, email, and phone number. The API exposes a single endpoint to fetch the list of trainings in JSON format.

Table of Contents
Project Overview
Technologies Used
Project Setup
Usage
API Endpoint
Sample Response
Project Overview
This project is a Spring Boot REST API that returns a list of Training objects as an ArrayList. Each Training object includes the following details:

Location
Pin Code
Capacity
Subjects (List of Strings)
Email
Phone Number
The API is useful for fetching training data in JSON format.

Technologies Used
Java 11 or higher
Spring Boot 2.5.x or higher
Maven for dependency management
Spring Web for REST API creation
Project Setup



Usage
After running the application, you can fetch the list of trainings by making a GET request to the /api/trainings/list endpoint.

API Endpoint
Method	Endpoint	Description
GET	/api/trainings/list	Returns a list of Training objects.
Sample Response
json
Copy code
[
    {
        "location": "Chandigarh",
        "pinCode": 140301,
        "capacity": 100,
        "subjects": ["Physics", "Chemistry"],
        "email": "as491631@gmail.com",
        "phone": "8294188813"
    },
    {
        "location": "Delhi",
        "pinCode": 110001,
        "capacity": 150,
        "subjects": ["Mathematics", "Biology"],
        "email": "delhi.train@gmail.com",
        "phone": "8294188814"
    }
]
Customizing Data
To add or modify the data returned by the API, edit the list in the TrainingController class:

java
Copy code
// In TrainingController.java
ArrayList<Training> trainings = new ArrayList<>();
trainings.add(new Training("Chandigarh", 140301, 100, List.of("Physics", "Chemistry"), "as491631@gmail.com", "8294188813"));
trainings.add(new Training("Delhi", 110001, 150, List.of("Mathematics", "Biology"), "delhi.train@gmail.com", "8294188814"));
Conclusion
This project demonstrates how to create a simple REST API using Spring Boot to return a list of objects. You can easily extend this functionality by adding more fields, endpoints, or integrating with a database for dynamic data.

