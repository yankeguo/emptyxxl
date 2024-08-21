#!/bin/bash

cd "$(dirname "$0")"

JAVA_OPTS="${EMPTYXXL_JAVA_OPTS} -server -Djava.security.egd=file:/dev/./urandom ${JAVA_OPTS}"

exec java $JAVA_OPTS -jar emptyxxl.jar "$@"
