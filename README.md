# ms-price-retriever
microservice that obtains price and rate for articles

## OpenAPI doc

json: http://localhost:8080/v3/api-docs
Download in yaml format: http://localhost:8080/v3/api-docs.yaml
Swagger: http://localhost:8080/swagger-ui/index.html#/

## Run App

docker build -t ms-price-retriever .

docker run -p 8080:8080 ms-price-retriever

acceder a ella abriendo un navegador y visitando http://localhost:8080 