#!/bin/bash
parent_path=$( cd "$(dirname "${BASH_SOURCE[0]}")" ; pwd -P )
cd "/home/mohamed/.m2/repository/allure/allure-2.16.1/bin/"
bash allure serve "$parent_path/allure-results"
exit