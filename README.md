# Active Shoppe Service

## Instruction:

## Assume that you already installed java 8 and docker on your machine
Checkout the project  from github and at the root, execute the command below:

- mvn clean package

When the build done, execute the command below to create the API and MongoDB containers.
- docker-compose up


From now on you will be able to access the services through the endpoints present in Swagger
## Link de acesso ao Swagger: http://localhost:8080/swagger-ui.html

#Testing  data

#Product
Get List of product
curl -X GET "http://localhost:8080/api/shop/products" -H "accept: */*"


Create product

