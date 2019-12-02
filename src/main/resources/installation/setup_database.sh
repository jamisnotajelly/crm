#!/usr/bin/env bash

me=`basename "$0"`
username=
password=
database_name=

#Run ddl scripts
#for file in db/ddl/*
#do
#    sudo -u username psql -d database -a -f file
#done


function database_preparation() {
    create_postgres_user
    create_linux_user
    create_database
}

function create_postgres_user() {
    sudo -u postgres createuser ${username}

    sudo -u postgres psql<< END_OF_SCRIPT
    alter user ${username} with encrypted password '${password}';
END_OF_SCRIPT
}

function create_linux_user() {
    sudo useradd ${username}

    sudo passwd ${username}<<END_OF_SCRIPT
    ${password}
    ${password}
END_OF_SCRIPT
}

function create_database() {
    sudo -u postgres createdb ${database_name}

    echo "Database was created"

    sudo -u postgres psql<< END_OF_SCRIPT
    grant all privileges on database ${database_name} to ${username};
END_OF_SCRIPT

    echo "Privileges were granted"
}



while [[ "$1" != "" ]]; do
    case $1 in
        -u | --username )       shift
                                username=$1
                                ;;
        -p | --password )       shift
                                password=$1
                                ;;
        -d | --database )       shift
                                database_name=$1
                                ;;
        * )
    esac
    shift
done

if [[ -z "$username" ]]; then
    echo "${me}: Username is not set";
    exit 1;
fi

if [[ -z "$password" ]]; then
    echo "${me}: Password is not set";
    exit 1;
fi

if [[ -z "$database_name" ]]; then
    echo "${me}: Database name is not set";
    exit 1;
fi

database_preparation
