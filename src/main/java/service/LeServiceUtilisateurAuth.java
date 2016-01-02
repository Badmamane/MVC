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
public class LeServiceUtilisateurAuth {

         public EvenementDAO evenementDAO = new EvenementDAOImplement();
         public UtilisateurDAO utilisateurDAO = new UtilisateurDAOImplement();

           public void SinscrireEvenementService(Utilisateur u, Evenement e)
           {
               try
               {

               } catch(Exception exp){
                   exp.printStackTrace();
               }
           }
}
