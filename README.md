# Pub/Sub Model using Angular-Springboot-Mongodb
In a Publisher/Subscriber model, any message published by the publisher to a topic, is immediately received by all the subscribers of the topic.

##Pre-requisites:
1. Java - 1.8.x
2. Maven - 3.x.x
3. NodeJS - 8.x or 10.x
4. MongoDB 

## Steps to Setup:
Following instructions will get you a copy of the project up and running on your local machine for development and testing purposes.
The application has 3 parts:
**1. Clone the application :
```bash
git clone https://github.com/PrachiP23/pubsub-angular-springboot-mongodb.git
```

**2. Build and run the backend app using maven
```bash
cd SpringMongoDb
mvn package
java -jar target\spring-boot-rest-mongodb-0.0.1-SNAPSHOT.jar
```

The backend server will start at <http://localhost:8080>.

**3. Run the frontend Angular app using npm
```bash
cd AngularApp
npm install
npm start
```
Frontend server will run on <http://localhost:4200>
