# Measy API

Measy API is a music-related API for a CE College Project. It features the following entities:
 - Account (aka User)
 - Playlist
 - Artist
 - Track
 - Album

## Prerequisites
 - [Java JDK 11](https://jdk.java.net/java-se-ri/11)
 - [Docker](https://docs.docker.com/get-docker/) & [Docker-Compose](https://docs.docker.com/compose/install/)

## Architecture

This is simply a Spring Boot app that reads and writes data from/to a PostgreSQL Database running in a Docker container

### Routes

We just show examples with the Track entity below, but all entities have equivalent routes. 
Also, we enforce the following standards:

 - All date/datetime fields must follow the [ISO 8601](https://en.wikipedia.org/wiki/ISO_8601) international standard.
 - All table ids are expressed in the [UUID](https://en.wikipedia.org/wiki/Universally_unique_identifier) format.
 - The delete operation only soft-deletes the records in the database

Examples:

Get by Id:
```
GET http://localhost:8080/v1/track/{id}
```

Search by fields:
```
GET http://localhost:8080/v1/tracks?release_date=...&name=...
```

Search by query:
```
GET http://localhost:8080/v1/tracks/search?q={query}
```

Create:
```
POST http://localhost:8080/v1/track

Body:
{
    "id": ...,
    "name": ...,
    "artistId": ...,
    "albumId": ...,
    "releaseDate": ...,
    "popularity": ...
}
```

Update:
```
PUT http://localhost:8080/v1/track

Body:
{
    "id": ...,
    "name": ...,
    "artistId": ...,
    "albumId": ...,
    "releaseDate": ...,
    "popularity": ...
}
```

Delete:
```
DELETE http://localhost:8080/v1/track/{id}
```

## How to run:

First, make sure you have set up all the prerequisites stated at the start of the docs. Then:

Just run:
```bash
make run
```

Or, if you are ~~unfortunate enough to be running a Windows OS~~ having problems building with Make, run these instead:
```
docker-compose up --detach
./gradlew bootRun
```

💜, Measy Team.