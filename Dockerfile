FROM openjdk:11.0.5-jdk-slim
VOLUME /tmp
EXPOSE 8081
ARG JAR_FILE=target/frm-api.jar
COPY ${JAR_FILE} frm-api.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/frm-api.jar"]