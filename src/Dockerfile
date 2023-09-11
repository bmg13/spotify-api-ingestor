FROM openjdk:8
USER root

COPY /target/spotify-api-ingestor-1.0-SNAPSHOT.jar spotify-api-ingestor-1.0-SNAPSHOT.jar

ENTRYPOINT ["java", "-jar", "/ spotify-api-ingestor-1.0-SNAPSHOT.jar"]