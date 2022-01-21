# 1st stage, build the app
FROM maven:3.8.1-adoptopenjdk-11 as build
WORKDIR /application

# Do the Maven build!
# Incremental docker builds will resume here when you change sources
ADD pom.xml .
ADD src src
RUN mvn package -q -DskipTests

FROM arm32v7/openjdk:11
ARG JAR_FILE=/application/target/*.jar
COPY --from=build ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]

EXPOSE 8080