package model;

/**
 * Created by Badam on 11/12/2015.
 */
public class Utilisateur {

    private String identifiant;
    private String nom;
    private String prenom;
    private String adresseMail;
    private String motdePasse;


    public Utilisateur(String identifiant, String nom, String prenom,String adresseMail,String motdePasse) {
        this.identifiant = identifiant;
        this.nom = nom;
        this.prenom = prenom;
        this.adresseMail=adresseMail;
        this.motdePasse=motdePasse;

    }

    public String getNom() { return this.nom ;}

    public String getPrenom() {
        return this.prenom;
    }

    public String getAdresseMail() {
        return this.adresseMail;
    }

    public String getIdentifiant() {
        return this.identifiant;
    }

    public String getMotdePasse() {
        return this.motdePasse;
    }

    public void setNom(String nom) {this.nom = nom;}

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setAdresseMail(String adresseMail) {
        this.adresseMail = adresseMail;
    }

    public void setMotdePasse(String motdePasse) {
        this.motdePasse = motdePasse;
    }

}