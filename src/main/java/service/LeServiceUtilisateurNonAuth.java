package service;

import DAO.DAOjdbc.EvenementDAO;
import model.Evenement;
import model.Utilisateur;

import java.util.List;

/**
 * Created by Badam on 01/01/2016.
 */
public class LeServiceUtilisateurNonAuth implements LeService{

    EvenementDAO evenementDAO = new EvenementDaoJdbc();

    ClientDAO clientDAO = new ClientDaoJdbc();


    /*
    Il doit être possible de consulter les évènements passé ainsi que les évènements à venir.
    Il doit pouvoir consulter les personnes inscrites à l’évènement ainsi que leur date
d’inscription.
    Il doit pouvoir voir la note moyenne des anciens évènements

     */

    private void loadEvenements(Utilisateur utilisateur) throws Exception {
        List<Evenement> evenements = EvenementDAO.findEvenementsByUtilisateur(utilisateur);
        for (Compte c : comptes) {
            if (c instanceof CompteCourant)
                client.getCompteCourantList().add((CompteCourant) c);
            else
                client.getCompteEpargneList().add((CompteEpargne) c);
        }
    }
}
