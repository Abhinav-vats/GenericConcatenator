FROM openjdk:8
ADD target/generic-message.jar generic-message.jar

EXPOSE 8080

ENTRYPOINT ["java","-jar", "generic-message.jar"]