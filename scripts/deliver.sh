#!/usr/bin/env bash

echo 'The following command extracts the value of the <name/> element'
echo 'within <project/> of your Java/Maven project''s "pom.xml" file.'
set -x
NAME=`mvn -q -DforceStdout help:evaluate -Dexpression=project.name`
set +x

echo 'The following command behaves similarly to the previous one but'
echo 'extracts the value of the <version/> element within <project/> instead.'
set -x
VERSION=`mvn -q -DforceStdout help:evaluate -Dexpression=project.version`
set +x

echo 'The following command runs and outputs the execution of your Java'
echo 'application (which Jenkins built using Maven) to the Jenkins UI.'
set -x
nohup java -jar target/${NAME}-${VERSION}.jar --server.address=0.0.0.0 > app.log 2>&1 &
disown