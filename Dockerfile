FROM openjdk:11
VOLUME /tmp
EXPOSE 8080
ADD ./target/CustomerService-0.0.1-SNAPSHOT.jar ms-customer.jar
ENTRYPOINT ["java","-jar","/ms-customer.jar"]