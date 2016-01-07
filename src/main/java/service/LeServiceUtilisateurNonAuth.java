package service;

import DAO.DAOImplementations.EvenementDAOImplement;
import DAO.DAOImplementations.InscriptionDAOImplement;
import DAO.DAOImplementations.UtilisateurDAOImplement;
import DAO.DAOjdbc.EvenementDAO;
import DAO.DAOjdbc.InscriptionDAO;
import DAO.DAOjdbc.UtilisateurDAO;
import model.Evenement;
import model.Utilisateur;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Badam on 01/01/2016.
 */
public class LeServiceUtilisateurNonAuth {

    EvenementDAO evenementDAO = new EvenementDAOImplement();
    UtilisateurDAO utilisateurDAO = new UtilisateurDAOImplement();
    InscriptionDAO inscriptionDAO = new InscriptionDAOImplement();

   public boolean sauthentifierService(String nom, String mdp)
   {
       try
          {
           if(utilisateurDAO.loginAuth(nom, mdp)) return true;
          } catch (Exception exp){
                                      exp.printStackTrace();
                                     System.out.println("Impossible de vous retrouver parmi les utilisateurs");
                                 }
       return false;

   }
    public List<Evenement> consulterEvenementService()
    {
        List<Evenement> l = new ArrayList<Evenement>();
        try
        {
            l = evenementDAO.listerTousEvt();
            return l;
        } catch (Exception exp){
            exp.printStackTrace();
            System.out.println("Impossible de consulter les evenements");
                               }
            return l;
    }
    public List<Utilisateur> listerToutesPersonnesParEvntService(Evenement evenement) {
        List<Utilisateur> l = new ArrayList<Utilisateur>();
        try {
            l = evenementDAO.ListerPersonnesParEvt(evenement);
            return l;
        } catch (Exception exp) {
            exp.printStackTrace();
            System.out.println("Impossible de lister les utilisateurs");
        }
        return l;
    }

public Double voirNoteMoyenneService(Evenement evenement)
{
    Double moyenne = new Double(0);
    try
    {
        moyenne = evenementDAO.VoirNoteMoyenneByEvenement(evenement);
        return moyenne;
    }catch (Exception exp){
        exp.printStackTrace();
        System.out.println("Erreur  lors du calcul de la moyenne");
                        }
    return moyenne;
   }

    public Timestamp voirDateInscriptionService(Utilisateur utilisateur, Evenement evenement)
    {
       Timestamp timestamp = new Timestamp(20/02/1993);
        try
        {
            timestamp = inscriptionDAO.voirDateInscription(evenement, utilisateur);
            return timestamp;
        }catch (Exception exp){
            exp.printStackTrace();
            System.out.println("Erreur  lors du calcul de la moyenne");
        }
        return timestamp;
    }

    public boolean inscrireService(Utilisateur utilisateur)
    {
        boolean b = false;
        try
        {
            b = utilisateurDAO.creerUtilisateur(utilisateur);
            return b;
        }catch (Exception exp){
            exp.printStackTrace();
            System.out.println("Erreur  lors de votre inscription");
        }
        return b;
    }

}
