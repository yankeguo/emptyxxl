#!/bin/sh

DIR_BASE="$(dirname "$0")"

JAVA="${BASE_DIR}/jre/bin/java"

JAVA_OPTS="${EMPTYXXL_JAVA_OPTS} -server -Djava.security.egd=file:/dev/./urandom"

exec $JAVA $JAVA_OPTS -jar "${DIR_BASE}/emptyxxl.jar" "$@"
