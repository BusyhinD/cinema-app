# 🎥 Cinema Web App 🎥
### Project description:

The Cinema Web App is a Java web application that allows users to explore and select interesting films, find available sessions for the films, add them to a shopping cart, and conveniently order tickets.

+ The project incorporates various frameworks, including **Hibernate** and **Spring** (Core, MVC, and Security), to ensure efficient data management, dependency injection, and secure authentication. It follows **SOLID** principles and best practices, resulting in a robust and maintainable codebase. 
+ The application is developed using JDK 17 and utilizes Tomcat 9 as the web server and MySQL as the backend database management system.

## 🔎 Features
The Cinema Web App offers the following features:

#### Film Selection
* Browse a diverse collection of films.
* Access detailed information about each film, including descriptions and ratings.
* Filter films by genre tags.
#### Session Availability
* View up-to-date information on available sessions for selected films.
* Check showtimes, cinema halls, and seating availability.
#### Shopping Cart
* Add desired film sessions to the shopping cart.
* Review and modify selections before ordering tickets.
#### Order Placement
* Finalize selections from the shopping cart.
* Securely place ticket orders.
#### User Roles, Authentication, and Authorization
* The application implements user roles and authentication to differentiate between regular users and administrators. Registration (by default with the role user) or login as a user.

  + User Role: Regular users can explore films, view available sessions, add items to the shopping cart, and place orders.

  + Admin Role: Administrators have additional privileges. They can add movies with descriptions, manage cinema halls, and create movie sessions with existing movies and cinema halls.
* Register (by default with the role user) or login as user

#### URL Filters
* The app incorporates URL filters to ensure proper access control and security. Filters restrict access to specific URLs based on the user's role, allowing administrators to access administrative features while preventing unauthorized access.

## 🛠️ Getting Started
To run the Cinema Web App, follow these steps:

1. Ensure the following software is installed on your system:

  + Java Development Kit (JDK) 17 or later.

  + Apache Maven 3.6.0 or later.

  + MySQL 8.0 or another compatible RDBMS.

  + Tomcat 9.0 or another web server.

>Note: Visit the respective websites for each software package to download and install them following the provided instructions.

>Note: Followed steps actually for the Tomcat web server if you will use another you must deploy the project according to your web server.

2. After installing the required software, you can download the project source code from the GitHub repository:

```command
git clone https://github.com/BusyhinD/cinema-app
```
3. Configure the database connection details by editing the **_db.properties_** file (in the **_resources_** project folder) to pass the login, password, your database URL, and driver for your database management system. 

* In the **_util_** project folder, you can find **_DataInitializer_** class with only one method inject(), which runs with deploying the project, this method adds to the DB user role and admin role, and three users with a different set of roles. This class has a demonstrative purpose. Don't forget to delete this class if you want to use this server for your own goals.

4. Build the project using Maven:

```command
cd cinema-ticket-web-app
mvn package
```
5. Deploy the generated WAR (Web Application Archive) file to Tomcat or your chosen web server:

```command
cp target/cinema-ticket-web-app.war $CATALINA_HOME/webapps
```

>Note: By default Hibernate will create required tables (hibernate.hbm2ddl.auto in the **_db.properties_** file).

6. Start Tomcat or your web server, and access the application by navigating to http://localhost:8080/ in your web browser.

## ☕ Conclusion
Congratulations! You are now ready to explore and enhance the movie-going experience with the Cinema Web App. Should you encounter any questions or issues, please don't hesitate to contact me for support.
