FROM registry.cn-beijing.aliyuncs.com/cpx/alpine-java:jdk8

ADD bin/iotpack.jar iotpack.jar
ENV JAVA_HOME=/usr/lib/jvm/default-jvm
ENV PATH=$JAVA_HOME/bin:$PATH
ENV CLASSPATH=.:$JAVA_HOME/lib/dt.jar:$JAVA_HOME/lib/tools.jar
EXPOSE 8080
ENTRYPOINT java  ${JAVA_OPTS}  -jar /iotpack.jar
