#!/usr/bin/env bash

sudo apt-get install software-properties-common
sudo apt-add-repository -y ppa:ansible/ansible
sudo apt-get update
sudo apt-get install -y ansible

mkdir -p ~/Ansible/ansible
touch ~/Ansible/ansible/hosts
touch ~/.ansible.cfg

