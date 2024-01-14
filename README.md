# ms-price-retriever

***
Microservice that obtains price and rate for articles.

## Table of Contents

1. [About The Project](#about-the-project)
2. [Architecture](#architecture)
2. [Technologies](#technologies)
3. [Getting Started](#getting-started)
4. [Documentation](#documentation)
5. [Contact](#contact)
6. [License](#license)

## About The Project

Microservice in charge of providing an endpoint rest to obtain the rate and price to be applied to a product.

If two rates coincide in a date range, the one with the higher priority (higher numerical value) is applied.

### Input parameters

- brand identifier
- product identifier
- application date

#### Example

http://localhost:8080/api/v1.0/prices?brandId=1&productId=35455&date=2020-06-14-12.20.42

### Output parameters

- brand identifier
- product identifier
- start application date
- end application date
- rate
- price
- currency

The currency attribute has been added to the answer. It complements the price attribute and depending on the country
this value could change.
The previous name curr has been updated to currency because it is a more specific name.

In addition, the original price_list attribute has been changed to rate because it is a more specific name.

#### Example

```json
{
   "brandId": 1,
   "startDate": "2020-06-14T00:00:00",
   "endDate": "2020-12-31T23:59:59",
   "rate": 1,
   "productId": "35455",
   "price": 35.5,
   "currency": "EUR"
}
```

## Architecture

A three-layer architecture has been used. This architecture is a commonly used approach in software development to
separate responsibilities and organise code in a modular and maintainable way.

The Controller layer, is solely responsible for exposing the functionality so that it can be consumed by external
entities. The Repository layer, is responsible for storing and retrieving some set of data. The Service layer is where
all the business logic should go.

This architecture promotes separation of concerns and facilitates modularity, code reuse and maintainability. In
addition, it supports the principle of dependency inversion.

## Technologies

- Java 17
- Gradle 8.5
- Spring Boot 3.2.1
- JUnit 5
- Mockito
- H2

## Getting Started

### Prerequisites

- Java 17
- Gradle 8.5
- Docker

### Installation

1. Clone the repo
   ```sh
   git clone https://github.com/AlexGuti14/ms-price-retriever.git
   ```
2. Build the image
   ```sh
   ./gradlew build
   ```
2. Build the docker image
   ```sh
   docker build -t ms-price-retriever .
   ```
3. Run the application
   ```sh
   docker run -p 8080:8080 ms-price-retriever
   ```
4. Execute the application
    ```sh
   curl -X GET "http://localhost:8080/api/v1.0/prices?brandId=1&productId=35455&date=2020-06-14-12.20.42"
   ```
5. Run test case
    ```sh
   ./gradlew test
   ```

## Documentation

OpenAPI documentation in json format: [OpenAPI](http://localhost:8080/v3/api-docs)

Click here tom download in .yaml format: [api-docs.yaml](http://localhost:8080/v3/api-docs.yaml)

Swagger documentation: [Swagger](http://localhost:8080/swagger-ui/index.html#/)

## Contact

Alejandro Gutierrez - [LinkedIn](https://www.linkedin.com/in/agutierrezbolea/)

ms-price-retriever: [GitHub](https://github.com/AlexGuti14/ms-price-retriever)

## License

MIT

The code in this repository is covered by the included license.

However, if you run this code, it may call on the OpenFin RVM or OpenFin Runtime, which are covered by OpenFin’s
Developer, Community, and Enterprise licenses. You can learn more about OpenFin licensing at the links listed below or
just email us at support@openfin.co with questions.

https://openfin.co/developer-agreement/ <br/>
https://openfin.co/licensing/