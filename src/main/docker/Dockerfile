FROM asimio/jre8

VOLUME /tmp

ENV USER_NAME discoverysvc
ENV APP_HOME /opt/asimio-cloud/$USER_NAME
RUN \
  useradd -ms /bin/bash $USER_NAME && \
  mkdir -p $APP_HOME

ADD discovery-server.jar ${APP_HOME}/discovery-server.jar
RUN \
  chown $USER_NAME $APP_HOME/discovery-server.jar && \
  bash -c 'touch ${APP_HOME}/discovery-server.jar'

ENV JAVA_TOOL_OPTIONS "-Xms256M -Xmx256M -Djava.awt.headless=true -Djava.security.egd=file:/dev/./urandom"

USER $USER_NAME
WORKDIR $APP_HOME
ENTRYPOINT ["java", "-jar", "discovery-server.jar"]

# No need to EXPOSE port since it's using host's networking

# Run as:
# docker run -idt -p 8001:8001 --net=host -e spring.profiles.active=peerAware -e appPort=8001 -e hostName=$HOSTNAME -e dataCenter=asimio-cloud-dal -e environment=staging -e peerUrls="http://$HOSTNAME:8002/eureka/" asimio/discovery-server:latest
