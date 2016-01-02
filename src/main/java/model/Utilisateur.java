package model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by Badam on 02/01/2016.
 */
@Entity
public class Utilisateur {

    private long identifiant;
    private String nom;
    private String prenom;
    private String adressemail;
    private String motdepasse;


    public Utilisateur(){};

    public Utilisateur( long identifiant, String prenom, String nom, String adressemail, String motdepasse)
    {
        this.identifiant = identifiant;
        this.prenom = prenom;
        this.nom = nom;
        this.adressemail = adressemail;
        this.motdepasse = motdepasse;
    };
    @Id
    @Column(name = "identifiant")
    public long getIdentifiant() {
        return identifiant;
    }

    public void setIdentifiant(long identifiant) {
        this.identifiant = identifiant;
    }

    @Basic
    @Column(name = "nom")
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Basic
    @Column(name = "prenom")
    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    @Basic
    @Column(name = "adressemail")
    public String getAdressemail() {
        return adressemail;
    }

    public void setAdressemail(String adressemail) {
        this.adressemail = adressemail;
    }

    @Basic
    @Column(name = "motdepasse")
    public String getMotdepasse() {
        return motdepasse;
    }

    public void setMotdepasse(String motdepasse) {
        this.motdepasse = motdepasse;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Utilisateur that = (Utilisateur) o;

        if (identifiant != that.identifiant) return false;
        if (nom != null ? !nom.equals(that.nom) : that.nom != null) return false;
        if (prenom != null ? !prenom.equals(that.prenom) : that.prenom != null) return false;
        if (adressemail != null ? !adressemail.equals(that.adressemail) : that.adressemail != null) return false;
        if (motdepasse != null ? !motdepasse.equals(that.motdepasse) : that.motdepasse != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (identifiant ^ (identifiant >>> 32));
        result = 31 * result + (nom != null ? nom.hashCode() : 0);
        result = 31 * result + (prenom != null ? prenom.hashCode() : 0);
        result = 31 * result + (adressemail != null ? adressemail.hashCode() : 0);
        result = 31 * result + (motdepasse != null ? motdepasse.hashCode() : 0);
        return result;
    }
}
