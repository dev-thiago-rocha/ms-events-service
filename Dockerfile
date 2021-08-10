FROM openjdk:11-slim
LABEL maintainer 'THRTEC'
WORKDIR /opt
RUN apt-get update && apt-get install -y tzdata curl
COPY ./target/*.jar /opt/app.jar
ARG APP_PORT=8181
CMD java -jar app.jar
EXPOSE $APP_PORT