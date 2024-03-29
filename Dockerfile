FROM openjdk:8u212-jre-alpine3.9
RUN apk add curl jq
WORKDIR /usr/share/udemy
ADD target/selenium-docker.jar selenium-docker.jar
ADD target/selenium-docker-tests.jar selenium-docker-tests.jar
ADD target/libs libs
ADD testng.xml testng.xml
ADD searchng.xml searchng.xml
ADD healthcheck.sh healthcheck.sh
ENTRYPOINT sh healthcheck.sh