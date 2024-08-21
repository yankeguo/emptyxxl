DIR_BASE="$(dirname "$0")"

JAVA="${DIR_BASE}/jre/bin/java"

JAVA_OPTS="${EMPTYXXL_JAVA_OPTS} -server -Djava.security.egd=file:/dev/./urandom"

exec $JAVA $JAVA_OPTS -jar "${DIR_BASE}/emptyxxl.jar" "$@"
