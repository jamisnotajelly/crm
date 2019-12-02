#!/usr/bin/env bash

me=`basename "$0"`
username=
database_name=
path_to_folder=./database/ddl
constraints=constraints
tables=tables

function populate_database() {
    for file in ${path_to_folder}/${tables}/*
    do
        sudo -u ${username} psql -d ${database_name} -a -f ${file}
    done

    for file in ${path_to_folder}/${constraints}/*
    do
        sudo -u ${username} psql -d ${database_name} -a -f ${file}
    done
}

while [[ "$1" != "" ]]; do
    case $1 in
        -u | --username) shift
        username=$1
        ;;
        -p | --path) shift
        path_to_folder=$1
        ;;
        -d | --database) shift
        database_name=$1
        ;;
        *)
    esac
    shift
done

if [[ -z "$username" ]]; then
    echo "${me}: Username is not set";
    exit 1;
fi
if [[ -z "$database_name" ]]; then
    echo "${me}: Database name is not set";
    exit 1;
fi
if [[ -z "$path_to_folder" ]]; then
    echo "${me}: Using default path to folder";
fi



populate_database
