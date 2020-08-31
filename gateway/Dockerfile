FROM openjdk:11

WORKDIR /opt/starter

COPY /target/gateway*.jar gateway.jar

SHELL ["/bin/sh", "-c"]

EXPOSE 8080

CMD java -jar starter.jar