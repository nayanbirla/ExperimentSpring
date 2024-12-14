FROM openjdk:17-oracle
EXPOSE 8081
ADD target/experimentspring.jar experimentspring.jar
ENTRYPOINT ["java","-jar","/experimentspring.jar"]