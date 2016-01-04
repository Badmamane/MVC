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

import javax.rmi.CORBA.Util;

/**
 * Created by Badam on 02/01/2016.
 */
public class LeServiceUtilisateurAuth {

         public EvenementDAO evenementDAO = new EvenementDAOImplement();
         public UtilisateurDAO utilisateurDAO = new UtilisateurDAOImplement();
         public InscriptionDAO inscriptionDAO = new InscriptionDAOImplement();

           public Inscription SinscrireEvenementService(Utilisateur utilisateur, Evenement evenement)
           {
               Inscription inscription = new Inscription();
               try
               {
              inscription =  inscriptionDAO.sinscrire(evenement, utilisateur);
              return inscription;
               } catch(Exception exp)
               {
                   exp.printStackTrace();
               }
               return inscription;
           }

           public Inscription laisserNoteService(Inscription inscription, Double note)
               {
              Inscription inscription1 = new Inscription();

               try{
                   inscription1 = inscriptionDAO.inscriptionNote(inscription, note);
                   return  inscription1;
               } catch (Exception exp)
               {
                   exp.printStackTrace();
               }
                   return inscription1;

           }

           public boolean creerEvenentService(Evenement evenement)
           {
               boolean b;

               try {
                  b = evenementDAO.CreerEvenement(evenement);
                   return b;
               } catch (Exception exp){
                   exp.printStackTrace();
               }
               return false;
           }

           public boolean seDesinscrireServce(Evenement evenement, Utilisateur utilisateur )
           {
              try {
                  Inscription inscription = inscriptionDAO.findInscriptionByCodeEvtIden(evenement, utilisateur);
                  inscriptionDAO.Desinscription(inscription);
                  if( inscriptionDAO.Desinscription(inscription)) return true;
                  } catch (Exception exp){
                  exp.printStackTrace();
                  System.out.println("Erreur lors de la désinscription");
              }
               return false;
           }
}
