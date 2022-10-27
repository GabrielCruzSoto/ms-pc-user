FROM adoptopenjdk/openjdk11:alpine-jre
WORKDIR /opt/app
ARG JAR_FILE=spring-boot-web.jar
COPY build/libs/${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","app.jar"]