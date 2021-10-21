FROM openjdk:11
VOLUME /main-app
ADD target/data-store-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8081
ENTRYPOINT ["java", "-jar", "/app.jar"]