FROM jboss/wildfly
RUN /opt/jboss/wildfly/bin/add-user.sh admin Admin#70365 --silent
CMD ["/opt/jboss/wildfly/bin/standalone.sh", "-b", "0.0.0.0", "-bmanagement", "0.0.0.0"]
#ADD https://github.com/igolus/easyApp-demo/blob/master/easyApp-demo-1.0-SNAPSHOT.war /opt/jboss/wildfly/standalone/deployments/
ADD easyApp-demo-1.0-SNAPSHOT.war /opt/jboss/wildfly/standalone/deployments/
USER root
RUN chown jboss:jboss /opt/jboss/wildfly/standalone/deployments/*