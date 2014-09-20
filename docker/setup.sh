#!/bin/sh
docker build -t="codingdojo/tomee7:latest" tomee7/
docker build -t="codingdojo/mariadb:latest" mariadb/
docker run -d -p 3306:3306 --name=mariadb codingdojo/mariadb
docker run -d -p 8080:8080 --name=tomee --link mariadb:mariadb codingdojo/tomee7