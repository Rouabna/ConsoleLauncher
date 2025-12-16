FROM openjdk:17-jdk-slim

WORKDIR /app

COPY target /app/target
COPY lib /app/lib

CMD ["java", "-jar", "lib/junit-platform-console-standalone-1.8.1.jar", "-cp", "target", "-c", "FirstUnitTest"]
