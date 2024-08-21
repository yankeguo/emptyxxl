FROM alpine:3.20 AS builder

WORKDIR /opt/emptyxxl

RUN apk add --no-cache curl && \
    curl -sSL -o 'jre.tar.gz' 'https://github.com/adoptium/temurin8-binaries/releases/download/jdk8u422-b05/OpenJDK8U-jre_x64_linux_hotspot_8u422b05.tar.gz' && \
    mkdir -p jre && \
    tar -xf jre.tar.gz -C jre --strip-components 1 && \
    rm -rf jre.tar.gz

ADD target/emptyxxl.jar emptyxxl.jar

ADD emptyxxl.sh emptyxxl.sh

CMD ["cp", "-rf", "/opt/emptyxxl", "/target/"]