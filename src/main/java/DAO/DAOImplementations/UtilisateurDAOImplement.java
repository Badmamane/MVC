package DAO.DAOImplementations;

import DAO.DAOjdbc.UtilisateurDAO;
import ObjetsHibernte.HibernateUtil;
import model.Utilisateur;
import org.hibernate.Session;

import java.util.List;

/**
 * Created by Badam on 02/01/2016.
 */
public class UtilisateurDAOImplement implements UtilisateurDAO {

    private Utilisateur utilisateur;
    private Session session;
    private HibernateUtil util;

    public  Utilisateur findUtilisateurById(int identifiant)
            throws Exception
    {

        session = util.getSessionFactory().openSession();
        session.beginTransaction();
        Utilisateur u = (Utilisateur) session.load(Utilisateur.class, identifiant);
        session.getTransaction().commit();
        session.close();
        return u;
    }

    public boolean creerUtilisateur(Utilisateur utilisateur) throws Exception
    {
        try {
            session = util.getSessionFactory().openSession();
            session.beginTransaction();
            session.saveOrUpdate(utilisateur);
            session.getTransaction().commit();
            session.close();
            return true;
        } catch (Exception e) {
        }
        return false;
    }

    public  boolean updateUtilisateur(Utilisateur utilisateur) throws Exception
    {
        try {
            session = util.getSessionFactory().openSession();
            session.beginTransaction();
            session.saveOrUpdate(utilisateur);
            session.getTransaction().commit();
            session.close();
            return true;
        } catch (Exception e) {
        }
        return false;
    }
}
