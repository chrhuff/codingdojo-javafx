FROM damm/java8

MAINTAINER christian.huff@cofinpro.de

EXPOSE 8080

ENV TOMCAT_VERSION 8.0.12
ENV TOMEE_VERSION 1.7.1
RUN wget --quiet --no-cookies http://www.gtlib.gatech.edu/pub/apache/tomee/tomee-${TOMEE_VERSION}/apache-tomee-${TOMEE_VERSION}-plus.tar.gz -O /tmp/catalina.tar.gz
#RUN wget --quiet --no-cookies http://archive.apache.org/dist/tomcat/tomcat-8/v${TOMCAT_VERSION}/bin/apache-tomcat-${TOMCAT_VERSION}.tar.gz -O /tmp/catalina.tar.gz

# Unpack
RUN tar xzf /tmp/catalina.tar.gz -C /opt
RUN mv /opt/apache-tomee-${TOMEE_VERSION} /opt/tomcat
RUN rm /tmp/catalina.tar.gz

# Remove unneeded apps
RUN rm -rf /opt/tomcat/webapps/examples
RUN rm -rf /opt/tomcat/webapps/docs
RUN rm -rf /opt/tomcat/webapps/ROOT

ADD tomcat-users.xml /opt/tomcat/conf/
ADD context.xml /opt/tomcat/conf/

ENV CATALINA_HOME /opt/tomcat
ENV PATH $PATH:$CATALINA_HOME/bin

# Start Tomcat
CMD ["/opt/tomcat/bin/catalina.sh", "run"]