FROM ubuntu:14.04
VOLUME /tmp
ADD jre8.tar.gz /opt/
ADD discovery-server.jar /opt/asimio-cloud/discovery-server.jar
RUN bash -c 'touch /opt/asimio-cloud/discovery-server.jar'
ENV JAVA_HOME /opt/jre
ENV PATH $JAVA_HOME/bin:$PATH
ENV JVM_OPTIONS = "-Xms256M -Xmx256M -server -Djava.awt.headless=true -Djava.security.egd=file:/dev/./urandom -Dspring.profiles.active=peerAware -DpeerUrls=$
ENTRYPOINT ["java", "-jar", "/opt/asimio-cloud/discovery-server.jar"]
EXPOSE 8000

# Run as:
# docker run -it -p 8001:8000 -e spring.profiles.active=peerAware -e peerUrls=http://localhost:8001/eureka/,http://localhost:8002/eureka/ asimio-cloud/discovery-server:latest