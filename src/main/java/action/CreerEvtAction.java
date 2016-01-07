package action;

import DAO.DAOImplementations.EvenementDAOImplement;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import model.Evenement;
import model.Utilisateur;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;
import service.LeServiceUtilisateurAuth;
import service.LeServiceUtilisateurNonAuth;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * Created by Badam on 02/01/2016.
 */
public class CreerEvtAction extends ActionSupport  {

    private LeServiceUtilisateurNonAuth leServiceUtilisateurNonAuth = new LeServiceUtilisateurNonAuth();
    private LeServiceUtilisateurAuth leServiceUtilisateurAuth = new LeServiceUtilisateurAuth();
    private Evenement evenement;
    LoginAction loginAction;

    @Override
    public String execute(){
       return SUCCESS;

    }
    public String creerevt()
    { try {

        if(leServiceUtilisateurAuth.touverEvtService(evenement.getCodeevent(), loginAction.getUtilisateur().getIdentifiant())!= null)
            leServiceUtilisateurAuth.creerEvenentService(evenement);

        else  System.out.println("L'événement existe dejà");
        return SUCCESS;
    } catch (Exception e) {


    }
        return INPUT;
    }}

