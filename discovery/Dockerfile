FROM openjdk:11

WORKDIR /opt/discovery

#COPY /target/discovery.jar discovery.jar
COPY /discovery/target/discovery.jar discovery.jar
#COPY . .

SHELL ["/bin/sh", "-c"]

EXPOSE 8081

CMD java -jar discovery.jar