package DAO.DAOjdbc;

import model.Evenement;
import model.Inscription;
import model.Utilisateur;

/**
 * Created by Badam on 02/01/2016.
 */
public interface InscriptionDAO {

    public Inscription sinscrire(Evenement evenement, Utilisateur utilisateur);
    public Inscription inscriptionNote(Inscription inscription, Double note);
}
