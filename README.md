## Instructions to bootstrap the application:
1.	Git clone https://github.com/tmachinya/sovtech-backend.git
2.	Open a terminal and navigate to the root folder of the cloned repository.
3.	Install dependencies: **mvn install**
4.	Run the application: **mvn spring-boot:run**
5.	Application is available at http://localhost:8080/
6.	NB: To start the frontend, the application must be running.

## Endpoints:
1. all People:  http://localhost:8080/api/people
2. all People on a particular page: http://localhost:8080/api/people?page=8
3. search a person by name: http://localhost:8080/api/people?search=Anakin Skywalker