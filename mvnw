#!/bin/sh

WRAPPER_JAR=".mvn/wrapper/maven-wrapper.jar"
WRAPPER_LAUNCHER="org.apache.maven.wrapper.MavenWrapperMain"

if [ ! -f "$WRAPPER_JAR" ]; then
  echo "Maven Wrapper JAR nao encontrado em $WRAPPER_JAR."
  echo "Instale o Maven e rode: mvn spring-boot:run"
  exit 1
fi

exec java -classpath "$WRAPPER_JAR" "$WRAPPER_LAUNCHER" "$@"
