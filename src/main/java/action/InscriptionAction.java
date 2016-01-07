package action;

import com.opensymphony.xwork2.ActionSupport;
import model.Utilisateur;
import service.LeServiceUtilisateurNonAuth;

/**
 * Created by Badam on 01/01/2016.
 */
public class InscriptionAction extends ActionSupport {
    private Utilisateur utilisateur = new Utilisateur();
    private LeServiceUtilisateurNonAuth leServiceUtilisateurNonAuth = new LeServiceUtilisateurNonAuth();

    @Override
    public String execute() {
        return SUCCESS;
    }
    public String inscriptionAuSite()
    {
        Utilisateur utilisateur = new Utilisateur();
        boolean b;
        try {

              b = leServiceUtilisateurNonAuth.inscrireService(utilisateur);
              if(b) System.out.println("Vous venez de vous inscrire sur notre site sous le nom"+utilisateur.getNom());
              return SUCCESS;
            } catch (Exception exp)
        {
            exp.printStackTrace();
        }
        return INPUT;
    }
}
