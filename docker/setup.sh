#!/bin/sh
cd tomee7
    docker build -t="codingdojo/tomee7:latest" .
cd -
cd mariadb
    docker build -t="codingdojo/mariadb:latest" .
cd -
docker run -d -p 3306:3306 --name=mariadb codingdojo/mariadb
docker run -d -p 8080:8080 --name=tomee --link mariadb:mariadb codingdojo/tomee7