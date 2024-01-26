# Data about football

This is a project that will have as its main functionality to manage data and statistics of football players.

It consists of two entities, 'teams' and 'player', which are related. When we create and load a team into the database, we will have the possibility to assign players existing in the other entity. Similarly, there are other options provided by the CRUD: Read, edit, and delete (teams and players).

In addition to the standard CRUD capabilities for managing teams and players, this project features an advanced data filtering functionality. Users have the ability to perform specific searches based on detailed statistics. For instance, the application enables searching for players with an outstanding performance, exhibiting an average goals scored per match exceeding 0.4. his feature is particularly valuable for statistical analysis enthusiasts and team coaches seeking to swiftly identify the most prolific goal-scoring players. Of course, also is possible search by positions players, and soon there will be more advanced searches.


<h2>Tech Stack</h2>
<a href="https://docs.oracle.com/en/java/">Java</a> <br>
<a href="https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/">Spring Boot</a><br>
<a href="https://dev.mysql.com/doc/">MySQL</a><br>
<a href="https://hibernate.org/orm/documentation/6.4/">Hibernate</a><br>
<a href="https://spring.io/projects/spring-data-jpa">JPA</a>

<h2>Documentation:<h2> 
[Swagger UI](http://localhost:<puerto>/swagger-ui/).

### Instructions:

**Endpoints "controller-player" - Examples:**

- **PUT /players/{id_original}:** 
  - Example: If you send the endpoint "/players/{3}", next you will edit of the player with the ID 3 (the Armani player, but you can edit the name too).
  
- **GET /players** 
  - You will receive information about the all players existing
  
- **POST /players** 
  - You complete the request body with the data for creating a new player.

- **GET /players/{id}:** 
  - Example: If you send "id: 7", you will receive information about the player with the ID 5(the Laso player).
  
- **DELETE /players/{id}:** 
  - Example: If you send "id: 4", the player with that ID will be deleted.

