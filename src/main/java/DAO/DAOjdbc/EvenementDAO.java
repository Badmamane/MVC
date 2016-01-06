/*
 * Created on 13 mars 2006
 */
package DAO.DAOjdbc;

import java.util.List;
import model.Evenement;
import model.Utilisateur;

public interface EvenementDAO {

	public List<Evenement> findEvenementsByUtilisateur(Utilisateur utilisateur) throws Exception;

	public List<Evenement> listerTousEvt() throws Exception;

	public Evenement findEvenementByCodeEventIdentifiant(long codeEvent, long identifiant) throws Exception;

	public List<Utilisateur> listerTousPersonnes() throws Exception;

	public List<Utilisateur> ListerPersonnesParEvt(Evenement evenement) throws Exception;

	public Double VoirNoteMoyenneByEvenement(Evenement evenement) throws Exception;

	public boolean CreerEvenement(Evenement evenement) throws Exception;

	public boolean SupprimerEvenement(long codeEvent) throws Exception;

	public boolean updateEvenement(Evenement evenement) throws Exception;

}