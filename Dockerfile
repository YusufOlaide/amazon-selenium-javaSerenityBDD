FROM ubuntu:14.04

ARG MAVEN_VERSION=3.6.3

COPY pom.xml /app/

COPY src app/src/

WORKDIR /app/

ENTRYPOINT ["/bin/sh"]

CMD ["ClipboardHealth.sh"]