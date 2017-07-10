# HelloWorld

## Requirements

- Java 1.6
- Maven

## Build

    $ mvn package

## Run

    $ java -jar target/dropwizard-example-0.0.1-SNAPSHOT.jar server hello-world.yml 

## Run Program Argument

    $ server hello-world.yml 

## Test

`http://localhost:9000/hello-world?name=ahmet`

``http://localhost:9000/hello-world/10times?name=ahmet``

