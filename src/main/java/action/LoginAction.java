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
        AppliService service = BanqueServiceManager.getBanqueService();

        try {
            this.client = service.findClient(this.client.getLogin(), this.client.getPassword());
            session.put("client", this.client);
            return SUCCESS;
        }
        catch (Exception e) {
            //addActionError("Mauvais login/ password");
            return INPUT;
        }
    }


    @Override
    public void setSession(Map<String, Object> map) {
        this.session = map;
    }


    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
