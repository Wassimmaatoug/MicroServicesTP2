package service;

import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;
import metier.Compte;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@WebService
public class BanqueService {

    @WebMethod
    public double conversion(@WebParam(name = "montant") double montant) {
        return montant * 1.1;
    }

    @WebMethod
    public Compte getCompte(@WebParam(name = "code") String code) {

        if ("CC1".equals(code)) {
            return new Compte(1, "CC1", 1500.0, new Date());
        }
        return null;
    }

    @WebMethod
    public List<Compte> getComptes() {
        List<Compte> comptes = new ArrayList<>();
        comptes.add(new Compte(1, "CC1", 1500.0, new Date()));
        comptes.add(new Compte(2, "CC2", 2500.0, new Date()));
        return comptes;
    }
}