This is a pet project designed using:
TECHNOLOGY
Java
Spring Boot 3.2.2
Spring Security
Oauth2 resource server
Maven 
Mysql
Spring web
Spring Data Jpa
Project Lombok.
The aim of the project is to build a spring boot + spring Security application with JSON Web Token(JWT) in that:
      A user can register new account
      Login with email and password, and a JWT token is generated for the authenticated/authorized user to access the truck drivers application endpoints, by calling the restful APIs below:
      POST /auth/register -To register a new account
      POST /auth/login    -To login an account and received a JWT token
      GET /api/drivers/getAllDrivers  -To fetch all drivers from Mysql database
      GET /api/drivers/{employeeID}   -To get a driver info by his/her employeeId
      GET /api/trucks/getAllTrucks   -To fetch all trucks from the database.
      GET /api/trucks/{assetId}      -To get a truck info by truck assetId.
      GET /api/drivers/getAllDriver?pageNumber=0&pageSize=5  -To get a paginated list of drivers
      GET /api/trucks/getAllTruck?pageNumber=0&pageSize=5    -To get a paginated list of trucks.

All drivers and trucks details for the project was provided in a miscrosoft excel sheet. 
The excel document was converted to a CSV file format to enable proper import to my Mysql database.

      
