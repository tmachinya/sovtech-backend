## Instructions to bootstrap the application:
1.	Git clone https://github.com/tmachinya/sovtech-backend.git
2.	Open a terminal or command prompt and navigate to the root folder of the cloned repository.
3.	Install dependencies: Once you have cloned the repository, navigate to the root directory of the project in a terminal and run the following command to install the dependencies:  mvn install.
4.	Run the application: Once the dependencies have been installed, you can run the application using the following command: mvn spring-boot:run
5.	This will start the Spring Boot application and make it available at http://localhost:8080/. 
6.	NB: To start the frontend, the application must be running.

## Endpoints:
1. all People:  http://localhost:8080/api/people
2. all People on a particular page: http://localhost:8080/api/people?page=8
3. search a person by name: http://localhost:8080/api/people?search=Anakin Skywalker