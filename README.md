# blog-service
This service was created following the rules of a technical challenge.

## Tools needed
Those are the tools needed to run the project:
* [Docker](https://www.docker.com/products/docker-desktop/)
* [Maven](https://maven.apache.org/download.cgi)
* [Java 17](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)

*>It's highly suggested to use IntelliJ as IDE, since it's going to abstract the needs to install Java and Maven, making necessary just to download and install docker.*

## Starting service
This service uses Spring Boot Docker Compose, so once it starts to boot it'll also build all the necessary containers to do that. Follow those commands to start the project:

``mvn clean install spring-boot:run``

If you want to force the dependency downloads, run the same command with ``-U`` argument.

``mvn clean install -U spring-boot:run``

*>There's no need to use `docker-compose up`, since the project is using **spring-boot-docker-compose**.*

## Next steps
As suggest in the technical challenge, those are my next steps if I had time:
* Fixing the ExceptionHandler for MethodArgumentNotValidException, I had to put it's handler inside the controller, rather than putting it inside of ControllerAdvice due to a priority error between the handler of Spring Validator and my own handler;
* Creating multiple environment configurations, at least for local, dev and production;
* Including Spring Doc for attributes of all DTOs;
* Refining README file with some diagrams to simplify the understanding of architecture and database model;
* Create a context load test;
* MAYBE Including in controller tests the returned object and making it run with an embedded database for integration testing.

## Project Structure
This is the project structure used in the project, and it's insights, explanation divide in packages:
* **Controller**: Controller is composed of a simple Controller interface, responsible for holding the method signature the controller and also the Spring Doc specifications, inside there's an impl subfolder with the implementation of that controller.
* **Domain**: Domain holds the three packages that composes the domain structure of the project, being those dto, entity and model:
    * **Dto**: Inside are all the DTOs, divided between requests and responses for each case that was necessary;
    * **Entity**: Inside are all entities used for the project, being those are our database entity mirrors;
    * **Model**: Inside are all models, models are classes that doesn't interact directly with the database neither the client, being used only inside the project.
* **Exceptions**: There are two types of classes inside Exceptions' package, one being the ControllerAdvicer responsible for holding all exceptions in the project and the others all custom exception needed for the project.
* **Mapper**: Classes with the responsibility to create a class using another as a base.
* **Repository**: Here we are using CrudRepository, so there are our interfaces with the database.
* **Service**: Classes with the business logic inside of it.

*>Aside of internal project structure is a **docs** folder, inside are the postman collection with all routes and an ER Diagram reflecting the database structure.*

## Database connection configuration
If you want to connect in the database through a Database UI Manager, those are the configurations:
* **Host**: 127.0.0.1
* **Port**: 53240
* **User**: blog_service_user
* **Password**: password
* **Database**: blogpostdb

For root access:
* **User**: root
* **Password**: password

## Technologies used
Those are the technologies used for built this project:
* [Docker](https://www.docker.com/)
* [Docker Compose](https://docs.docker.com/compose/)
* [Maven](https://maven.apache.org/)
* [Java 17](https://www.oracle.com/java)
* [Spring Initializr](https://start.spring.io/)
* [Spring Boot and Spring Stack](https://spring.io/projects/spring-boot)
* [MySQL](https://www.mysql.com/)
* [Flyway Migration](https://flywaydb.org/)
* [Lombok](https://projectlombok.org/)
* [Jackson](https://github.com/FasterXML/jackson)
* [Spring Doc](https://springdoc.org/)
* [JUnit 5](https://junit.org/junit5/)
* [Mockito](https://site.mockito.org/)