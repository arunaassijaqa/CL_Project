from openjdk:17
EXPOSE 8080
ADD target/revaturedocker.jar /revaturedocker.jar
ENTRYPOINT ["java","-jar","/revaturedocker.jar"]