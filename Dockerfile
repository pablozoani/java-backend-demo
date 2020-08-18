FROM centos
RUN yum install -y java
VOLUME /tmp
ADD target/java-backend-demo-1.0-SNAPSHOT.jar java-backend-demo.jar
RUN sh -c 'touch /myapp.jar'
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/java-backend-demo.jar"]