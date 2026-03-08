FROM tomcat:11-jdk17
RUN rm -rf /usr/local/tomcat/webapps/ROOT
COPY target/ShoppingCart.war /usr/local/tomcat/webapps/ROOT.war
EXPOSE 8080
CMD ["catalina.sh", "run"]