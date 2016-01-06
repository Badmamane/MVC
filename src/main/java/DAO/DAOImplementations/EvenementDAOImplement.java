package DAO.DAOImplementations;

import DAO.DAOjdbc.EvenementDAO;
import ObjetsHibernte.HibernateUtil;
import model.Evenement;
import model.Inscription;
import model.Utilisateur;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.transform.Transformers;
import org.hibernate.type.DoubleType;
import org.hibernate.type.LongType;
import org.hibernate.type.StringType;
import org.hibernate.type.TimestampType;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Badam on 01/01/2016.
 */
public class EvenementDAOImplement implements EvenementDAO{

    private Evenement evenement;
    private Utilisateur utilisateur;
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

    public List<Evenement> listerTousEvt()
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

     public  Evenement findEvenementByCodeEventIdentifiant(long codeEvent, long identifiant)
    {
        session = util.getSessionFactory().openSession();
        session.beginTransaction();
        Inscription inscription = new Inscription();

        try {

            Query query = session
                    .createSQLQuery("select evenement.codeevent, evenement.nomevent, evenement.id_animateur, " +
                            "evenement.salle, evenement.sujet from  evenement WHERE evenement.codeevent=:code and utilisateur.identifiant= :id")
                    .addScalar("codeevent", LongType.INSTANCE)
                    .addScalar("nomevent", StringType.INSTANCE)
                    .addScalar("idanimateur", LongType.INSTANCE)
                    .addScalar("salle", StringType.INSTANCE)
                    .addScalar("sujet", StringType.INSTANCE)
                    .setResultTransformer(Transformers.aliasToBean(Inscription.class));

            query.setParameter("code", evenement.getCodeevent());
            query.setParameter("id", utilisateur.getIdentifiant());

            evenement =  (Evenement) query.list().get(1);
            return evenement;

        }catch (Exception exp){
            System.out.println("Erreur lors de la récherche de l'evenement");
            exp.printStackTrace();
        }

        return evenement;

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
