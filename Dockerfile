FROM bitnami/java

EXPOSE 5001

ENV APP_HOME /usr/src/app

COPY target/spring-boot-website-0.0.1-SNAPSHOT.jar $APP_HOME/app.jar

WORKDIR $APP_HOME

ENTRYPOINT exec java -jar app.jar
