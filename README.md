# README #

Accompanying source code for blog entry at FIXME

### Requirements ###

* Java 8
* Maven 3.3.x
* Docker host or Docker machine

### Building and executing application from command line ###

```
mvn clean package
java -jar target/discovery-server.jar
or
java -Dspring.profiles.active=standalone -jar target/discovery-server.jar
or
java -Dspring.profiles.active=standalone -DappPort=8001 -jar target/discovery-server.jar
or multiple instances:
java -Dspring.profiles.active=peerAware -DhostName=localhost -DappPort=8001 -DdataCenter=local-dev -Denvironment=dev -DpeerUrls=http://localhost:8001/eureka/,http://localhost:8002/eureka/ -jar target/discovery-server.jar
java -Dspring.profiles.active=peerAware -DhostName=localhost -DappPort=8002 -DdataCenter=local-dev -Denvironment=dev -DpeerUrls=http://localhost:8001/eureka/,http://localhost:8002/eureka/ -jar target/discovery-server.jar
```

Open http://localhost:8001 or http://localhost:8002 in a browser

### How do I get set up using Docker? ###

```
sudo docker pull asimio/discovery-server.jar

Multiple containers:
sudo docker run -idt -p 8001:8001 -e appPort=8001 -e spring.profiles.active=peerAware -e hostName=localhost -e dataCenter=local-dev -e environment=dev -e peerUrls=http://localhost:8001/eureka/,http://localhost:8002/eureka/ asimio/discovery-server.jar:latest
sudo docker run -idt -p 8002:8002 -e appPort=8002 -e spring.profiles.active=peerAware -e hostName=localhost -e dataCenter=local-dev -e environment=dev -e peerUrls=http://localhost:8001/eureka/,http://localhost:8002/eureka/ asimio/discovery-server.jar:latest
```

Open http://localhost:8001 or http://localhost:8002 in a browser

### Who do I talk to? ###

* ootero at asimio dot net
* https://www.linkedin.com/in/ootero