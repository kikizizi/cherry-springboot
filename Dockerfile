FROM openjdk:8-jre-alpine

ENV LANG=C.UTF-8

COPY ./cherry/build/libs/cherry-*-SNAPSHOT.war /opt/app.war

WORKDIR /opt

ENTRYPOINT ["/bin/sh","-c","java -jar app.war"]

