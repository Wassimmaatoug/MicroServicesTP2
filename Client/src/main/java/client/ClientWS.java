package client;

import client.BanqueService;
import client.BanqueServiceService;
import client.Compte;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class ClientWS {
    public static void main(String[] args) throws MalformedURLException {
        URL wsdlURL = new URL("http://localhost:8080/BanqueService?wsdl");
        BanqueServiceService service = new BanqueServiceService(wsdlURL);
        BanqueService port = service.getBanqueServicePort();


        double resultat = port.conversion(100.0);
        System.out.println("Conversion de 100 : " + resultat);

        Compte compte = port.getCompte("CC1");
        if (compte != null) {
            System.out.println("Compte CC1 - Solde: " + compte.getSolde());
        }


        List<Compte> comptes = port.getComptes();
        System.out.println("Nombre de comptes: " + comptes.size());
        for (Compte c : comptes) {
            System.out.println("Code: " + c.getCode() + ", Solde: " + c.getSolde());
        }
    }
}