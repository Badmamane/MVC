package service;

import model.Utilisateur;

/**
 * Created by Badam on 01/01/2016.
 */
public interface LeService {
    public Utilisateur findUtilisteurById(int id) throws Exception;

    // public Virement effectuerVirement(Compte cptSource, Compte cptDest, float montant)
     //       throws BankonetException;
}