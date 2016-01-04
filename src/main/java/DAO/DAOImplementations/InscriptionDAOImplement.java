package DAO.DAOImplementations;

import DAO.DAOjdbc.InscriptionDAO;
import ObjetsHibernte.HibernateUtil;
import model.Evenement;
import model.Inscription;
import model.Utilisateur;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.transform.Transformers;
import org.hibernate.type.DoubleType;
import org.hibernate.type.LongType;
import org.hibernate.type.TimestampType;
import service.ExceptionLev;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Badam on 02/01/2016.
 */
public class InscriptionDAOImplement implements InscriptionDAO {

    private Session session;
    private HibernateUtil util;


    public Inscription sinscrire(Evenement evenement, Utilisateur utilisateur)
    {

        session = util.getSessionFactory().openSession();
        session.beginTransaction();
        Inscription inscription = new Inscription();
        inscription.setCodeevent(evenement.getCodeevent());
        inscription.setIdentifiant(utilisateur.getIdentifiant());
        session.saveOrUpdate(inscription);
        session.getTransaction().commit();
        session.close();
        return inscription;
    }

    public Inscription inscriptionNote(Inscription inscription, Double note)
    {
        session = util.getSessionFactory().openSession();
        session.beginTransaction();
        inscription.setNote(note);
        session.saveOrUpdate(inscription);
        session.getTransaction().commit();
        session.close();
        return inscription;

    }
    public boolean Desinscription(Inscription inscription)
    {
        session = util.getSessionFactory().openSession();
        session.beginTransaction();
        Inscription ins = (Inscription) session.load(Inscription.class, inscription.getIdinscription());
        session.delete(ins);
        session.getTransaction().commit();
        session.close();
        return true;
    }
    public Inscription findInscriptionByCodeEvtIden(Evenement evenement, Utilisateur utilisateur)
    {
        //public Client findClient(String p_clt_login, String p_motDePasse) throws BankonetException {
        session = util.getSessionFactory().openSession();
        session.beginTransaction();
        Inscription inscription = new Inscription();

        try {


            //Query query = session.createSQLQuery("select codeevent, identifiant,dateinscription,note, idinscription  FROM Inscription i WHERE i.codeevent=:code and i.identifiant= :id");

            Query query = session
                    .createSQLQuery("select codeevent, identifiant,dateinscription,note, idinscription  FROM Inscription i WHERE i.codeevent=:code and i.identifiant= :id")
                    .addScalar("codeevent", LongType.INSTANCE)
                    .addScalar("identifiant", LongType.INSTANCE)
                    .addScalar("dateinscription", TimestampType.INSTANCE)
                    .addScalar("note", DoubleType.INSTANCE)
                    .addScalar("idinscription", LongType.INSTANCE)
                    .setResultTransformer(Transformers.aliasToBean(Inscription.class));

            query.setParameter("code", evenement.getCodeevent());
            query.setParameter("id", utilisateur.getIdentifiant());

            inscription =  (Inscription)query.list().get(1);
            return inscription;

        }catch (Exception exp){
            System.out.println("Erreur lors de la récherche de l'Inscription");
            exp.printStackTrace();
        }

 return inscription;

    }
}
