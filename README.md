# ms-price-retriever

***
Microservice that obtains price and rate for articles order by priority.

## Table of Contents

1. [About The Project](#about-the-project)
2. [Architecture](#architecture)
2. [Technologies](#technologies)
3. [Getting Started](#getting-started)
4. [Documentation](#documentation)
5. [Contact](#contact)
6. [License](#license)

## About The Project

Microservice in charge of providing a rest endpoint to obtain the rate and price to be applied to a brand and product.

If two rates coincide in a date range, the one with the higher priority (higher numerical value) is applied.

### Input parameters

- brand identifier
- product identifier
- application date

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

http://localhost:8080/api/v1.0/prices?brandId=1&productId=35455&date=2020-06-14-12.20.42

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

### Improvements

- Currently, if few rates have the same priority it returns the first price found.
  A possible business improvement would be to sort by priority and also by rate or lowest price.


## Architecture

A hexagonal architecture, or ports and adapters architecture, has been used. This architecture is an architectural
pattern used in software design. It aims at creating loosely coupled application components that can be easily connected
to their software environment by means of ports and adapters. This makes components exchangeable at any level and
facilitates test automation.

- Modularity: Allows components to be changed without affecting other aspects of the system.
- Maintenance: The layers are independent, facilitating the maintenance and evolution of the system.
- Simplified Testing: The separation of layers facilitates unit and integration testing.
- Technological Flexibility: Allows changing technologies and frameworks in the external layers without affecting the
  core.

## Technologies

- Java 17
- Gradle 8.5
- Spring Boot 3.2.1
- JUnit 5
- Mockito
- H2
- OpenAPI

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
4. Execute endpoint
    ```sh
   curl -X GET "http://localhost:8080/api/v1.0/prices?brandId=1&productId=35455&date=2020-06-14-12.20.42"
   ```
5. Run test
    ```sh
   ./gradlew test
   ```
6. Open /build/reports/jacoco/test/html/index.html page to see the generated report

If you want to access the H2 database console: [H2 console](http://localhost:8080/h2-console)

## Documentation

When the application is running you can access the documentation:

- OpenAPI documentation in json format: [OpenAPI](http://localhost:8080/v3/api-docs)

Click here to download OpenAPI documentation in .yaml format: [api-docs.yaml](http://localhost:8080/v3/api-docs.yaml)

- Swagger documentation: [Swagger](http://localhost:8080/swagger-ui/index.html#/)

## Contact

Alejandro Gutierrez - [LinkedIn](https://www.linkedin.com/in/agutierrezbolea/)

ms-price-retriever project: [GitHub](https://github.com/AlexGuti14/ms-price-retriever)

## License

MIT

The code in this repository is covered by the included license.

However, if you run this code, it may call on the OpenFin RVM or OpenFin Runtime, which are covered by OpenFin’s
Developer, Community, and Enterprise licenses. You can learn more about OpenFin licensing at the links listed below or
just email us at support@openfin.co with questions.

https://openfin.co/developer-agreement/ <br/>
https://openfin.co/licensing/