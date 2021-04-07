FROM openjdk:11-jdk-slim
RUN groupadd heycar && adduser --system listing && adduser listing heycar
USER listing:heycar
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]