package service;

import DAO.DAOImplementations.EvenementDAOImplement;
import DAO.DAOImplementations.UtilisateurDAOImplement;
import DAO.DAOjdbc.EvenementDAO;
import DAO.DAOjdbc.UtilisateurDAO;
import model.Evenement;
import model.Utilisateur;

/**
 * Created by Badam on 02/01/2016.
 */
public class LeServiceOrateurAdmin {

    EvenementDAO evenementDAOimplement = new EvenementDAOImplement();
    UtilisateurDAO utilisateurDAO = new UtilisateurDAOImplement();

    boolean supprimerEvenementService (Evenement e) {
        long code = e.getCodeevent();
        boolean b;
        try {
             b = evenementDAOimplement.SupprimerEvenement(code);
             return true;
        } catch (Exception exp) {
            exp.printStackTrace();
        }
        return false;
    }

    Evenement modifierEvenementService (Evenement e)
    {
       boolean b;
        try{
            b = evenementDAOimplement.updateEvenement(e);
            return e;
           } catch (Exception exp){
            exp.printStackTrace();}

            return e;
    }

}
