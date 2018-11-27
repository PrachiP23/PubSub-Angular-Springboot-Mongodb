FROM openjdk:10-jre-slim
COPY ./target/spring-boot-rest-mongodb-0.0.1-SNAPSHOT /usr/src/spring/
WORKDIR /usr/src/spring
EXPOSE 8080
ENTRYPOINT ["java", "-Dspring.data.mongodb.uri=mongodb://mongocontainer/test", "-Djava.security.egd=file:/dev/./urandom","-jar","spring-boot-rest-mongodb-0.0.1-SNAPSHOT"]