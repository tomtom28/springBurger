# springBurger

A re-make of my classic burger app using Java, Maven, MySQL, Thymeleaf, and the Spring Boot framework.



### Sources

Currently referencing the following...


For Java Basics:

https://www.youtube.com/playlist?list=PLE7E8B7F4856C9B19

https://www.tutorialspoint.com/java/index.htm


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

Save yourself all the headache and open it into IntelliJ using the Import option, selecting the pom.xml file.


If you dare to take a command line approach...

Using Maven, run `mvn compile` to download all dependencies.

Using Maven, run `mvn package` to package the project into a war file.

Note you cannot run `java -cp target/classes/burger-0.1.0.war org.burger.Application`. Instead, you will need to open it via [Tomcat](http://tomcat.apache.org/) instead.

If needed, you can remove all downloaded dependencies using `mvn clean`.