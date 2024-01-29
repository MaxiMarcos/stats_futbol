<h2>Documentation:<h2> 
[Swagger UI] http://localhost:tupuerto/swagger-ui/index.html

### Instructions:

**Endpoints "controller-player" - Examples:**

- **PUT /players/{id_original}:** 
  - Example: If you send the endpoint "/players/{3}", next you will edit of the player with the ID 3 (the Armani player, but you can edit the name too).
  
- **GET /players** 
  - You will receive information about the all players existing.
  
- **POST /players** 
  - You complete the request body with the data for creating a new player.

- **GET /players/{id}:** 
  - Example: If you send "id: 7", you will receive information about the player with the ID 7.
  
- **DELETE /players/{id}:** 
  - Example: If you send "id: 4", the player with that ID 4 will be deleted.

**Endpoints "controller-team" - Examples:**

- **GET /teams** 
  - You will receive information about the all teams existing.

- **POST /players**
  - You complete the request body with the data for creating a new team.

- **GET /teams/{id}:** 
  - Example: If you send "id: 3", you will receive information about the team with the ID 3.

- **DELETE /players/{id}:** 
  - Example: If you send "id: 2", the player with that ID 2 will be deleted.