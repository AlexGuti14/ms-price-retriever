FROM eclipse-temurin:17-jre-alpine
COPY ./build/libs/ms-price-retriever-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app.jar"]