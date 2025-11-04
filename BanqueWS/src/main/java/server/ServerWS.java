package server;

import service.BanqueService;
import jakarta.xml.ws.Endpoint;

public class ServerWS {
    public static void main(String[] args) {
        String url = "http://localhost:8080/BanqueService";
        Endpoint.publish(url, new BanqueService());
        System.out.println("Service web : " + url + "?wsdl");
    }
}