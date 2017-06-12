# springBurger

A re-make of my classic burger app using Java, Maven, MariaDB, Thymeleaf, and the Spring MVC framework.

It will also include an Excel download feature for users to analyze burger consumption.

Check it out!

https://java-burger.herokuapp.com/



### Sources

Currently referencing the following...


For Java Basics:

https://www.youtube.com/playlist?list=PLE7E8B7F4856C9B19

https://www.tutorialspoint.com/java/index.htm


For Java-Excel API

https://www.mkyong.com/java/jexcel-api-reading-and-writing-excel-file-in-java/


For Maven Basics:

https://www.youtube.com/watch?v=al7bRZzz4oU&list=PL92E89440B7BFD0F6

https://www.tutorialspoint.com/maven/maven_quick_guide.htm

https://mvnrepository.com/


For Spring MVC Basics:

https://spring.io/guides/gs/serving-web-content/

https://www.youtube.com/playlist?list=PLBgMUB7xGcO31B2gBmy1igpZn6LK78-CJ


ThymeLeaf Basics:

http://www.thymeleaf.org/doc/articles/standarddialect5minutes.html


Spring MVC + AngularJS:

https://www.youtube.com/playlist?list=PL4gCdGOq-cxJrbRMWjrIvGhYqQO1tvYyX



### Cloning Down the Repo

Save yourself all the headache and open the project with IntelliJ...

  - Download [IntelliJ](https://www.jetbrains.com/idea/) Community Edition

  - Using the Import option, select the pom.xml file.

  - IntelliJ will automatically build the dependencies using Maven (built into IntelliJ).

  - Then, open MySQL workbench and create a burger database using the `schema.sql` file.

  - After that, click the green play button in IntelliJ to run the project.

  - Finally, open up to localhost:8080 in your browser to see the webapp in action.


If you dare to take a command line approach...

  - Seed the database using the schema file from above.

  - Using [Maven](https://maven.apache.org/), run `mvn compile` to download all dependencies.

  - Using Maven, run `mvn package` to package the project into a war file.

  - Then, you can run `java -jar target/burger-0.1.0.war` to launch the server. Just note that you may need to have [Tomcat](http://tomcat.apache.org/) installed.

  - Finally, open up to localhost:8080 in your browser to see the webapp in action.

  - If needed, you can remove all downloaded dependencies using `mvn clean`.