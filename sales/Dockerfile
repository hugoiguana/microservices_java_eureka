FROM openjdk:11

ARG PROFILE
ARG ADDITIONAL_OPTS

ENV PROFILE=${PROFILE}
ENV ADDITIONAL_OPTS=${ADDITIONAL_OPTS}

WORKDIR /opt/sales

COPY /sales/target/sales*.jar sales.jar

SHELL ["/bin/sh", "-c"]

EXPOSE 8082
EXPOSE 5005

CMD java ${ADDITIONAL_OPTS} -jar sales.jar --spring.profiles.active=${PROFILE}