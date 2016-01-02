package service;

import DAO.DAOImplementations.EvenementDAOImplement;
import DAO.DAOImplementations.UtilisateurDAOImplement;
import DAO.DAOjdbc.EvenementDAO;
import DAO.DAOjdbc.UtilisateurDAO;
import model.Utilisateur;

/**
 * Created by Badam on 02/01/2016.
 */
public class LeServiceOrateurAdmin {

    EvenementDAO evenementDAOimplement = new EvenementDAOImplement();
    UtilisateurDAO utilisateurDAO = new UtilisateurDAOImplement();
    Utilisateur adminOuModerateur = new Utilisateur();

    Utilisateur creer (Utilisateur u)
    {
        if()
    }


}
