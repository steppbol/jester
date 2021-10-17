FROM openjdk:17-alpine
ARG JAR_FILE=target/jester-*.jar
COPY ${JAR_FILE} app/jester.jar
ENTRYPOINT ["java","-jar","app/jester.jar"]