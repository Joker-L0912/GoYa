FROM openjdk:17-jdk-alpine
MAINTAINER Limoum0u

COPY ./target/goya-auth-provider-0.0.1-SNAPSHOT.jar /app/
CMD ["java", "-Xmx200m", "-jar", "/app/goya-auth-provider-0.0.1-SNAPSHOT.jar"]

EXPOSE 8010