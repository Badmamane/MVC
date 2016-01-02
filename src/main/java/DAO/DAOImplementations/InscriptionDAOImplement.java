package DAO.DAOImplementations;

import DAO.DAOjdbc.InscriptionDAO;
import ObjetsHibernte.HibernateUtil;
import model.Evenement;
import model.Inscription;
import model.Utilisateur;
import org.hibernate.Session;

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

    public
}
