package action;

/**
 * Created by Badam on 11/12/2015.
 */

        import com.opensymphony.xwork2.ActionSupport;
        import model.Utilisateur;
        import org.apache.struts2.interceptor.SessionAware;

        import java.util.HashMap;
        import java.util.Map;


   public class LoginAction extends ActionSupport implements SessionAware {

       private Map<String, Object> session = null;

       private Utilisateur utilisateur = new Utilisateur();


       public String execute() {
           AppliService service = LeServiceManager.getLeService();

           try {
               this.utilisateur = service.findUtilisateur(this.utilisateur.getNom(), this.utilisateur.getMotdePasse());
               session.put("utilisateur", this.utilisateur);
               return SUCCESS;
           } catch (Exception e) {
               //addActionError("Mauvais login/ password");
               return INPUT;
           }
       }



       public void setSession(Map<String, Object> map) {
           this.session = map;
       }

       public Utilisateur getUtilisateur() {
           return this.utilisateur;
       }

       public void setClient(Utilisateur utilisateur) {
           this.utilisateur = utilisateur;
       }
   }
