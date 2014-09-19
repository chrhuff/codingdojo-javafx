#!/bin/bash
docker run -d -p 3306:3306 --name=mariadb dockerfile/mariadb
docker run -d -p 8080:8080 --name=tomcat --link mariadb:mariadb komu/tomcat8-java8