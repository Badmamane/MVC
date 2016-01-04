/*
 * Created on 13 mars 2006
 */
package DAO.DAOjdbc;

import model.Utilisateur;

public interface UtilisateurDAO {

	/**
	 * Instancie et fabrique un objet de type Utilisateur
	 */
	public abstract Utilisateur findUtilisateurById(int id)
			throws Exception;

	boolean loginAuth(String login, String mdp) throws Exception;

	public abstract boolean creerUtilisateur(Utilisateur utilisateur) throws Exception;

	public abstract boolean updateUtilisateur(Utilisateur utilisateur) throws Exception;

}