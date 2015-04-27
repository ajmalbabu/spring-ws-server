# spring-ws-server
When the service is build it would generate the WSDL artifacts from the XSD. 
There is a maven plugin used by service to do this step.

Once the service is built it can be started with the following java command
where server port is the web service port the service would listen on

java -Dserver.port=8090 -jar service-layer-0.1.0.jar

Make sure the service is running looking at 
http://localhost:8090/ws/countries.wsdl

This example is taken from https://spring.io/guides/gs/producing-web-service/

