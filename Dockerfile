FROM java:8
VOLUME /tmp
EXPOSE 9090
ADD target/doc-springboot-app.jar doc-springboot-app.jar
ENTRYPOINT ["java","-jar","doc-springboot-app.jar"]