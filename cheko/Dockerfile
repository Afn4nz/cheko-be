FROM openjdk:17-alpine
ENV TZ Asia/Riyadh
COPY target/cheko-0.0.1-SNAPSHOT.jar /opt/cheko-0.0.1-SNAPSHOT.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/opt/cheko-0.0.1-SNAPSHOT.jar"]