package service;

import DAO.DAOImplementations.EvenementDAOImplement;
import DAO.DAOImplementations.InscriptionDAOImplement;
import DAO.DAOImplementations.UtilisateurDAOImplement;
import DAO.DAOjdbc.EvenementDAO;
import DAO.DAOjdbc.InscriptionDAO;
import DAO.DAOjdbc.UtilisateurDAO;
import model.Evenement;
import model.Inscription;
import model.Utilisateur;

/**
 * Created by Badam on 02/01/2016.
 */
public class LeServiceUtilisateurAuth {

         public EvenementDAO evenementDAO = new EvenementDAOImplement();
         public UtilisateurDAO utilisateurDAO = new UtilisateurDAOImplement();
         public InscriptionDAO inscriptionDAO = new InscriptionDAOImplement();

           public Inscription SinscrireEvenementService(Utilisateur utilisateur, Evenement evenement)
           {
               Inscription inscription;
               try
               {
              inscription =  inscriptionDAO.sinscrire(evenement, utilisateur);

               } catch(Exception exp){
                   exp.printStackTrace();
               }
               return inscription;
           }


}
