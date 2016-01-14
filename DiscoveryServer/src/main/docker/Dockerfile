FROM ubuntu:14.04

RUN bash -c 'apt-get -qq update && apt-get -y upgrade && apt-get -y autoclean && apt-get -y autoremove'
RUN bash -c 'DEBIAN_FRONTEND=noninteractive apt-get install -y curl'

VOLUME /tmp

ADD jre8.tar.gz /opt/
ADD discovery-server.jar /opt/asimio-cloud/discovery-server.jar
RUN bash -c 'touch /opt/asimio-cloud/discovery-server.jar'

ENV JAVA_HOME /opt/jre
ENV PATH $JAVA_HOME/bin:$PATH
ENV JAVA_TOOL_OPTIONS="-Xms256M -Xmx256M -Djava.awt.headless=true -Djava.security.egd=file:/dev/./urandom"

ENTRYPOINT ["java", "-jar", "/opt/asimio-cloud/discovery-server.jar"]

# No need to EXPOSE port since it's using host's networking

# Run as:
# docker run -idt -p 8001:8001 --net=host -e spring.profiles.active=peerAware -e appPort=8001 -e hostName=$HOSTNAME -e dataCenter=asimio-cloud-dal -e environment=staging -e peerUrls="http://docker:8002/eureka/" asimio-cloud/discovery-server:latest
