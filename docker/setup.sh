#!/bin/bash
docker run -d -p 3306:3306 --name=mariadb codingdojo/mariadb
docker run -d -p 8080:8080 --name=tomcat --link mariadb:mariadb codingdojo/tomee7