package DAO.DAOImplementations;

import DAO.DAOjdbc.EvenementDAO;
import ObjetsHibernte.HibernateUtil;
import model.Evenement;
import model.Utilisateur;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Badam on 01/01/2016.
 */
public class EvenementDAOImplement implements EvenementDAO{

    private Evenement evenement;
    private Session session;
    private HibernateUtil util;


    public List<Evenement> findEvenementsByUtilisateur(Utilisateur utilisateur) throws Exception
    {

        List<Evenement> l;
        session = util.getSessionFactory().openSession();
        session.beginTransaction();
        l = session.createQuery("select Evenement.nomevent, Evenement.salle from Evenement, Inscription, Utilisateur where Evenement.codeevent = Inscription.codeevent and Inscription.identifiant = Utilisateur.identifiant ").list();
        session.getTransaction().commit();
        session.close();
        return l;
    }

    /*********/

    public List<Evenement> listerTousEvt() throws Exception
    {
        List<Evenement> l;
        session = util.getSessionFactory().openSession();
        session.beginTransaction();
        l = session.createQuery("from Evenement").list();
        session.getTransaction().commit();
        session.close();
        return l;
    }

    /*********/

    public Evenement findEvenementByCodeEventIdentifiant(int codeEvent, int identifiant) throws Exception
    {
return null;
    };

    public List<Utilisateur> listerTousPersonnes() throws Exception
    {
        List<Utilisateur> l;
        session = util.getSessionFactory().openSession();
        session.beginTransaction();
        l = session.createQuery("from Utilisateur").list();
        session.getTransaction().commit();
        session.close();
        return l;
    }
/************/
    public List<Utilisateur> ListerPersonnesParEvt(Evenement evenement) throws Exception
    {
        List<Utilisateur> l;
        session = util.getSessionFactory().openSession();
        session.beginTransaction();
        l = session.createQuery("select Utilisateur.nom, Utilisateur.prenom from Utilisateur, Inscription, Evenement where Evenement.codeevent = Inscription.codeevent and Inscription.identifiant = Utilisateur.identifiant").list();
        session.getTransaction().commit();
        session.close();
        return l;
    }
/**********/
    public Double VoirNoteMoyenneByEvenement(Evenement evenement) throws Exception
    {
        List<Double> l;
        Double moyenne = new Double(0) ;

        session = util.getSessionFactory().openSession();
        session.beginTransaction();
        l = session.createQuery("select avg(Inscription.note) from Utilisateur, Inscription, Evenement where Evenement.codeevent = Inscription.codeevent and Inscription.identifiant = Utilisateur.identifiant").list();
        session.getTransaction().commit();
        session.close();
        if(l.size() != 0) {
            moyenne = l.get(1);
            return moyenne;
                          }

        return moyenne;
    }
/***********/
    public boolean CreerEvenement(Evenement evenement) throws Exception
    {

        try {
            session = util.getSessionFactory().openSession();
            session.beginTransaction();
            session.saveOrUpdate(evenement);
            session.getTransaction().commit();
            session.close();
            return true;
        } catch (Exception e) {
        }
        return false;
    }

/************/

    public boolean updateEvenement(Evenement evenement) throws Exception
    {
        try {
            session = util.getSessionFactory().openSession();
            session.beginTransaction();
            session.saveOrUpdate(evenement);
            session.getTransaction().commit();
            session.close();
            return true;
        } catch (Exception e) {
        }
        return false;
    }
    /***************/

    public boolean SupprimerEvenement(long codeEvent) throws Exception
    {
        session = util.getSessionFactory().openSession();
        session.beginTransaction();
        Evenement evt = (Evenement) session.load(Evenement.class, codeEvent);
        session.delete(evt);
        session.getTransaction().commit();
        session.close();
        return true;
    }


}
