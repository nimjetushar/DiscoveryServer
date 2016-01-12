FROM ubuntu:14.04
VOLUME /tmp
ADD jre8.tar.gz /opt/
ADD discovery-server.jar /opt/asimio-cloud/discovery-server.jar
RUN bash -c 'touch /opt/asimio-cloud/discovery-server.jar'
ENV JVM_OPTIONS = "-Xms256M -Xmx256M -server -Djava.awt.headless=true -Djava.security.egd=file:/dev/./urandom"
ENTRYPOINT ["/opt/jre/bin/java", "-jar", "/opt/asimio-cloud/discovery-server.jar"]
EXPOSE 8000
