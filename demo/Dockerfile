FROM ibmjava:8-sfj-alpine

LABEL maintainer="daniel"

EXPOSE 8080

ADD target/demo.jar demo.jar

ENV JVM_OPTS="-XX:+UnlockExperimentalVMOptions -XX:+UseCGroupMemoryLimitForHeap -XX:MaxRAMFraction=1"

ENTRYPOINT ["sh", "-c", "java $JVM_OPTS -jar demo.jar"]
CMD ["-Xmx100Md"]