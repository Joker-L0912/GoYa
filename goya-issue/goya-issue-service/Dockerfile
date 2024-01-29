FROM openjdk:17-jdk-alpine
MAINTAINER Limoum0u

COPY ./target/goya-issue-service-0.0.1-SNAPSHOT.jar /app/
CMD ["java", "-Xmx200m", "-jar", "/app/goya-issue-service-0.0.1-SNAPSHOT.jar"]

EXPOSE 8020 20880