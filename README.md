# Employees_Skills


## The tools I used:

### REST API
Used Spring to build the REST API because it provides the means to build:
* Backwards compatible APIs
* Evolvable APIs
* Scaleable services
* Securable services
* A spectrum of stateless to stateful services

Spring provides specific annotations for REST applications (e.g.RestController ) and by the use of Repositories and Entities, the connection is automated.

Based on:https://spring.io/guides/tutorials/rest/

### Maven
I used maven because of its Core Concepts:
1. **POM Files**: Project Object Model(POM) Files are XML file that contains information related to the project and configuration information such as dependencies, source directory, plugin, goals etc. used by Maven to build the project. When you should execute a maven command you give maven a POM file to execute the commands. Maven reads pom.xml file to accomplish its configuration and operations.
2. **Dependencies and Repositories**: Dependencies are external Java libraries required for Project and repositories are directories of packaged JAR files. The local repository is just a directory on your machine hard drive. If the dependencies are not found in the local Maven repository, Maven downloads them from a central Maven repository and puts them in your local repository.
3. **Build Life Cycles, Phases and Goals**: A build life cycle consists of a sequence of build phases, and each build phase consists of a sequence of goals. Maven command is the name of a build lifecycle, phase or goal. If a lifecycle is requested executed by giving maven command, all build phases in that life cycle are executed also. If a build phase is requested executed, all build phases before it in the defined sequence are executed too.
4. **Build Profiles**: Build profiles a set of configuration values which allows you to build your project using different configurations. For example, you may need to build your project for your local computer, for development and test. To enable different builds you can add different build profiles to your POM files using its profiles elements and are triggered in the variety of ways.
5. **Build Plugins**: Build plugins are used to perform specific goal. you can add a plugin to the POM file. Maven has some standard plugins you can use, and you can also implement your own in Java.

https://www.geeksforgeeks.org/introduction-apache-maven-build-automation-tool-java-projects/#:~:text=Maven%20is%20a%20powerful%20project,the%20build%20process%20like%20ANT.&text=maven%20make%20the%20day%2Dto,of%20any%20Java%2Dbased%20project.


### Hibernate
Hibernate ORM (or simply Hibernate) is an object-relational mapping tool for the Java programming language. It provides a framework for mapping an object-oriented domain model to a relational database. Hibernate handles object-relational impedance mismatch problems by replacing direct, persistent database accesses with high-level object handling functions.

Hibernate's primary feature is mapping from Java classes to database tables, and mapping from Java data types to SQL data types.

https://en.wikipedia.org/wiki/Hibernate_(framework)#:~:text=Hibernate%20ORM%20(or%20simply%20Hibernate,model%20to%20a%20relational%20database.&text=It%20generates%20SQL%20calls%20and,conversion%20of%20the%20result%20set.

### Database
Used Mysql database for local database.
MySQL is a freely available open source Relational Database Management System (RDBMS) that uses Structured Query Language (SQL). SQL is the most popular language for adding, accessing and managing content in a database. It is most noted for its quick processing, proven reliability, ease and flexibility of use.

### Postman
Postman is a popular API client that makes it easy for developers to create, share, test and document APIs. This is done by allowing users to create and save simple and complex HTTP/s requests, as well as read their responses.
Postman is very convenient when it comes to executing APIs. Once you’ve entered and saved them, you can simply use them over and over again, without having to remember the exact endpoint, headers, API keys, etc.


## Documentation for the project

### Define operations in terms of HTTP methods

 The common HTTP methods used by most RESTful web APIs are:
 * **GET**: Get a representation of the target resource’s state.
 * **POST**:Let the target resource process the representation enclosed in the request.
 * **PUT**:Set the target resource’s state to the state defined by the representation enclosed in the request.
 * **DELETE**: Delete the target resource’s state.

Resource | POST | GET | PUT | DELETE
---------|------|-----|-----|-------
/employees|Create a new employee|Retrieve all employees|Update an employee|--
/employees/1|--|Retrieve employee with id 1| --|Delete employee with id 1
/skills|Create a new skill|Retrieve all skills|Update an skill|--
/skills/1|--|Retrieve skill with id 1| --|Delete skill with id 1


## JSON outputs example:

**GET** :` ...\api\employees\3`
```json
    {"id":3,"firstName":"Ajay","lastName":"Rao","email":"ajay@luv2code.com","phone":"(30)6954786523","address":"Eleftheriou Venizelou 5","hiringDate":"2017-02-15 00:00:00.0","birthday":"1942-03-15 00:00:00.0","availability":true,"skills":[{"id":1,"name":"Ethics","description":"moral principles that govern a person's behaviour or the conducting of an activity","creationDate":"2017-01-20 00:00:00.0","required":true},{"id":5,"name":"Problem solving","description":"The process of finding solutions to difficult or complex issues","creationDate":"2017-01-20 00:00:00.0","required":false}]}
```

**POST** :` ...\api\employees\`
```json
    {"id":8,"firstName":"Nikos","lastName":"Papadopoulous","email":"nikos_papadopoulos@gmail.com","phone":"(30)6954754653","address":"Eleftheriou Venizelou 5","hiringDate":"2017-02-15 00:00:00.0","birthday":"1942-03-15 00:00:00.0","availability":true,"skills":[{"id":1,"name":"Ethics","description":"moral principles that govern a person's behaviour or the conducting of an activity","creationDate":"2017-01-20 00:00:00.0","required":true},{"id":5,"name":"Problem solving","description":"The process of finding solutions to difficult or complex issues","creationDate":"2017-01-20 00:00:00.0","required":false}]}
```

*more instance examples for each postman example I run are in [Documentation](https://github.com/Tzomily/Employees_Skills/tree/main/Documentation) file.
Also, [my postman collection](https://www.getpostman.com/collections/52d5a400883022379bf3).*

## Database Diagram:
![alt text](https://github.com/Tzomily/Employees_Skills/blob/main/Documentation/DatabaseDiagram.PNG)


## Future Features

There are many features that could be added to this project. In my opinion some of the important ones are:
* **Further Get, Post, Put, Delete methods**: For example, it would be more user friendly if it was possible to connect skills with employees just by id.
So far, adding skills to employees or employees to skills is done with the use of PUT and the body of json given.
* **Better updating of ids on DB**: The ids are auto-incremented but when an entry is deleted, the empty spot isn't filled by the new input.
* **Testing**: Tests are needed to secure quality of the application and the right-operation. So far, the application has been manually tested and an effort for automatic tests has been made(but not completed).
* **Logging and Metrics**: Logging and Metrics are required when an application becomes very big, so that traffic can be monitored, as well as, the application's performance
* **Front end extension**: The application should have a more user-frienly output that can simplify the methods with the use of buttons (or something similar).
* **Securiyt features**: In most cases, it is required to have authorised access before accessing/editing a database.
* **Search options**: A variety of search options and filters that would simplify the data viewed.
