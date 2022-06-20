FROM ubuntu:18.04


ENV DEBIAN_FRONTEND=noninteractive \ 
    LANG=C.UTF-8

RUN apt-get update && apt-get install -y \
    openjdk-8-jdk \
    wget \
    git \
    vim \
    tzdata 

RUN apt-get update && apt-get install -y \
    tomcat8 \
    maven 

COPY ./cherry /opt/cherry
COPY ./dev_files/context.xml /var/lib/tomcat8/conf/context.xml
COPY ./dev_files/server.xml /var/lib/tomcat8/conf/server.xml

WORKDIR /opt/cherry

RUN mvn package

RUN mv ./target/*.war /var/lib/tomcat8/webapps
