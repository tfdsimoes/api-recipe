# api-recipe

This is an API to manage recipes.

The project is done using JAVA 11 with SpringBoot Framework.

The date generated is saved in MongoDB

**NOTE** The instructions in this project are for Linux system and in the root of the project

## Requirements
To run these project is required: 
- docker 20.10.12
- docker-compose 1.28.5

To build the project is required:
- java11

## How to build
To build the project is not need to install maven since there is included maven wrapper.

To start the build just run:
```
$ ./mvnw clean verify
```

Maven will generate classes, run testes and build a docker image to be used. 
## How to run
To start the project just need to run:
```
$ docker-compose up -d --build
```

To stop the project
```
$ docker-compose stop
```

## To use it
Documentation about endpoints can be found in yml at the folder api-documentation, the documentation is done in swagger.

Also, to help can be found a [Postman](https://www.getpostman.com/) collection in the root of the project to help to use the project.

## Deploy\Run proposal
[Proposal](./run_proposal.md)
