#!/usr/bin/env bash

sudo -u postgres createuser username
sudo useradd username
sudo passwd username<<END_OF_SCRIPT
password
password
END_OF_SCRIPT

sudo -u postgres createdb database

sudo -u postgres psql<< END_OF_SCRIPT
alter user username with encrypted password 'password';
grant all privileges on database database to username;
create schema orders;
END_OF_SCRIPT

sudo su - username

#TODO RUN SCRIPTS TO CREATE TABLES FROM HERE
psql -d database -a -f script.sql