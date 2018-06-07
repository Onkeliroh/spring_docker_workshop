FROM ibmjava:8-jre-alpine

EXPOSE 8123

ADD target/spring-boot-admin.jar spring-boot-admin.jar

ENTRYPOINT ["java", "-jar", "spring-boot-admin.jar"]