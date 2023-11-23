# Use the official Tomcat image as the base image
FROM tomcat:9-jre11

# Copy the WAR file to the container
COPY target/datta.war /usr/local/tomcat/webapps/

# Expose the port that your application will listen on
EXPOSE 8080

# The Tomcat image's entry point already starts Tomcat, so no need to specify CMD

