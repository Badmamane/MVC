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
        import java.util.HashMap;
        import java.util.List;
        import java.util.Map;


   public class LoginAction extends ActionSupport implements SessionAware {

       private Map<String, Object> session = null;
       private Utilisateur utilisateur = new Utilisateur();
       private LeServiceUtilisateurNonAuth leServiceUtilisateurNonAuth = new LeServiceUtilisateurNonAuth();
       private LeServiceUtilisateurAuth  leServiceUtilisateurAuth = new LeServiceUtilisateurAuth();
       public String execute() {

          try {
               if(leServiceUtilisateurNonAuth.sauthentifierService(utilisateur.getNom(), utilisateur.getMotdepasse()))
               session.put("utilisateur", this.utilisateur);
               System.out.println("Vous êtes connecté sous le nom"+utilisateur.getNom());
               List<Evenement>  evenementList = leServiceUtilisateurNonAuth.consulterEvenementService();
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
               RequestDispatcher dispatcher = request.getRequestDispatcher("visualiserevt.jsp");
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
