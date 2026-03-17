FROM tomcat:9.0-jdk11-openjdk
WORKDIR /usr/local/tomcat
EXPOSE 8080
# COPY test.jsp webapps/ROOT/hello.jsp
COPY index.html webapps/ROOT/index.html
CMD ["catalina.sh","run"]