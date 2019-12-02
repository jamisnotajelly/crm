#!/usr/bin/env bash

DOWNLOAD_PATH="http://apache.cp.if.ua/tomee/tomee-8.0.0-M3/apache-tomee-8.0.0-M3-microprofile.tar.gz"
FILE_NAME="tomee.tar.gz"

function download_tomee() {
    cd /opt
    sudo mkdir tomee
    cd tomee

    echo "Starting to download Tomee from ${DOWNLOAD_PATH} to $(pwd)"

    sudo wget --quiet -O ${FILE_NAME} ${DOWNLOAD_PATH}

    echo "Starting to unpack Tomee"

    sudo tar -zxvf ${FILE_NAME}

    echo "Grant permissions for Tomee to ubuntu user"

    sudo chown -R ubuntu /opt/tomee
}

function install_jre() {
    yes | sudo apt install default-jre
}

download_tomee
install_jre
