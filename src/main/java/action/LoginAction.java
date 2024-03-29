package action;

/**
 * Created by Badam on 11/12/2015.
 */

        import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import model.Evenement;
import model.Inscription;
import model.Utilisateur;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;
import service.LeServiceUtilisateurAuth;
import service.LeServiceUtilisateurNonAuth;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;


   public class LoginAction extends ActionSupport implements SessionAware {

       private Map<String, Object> session = null;
       private Utilisateur utilisateur = new Utilisateur();
       private LeServiceUtilisateurNonAuth leServiceUtilisateurNonAuth = new LeServiceUtilisateurNonAuth();
       private LeServiceUtilisateurAuth  leServiceUtilisateurAuth = new LeServiceUtilisateurAuth();

       public String execute() {

        return SUCCESS;

       }
public String login()
{
    try {
        if(leServiceUtilisateurNonAuth.sauthentifierService(utilisateur.getNom(), utilisateur.getMotdepasse()))
            session.put("utilisateur", this.utilisateur);
        System.out.println("Vous êtes connecté sous le nom"+utilisateur.getNom());
        return SUCCESS;

    } catch (Exception e) {
        return INPUT;
    }
}
public String sinscrire(){

   try {
       HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get( ServletActionContext.HTTP_REQUEST);

    Evenement evenement = leServiceUtilisateurAuth.touverEvtService(Long.parseLong(request. getParameter("id")), utilisateur.getIdentifiant());
    Inscription inscription = leServiceUtilisateurAuth.SinscrireEvenementService(utilisateur,  evenement);
    return SUCCESS;} catch (Exception exp){
       exp.printStackTrace();
   }
    return INPUT;
}
       public String desinscrire ()
       {
           try {
               HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get( ServletActionContext.HTTP_REQUEST);

               Evenement evenement = leServiceUtilisateurAuth.touverEvtService(Long.parseLong(request. getParameter("id")), utilisateur.getIdentifiant());
               if(leServiceUtilisateurAuth.seDesinscrireServce(evenement, utilisateur))
               return SUCCESS;
           } catch (Exception exp){
               exp.printStackTrace();
           }
           return INPUT;
       }

       public String visualiser()
       {
           Double noteMoyenne;
           try {
               HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get( ServletActionContext.HTTP_REQUEST);
               HttpServletResponse response = (HttpServletResponse) ActionContext.getContext().get( ServletActionContext.HTTP_RESPONSE);
               Evenement evenement = leServiceUtilisateurAuth.touverEvtService(Long.parseLong(request. getParameter("id")), utilisateur.getIdentifiant());
               noteMoyenne = leServiceUtilisateurNonAuth.voirNoteMoyenneService(evenement);
               request.setAttribute("note", noteMoyenne);
               RequestDispatcher dispatcher = request.getRequestDispatcher("visualiseEvt.jsp");
               dispatcher.forward(request, response);
                   return SUCCESS;
                } catch (Exception exp){
               exp.printStackTrace();
           }
           return INPUT;
       }

       public String listerEvenements()
       {
           List<Evenement> evenementList;
           Evenement evenement;
           try {
               HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get( ServletActionContext.HTTP_REQUEST);
               HttpServletResponse response = (HttpServletResponse) ActionContext.getContext().get( ServletActionContext.HTTP_RESPONSE);
               evenementList = leServiceUtilisateurNonAuth.consulterEvenementService();
               request.setAttribute("evenementList", evenementList);
               RequestDispatcher dispatcher = request.getRequestDispatcher("visualiseEvt.jsp");
               dispatcher.forward(request, response);
               return SUCCESS;
           } catch (Exception exp){
               exp.printStackTrace();
           }
           return INPUT;
       }
       public String listerUtilisateurParEvenement()
       {

           List<Utilisateur> utilisateurListParEvt;
           Evenement evenement;
           try {
               HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get( ServletActionContext.HTTP_REQUEST);
               HttpServletResponse response = (HttpServletResponse) ActionContext.getContext().get( ServletActionContext.HTTP_RESPONSE);
               evenement =  leServiceUtilisateurAuth.touverEvtService(Long.parseLong(request. getParameter("identifiant")), utilisateur.getIdentifiant());
               utilisateurListParEvt = leServiceUtilisateurNonAuth.listerToutesPersonnesParEvntService(evenement);
               request.setAttribute("evenementListParEvt", utilisateurListParEvt);
               RequestDispatcher dispatcher = request.getRequestDispatcher("listerUtilisateursParEvent.jsp");
               dispatcher.forward(request, response);
               return SUCCESS;
           } catch (Exception exp){
               exp.printStackTrace();
           }
           return INPUT;
       }

       public void setSession(Map<String, Object> map) {
           this.session = map;
       }

       public Map<String, Object> getSession() {
           return session;
       }

       public Utilisateur getUtilisateur() {
           return this.utilisateur;
       }


   }
