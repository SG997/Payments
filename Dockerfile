# the first stage of our build will use a maven 3.6.1 parent image
FROM maven:3.8.4-jdk-11 AS MAVEN_BUILD
# copy the pom and src code to the container
COPY ./ ./
# package our application code
RUN mvn clean package
# the second stage of our build will use open jdk 8 on alpine 3.9
FROM openjdk:11
# copy only the artifacts we need from the first stage and discard the rest
COPY --from=MAVEN_BUILD /target/spring-boot-docker-payment.jar /spring-boot-docker-payment.jar

EXPOSE 8094
# set the startup command to execute the jar
CMD ["java", "-jar", "-Dspring.profiles.active=application-dev", "/spring-boot-docker-payment.jar"]



