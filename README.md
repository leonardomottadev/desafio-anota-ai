# AnotaAí Challenge API Documentation
 
> RESTful API using Spring 3.2 for a product catalog management system in a marketplace application

This API provides resources for managing categories and products.

## Category

Represents a category for classifying products.

### Attributes
- `id` (String): Category ID.
- `title` (String): Category title.
- `description` (String): Category description.
- `ownerId` (String): Owner ID of the category.

#### Example JSON Object
```
{
  "id": "1",
  "title": "Appetizers",
  "description": "Starters to whet the appetite.",
  "ownerId": "123"
}
```
## Product
Represents an item available in the restaurant menu.
### Attributes
- `id` (String): Product ID.
- `title` (String): Product title.
- `description` (String): Product description.
- `ownerId` (String): Owner ID of the product.
- `price` (Integer): Product price.
- `category` (String): ID of the category to which the product belongs.
#### Example JSON Object
```
{
  "id": "1",
  "title": "Grilled Chicken Salad",
  "description": "A delicious salad with grilled chicken.",
  "ownerId": "123",
  "price": 12.99,
  "category": "1"
}
```

## API Endpoints

### Categories

- **POST `/api/categories`**: Create a new category.
- **GET `/api/categories`**: Retrieve all categories.
- **PUT `/api/categories/{id}`**: Update an existing category.
- **DELETE `/api/categories/{id}`**: Delete a category.

### Products

- **POST `/api/products`**: Create a new product.
- **GET `/api/products`**: Retrieve all products.
- **PUT `/api/products/{id}`**: Update an existing product.
- **DELETE `/api/products/{id}`**: Delete a product.
  
## Diagram representing the final structure of the project

![image](https://github.com/githubanotaai/new-test-backend-nodejs/assets/52219768/504ba448-f128-41db-ae86-18dc19c0dc9d)

## Usage

### application.properties
Create an `application.properties` file in the `src/main/resources/` folder:
```
server.port= {Server port}
mongodb.connection= {MongoDB connection URL}
aws.accessKeyId= {IAM user access key}
aws.secretKey= {IAM user secret key}
aws.region= {AWS region}
aws.sns.topic.catalog.arn= {SNS topic ARN}
```
### Build & Run
Execute the following command:
```
#Build project command
mvn compile

#Run project command
mvn spring-boot:run

```
