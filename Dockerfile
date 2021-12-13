# Use latest jboss/base-jdk:11 image as the base
FROM jboss/base-jdk:11

# Set the WILDFLY_VERSION env variable
ENV WILDFLY_VERSION 24.0.1.Final
ENV WILDFLY_SHA1 1418b1d3f7794adb61d24240b016819ab2978795
ENV JBOSS_HOME /opt/jboss/wildfly

USER root

# Add the WildFly distribution to /opt, and make wildfly the owner of the extracted tar content
# Make sure the distribution is available from a well-known place
RUN cd $HOME \
    && curl -L -O https://download.jboss.org/wildfly/$WILDFLY_VERSION/wildfly-preview-$WILDFLY_VERSION.tar.gz \
    && sha1sum wildfly-preview-$WILDFLY_VERSION.tar.gz | grep $WILDFLY_SHA1 \
    && tar xf wildfly-preview-$WILDFLY_VERSION.tar.gz \
    && mv $HOME/wildfly-preview-$WILDFLY_VERSION $JBOSS_HOME \
    && rm wildfly-preview-$WILDFLY_VERSION.tar.gz \
    && chown -R jboss:0 ${JBOSS_HOME} \
    && chmod -R g+rw ${JBOSS_HOME}

# TODO: melhorar
RUN ${JBOSS_HOME}/bin/add-user.sh wildfly-manager 1234 --silent

# Ensure signals are forwarded to the JVM process correctly for graceful shutdown
ENV LAUNCH_JBOSS_IN_BACKGROUND true

USER jboss

# Expose the ports in which we're interested
EXPOSE 8080

# Set the default command to run on boot
# This will boot WildFly in standalone mode and bind to all interfaces
# CMD ["/opt/jboss/wildfly/bin/standalone.sh", "-b", "0.0.0.0"]
CMD [ "/opt/jboss/wildfly/bin/standalone.sh", "-b", "0.0.0.0", "-bmanagement", "0.0.0.0", "--server-config=standalone-full.xml" ]
