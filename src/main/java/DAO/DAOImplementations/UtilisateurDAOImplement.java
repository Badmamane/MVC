package DAO.DAOImplementations;

import DAO.DAOjdbc.UtilisateurDAO;
import ObjetsHibernte.HibernateUtil;
import model.Utilisateur;
import org.hibernate.Query;
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

    public boolean loginAuth(String login, String mdp) throws Exception
    {

        Session session = util.getSessionFactory().openSession();
        String sql = " ";
        Query query = session.createQuery("from Utilisateur u where u.nom=:name and u.motdepasse=:pass");
        query.setParameter("name", login);
        query.setParameter("pass", mdp);
        List<Utilisateur> list = query.list();
        if (list.size() > 0) {
            session.close();
            return true;
        }
        session.close();
        return false;
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
