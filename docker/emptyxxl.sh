cd "$(dirname "$0")"

if [ -d "jre" ]; then
    JAVA="./jre/bin/java"
else
    JAVA="java"
fi

JAVA_OPTS="${EMPTYXXL_JAVA_OPTS} -server -Djava.security.egd=file:/dev/./urandom"

exec $JAVA $JAVA_OPTS -jar emptyxxl.jar "$@"
