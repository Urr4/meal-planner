# 1st stage, build the app
FROM maven:3.8.1-adoptopenjdk-11 as build
WORKDIR /application

# Do the Maven build!
# Incremental docker builds will resume here when you change sources
ADD pom.xml .
ADD src src
RUN echo "Building application"
RUN mvn package -DskipTests

FROM arm32v7/openjdk:11
COPY --from=build /application/target/meal-planner-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]

EXPOSE 8080
RUN echo "Done!"