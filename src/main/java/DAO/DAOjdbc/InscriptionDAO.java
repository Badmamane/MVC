package DAO.DAOjdbc;

import model.Evenement;
import model.Inscription;
import model.Utilisateur;

import java.sql.Timestamp;

/**
 * Created by Badam on 02/01/2016.
 */
public interface InscriptionDAO {

    public Inscription sinscrire(Evenement evenement, Utilisateur utilisateur) throws Exception;
    public Inscription inscriptionNote(Inscription inscription, Double note) throws Exception;
    public boolean Desinscription(Inscription inscription) throws Exception;
    public Inscription findInscriptionByCodeEvtIden(Evenement evenement, Utilisateur utilisateur) throws Exception;
    public Timestamp voirDateInscription(Evenement evenement, Utilisateur utilisateur) throws Exception;
}
