FROM openliberty/daily:full

COPY src/main/liberty/config/server.xml /config/

COPY target/mp-cp-example.war /config/dropins/
