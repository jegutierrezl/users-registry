FROM maven:3.6.0-jdk-11-slim AS build
COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean package

FROM openjdk:11-jdk-slim

WORKDIR /app

COPY --from=build /home/app/target/user-registry.jar /app/

ENTRYPOINT ["java","-jar","user-registry.jar"]