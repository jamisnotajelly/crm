#!/usr/bin/env bash

DATABASE_NAME=
USERNAME=
PASSWORD=

PROPERTY_FILE=db.properties

sudo ln -s bash /bin/sh.bash
sudo mv /bin/sh.bash /bin/sh

#Remove the menu.lst config.
#See https://serverfault.com/questions/645566/a-new-version-of-boot-grub-menu-lst-is-available-when-upgrading-ubuntu-on-an

sudo rm /boot/grub/menu.lst
# Generate a new configuration file.
sudo update-grub-legacy-ec2 -y

#Upgrade the configuration
sudo apt-get dist-upgrade -qq --force-yes

function getProperty() {
    PROP_KEY=$1
    PROP_VALUE=`cat ${PROPERTY_FILE} | grep "$PROP_KEY" | cut -d'=' -f2`
    echo ${PROP_VALUE}
}

echo "# Reading property from $PROPERTY_FILE"

DATABASE_NAME=$(getProperty "database")
USERNAME=$(getProperty "username")
PASSWORD=$(getProperty "password")

sh install_postgres.sh

sh install_tomee.sh

sh setup_database.sh -u "$USERNAME" -p "$PASSWORD" -d "$DATABASE_NAME"

sh populate_database.sh -u "$USERNAME" -d "$DATABASE_NAME"


#restore dash as bin/sh

sudo ln -s dash /bin/sh.dash
sudo mv /bin/sh.dash /bin/sh

