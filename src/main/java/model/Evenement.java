package model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by Badam on 02/01/2016.
 */
@Entity
public class Evenement {
    private long codeevent;
    private String nomevent;
    private String sujet;
    private String salle;
    private long idAnimateur;

    public Evenement(){};
    public Evenement(long codeevent, String nomevent, String sujet, String salle, long idAnimateur)
    {
        this.codeevent = codeevent;
        this.nomevent = nomevent;
        this.salle = salle;
        this.sujet = sujet;
        this.idAnimateur = idAnimateur;
    }

    @Id
    @Column(name = "codeevent")
    public long getCodeevent() {
        return codeevent;
    }

    public void setCodeevent(long codeevent) {
        this.codeevent = codeevent;
    }

    @Basic
    @Column(name = "nomevent")
    public String getNomevent() {
        return nomevent;
    }

    public void setNomevent(String nomevent) {
        this.nomevent = nomevent;
    }

    @Basic
    @Column(name = "sujet")
    public String getSujet() {
        return sujet;
    }

    public void setSujet(String sujet) {
        this.sujet = sujet;
    }

    @Basic
    @Column(name = "salle")
    public String getSalle() {
        return salle;
    }

    public void setSalle(String salle) {
        this.salle = salle;
    }

    @Basic
    @Column(name = "id_animateur")
    public long getIdAnimateur() {
        return idAnimateur;
    }

    public void setIdAnimateur(long idAnimateur) {
        this.idAnimateur = idAnimateur;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Evenement evenement = (Evenement) o;

        if (codeevent != evenement.codeevent) return false;
        if (idAnimateur != evenement.idAnimateur) return false;
        if (nomevent != null ? !nomevent.equals(evenement.nomevent) : evenement.nomevent != null) return false;
        if (sujet != null ? !sujet.equals(evenement.sujet) : evenement.sujet != null) return false;
        if (salle != null ? !salle.equals(evenement.salle) : evenement.salle != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (codeevent ^ (codeevent >>> 32));
        result = 31 * result + (nomevent != null ? nomevent.hashCode() : 0);
        result = 31 * result + (sujet != null ? sujet.hashCode() : 0);
        result = 31 * result + (salle != null ? salle.hashCode() : 0);
        result = 31 * result + (int) (idAnimateur ^ (idAnimateur >>> 32));
        return result;
    }
}
