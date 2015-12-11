package model;

import java.util.List;

/**
 * Created by Badam on 11/12/2015.
 */
public class Evenement {

    private Integer codeEvent;
    private String nom;
    private List<String> animateurs;
    private String sujet;
    private String salle;


    public Evenement(Integer codeEvent, String nom, List<String> animateurs,String sujet,String salle) {
        this.codeEvent = codeEvent;
        this.nom = nom;
        this.animateurs = animateurs;
        this.sujet=sujet;
        this.salle=salle;

    }

    public String getNom() { return this.nom ;}

    public List<String> getAnimateurs() {
        return this.animateurs;
    }

    public int getCodeEvent() {return this.codeEvent;}

    public String getSujet() {
        return this.sujet;
    }

    public void setNom(String nom) {this.nom = nom;}

    public void setSujet(String sujet) {
        this.sujet = sujet;
    }

    public void setSalle(String adresseMail) {this.salle = salle; }

    public void setAnimateurs(List<String> animateurs) {
        this.animateurs = animateurs;
    }

}
