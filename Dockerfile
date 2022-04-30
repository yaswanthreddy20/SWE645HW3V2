FROM maven:3.6-openjdk-17-slim AS build
COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean package

#
# Package stage
#
FROM openjdk:17-slim
COPY --from=build /home/app/target/studentsurvey-0.0.1-SNAPSHOT.jar /usr/local/lib/studentsurvey.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/usr/local/lib/studentsurvey.jar"]