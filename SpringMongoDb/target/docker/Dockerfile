FROM java:8

RUN mkdir -p /opt/app
ENV PROJECT_HOME /opt/app

COPY spring-boot-rest-mongodb-0.0.1-SNAPSHOT.jar $PROJECT_HOME/spring-boot-rest-mongodb-0.0.1-SNAPSHOT.jar

WORKDIR $PROJECT_HOME

CMD ["java", "-Dspring.data.mongodb.uri=mongodb://springboot-mongo:27017/springmongo-demo","-Djava.security.egd=file:/dev/./urandom","-jar","./spring-boot-rest-mongodb-0.0.1-SNAPSHOT.jar"]