#!/bin/sh
docker run -it --link=mariadb:mariadb codingdojo/mariadb /bin/bash -c 'mysql -h mariadb -u root --database=codingdojo'