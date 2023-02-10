FROM openjdk:8u121-jre-alpine
# FROM java:openjdk-8u91-jdk
# FROM hengyunabc/arthas:latest
VOLUME /tmp

ARG JASYPT_ENCRYPTOR_PASSWORD=""

# RUN wget https://arthas.aliyun.com/arthas-boot.jar
## COPY --from=hengyunabc/arthas:latest /opt/arthas /opt/arthas

ADD target/**.jar app.jar
RUN sh -c 'touch /app.jar'
ENV JAVA_OPTS=""
EXPOSE  8080

RUN echo -e "#!/bin/sh\njava ${JAVA_OPTS} -Djava.awt.headless=true -Djava.security.egd=file:/dev/./urandom -DJASYPT_ENCRYPTOR_PASSWORD=${JASYPT_ENCRYPTOR_PASSWORD} -Dsun.net.httpserver.nodelay=true -jar ./app.jar" > ./entrypoint.sh
RUN chmod +x ./entrypoint.sh

ENTRYPOINT ["./entrypoint.sh"]
