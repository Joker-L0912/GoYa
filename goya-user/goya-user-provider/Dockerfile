FROM openjdk:17-jdk-alpine
MAINTAINER Limoum0u

COPY ./target/goya-user-provider-1.0-SNAPSHOT.jar /app/
CMD ["java", "-Xmx200m", "-jar", "/app/goya-user-provider-1.0-SNAPSHOT.jar"]

EXPOSE 8030