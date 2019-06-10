#!/usr/bin/env bash

sudo apt update && sudo apt -y upgrade

sudo apt install -y wget vim

#Before adding repository content to your Ubuntu 18.04 / Ubuntu 16.04 system, you need to import the repository signing key:

wget --quiet -O - https://www.postgresql.org/media/keys/ACCC4CF8.asc | sudo apt-key add -

#After importing GPG key, add repository contents to your Ubuntu 18.04/16.04 system:

RELEASE=$(lsb_release -cs)
echo "deb http://apt.postgresql.org/pub/repos/apt/ ${RELEASE}"-pgdg main | sudo tee  /etc/apt/sources.list.d/pgdg.list

#Verify repository file contents

cat /etc/apt/sources.list.d/pgdg.list
deb http://apt.postgresql.org/pub/repos/apt/ bionic-pgdg main

sudo apt update

sudo apt -y install postgresql-11

sudo -u postgres createuser username
sudo -u postgres createdb database

sudo -u postgres psql<< END_OF_SCRIPT
alter user username with encrypted password 'password';
grant all privileges on database database to username;
END_OF_SCRIPT



