#!/usr/bin/env bash

cd /opt/tomee
DOWNLOAD_PATH="http://apache.cp.if.ua/tomee/tomee-8.0.0-M3/apache-tomee-8.0.0-M3-microprofile.tar.gz"
FILE_NAME="tomee.tar.gz"
echo "Starting to download Tomee from $DOWNLOAD_PATH"

wget --quiet -O ${FILE_NAME} ${DOWNLOAD_PATH}

tar -zxvf ${FILE_NAME}