#!/bin/bash

# Run Maven clean and install
mvn clean install

# Check if Maven build was successful
if [ $? -eq 0 ]; then
    # Run the Java application if Maven build was successful
    java -jar target//quickstart-0.0.1-SNAPSHOT.jar
else
    echo "Maven build failed. Exiting."
    exit 1
fi