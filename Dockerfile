FROM amazoncorretto:11
MAINTAINER HHP
COPY target/hhpx-0.0.1-SNAPSHOT.jar wpf-app.jar
ENTRYPOINT ["java","-jar","/wpf-app.jar"]
