package model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;

/**
 * Created by Badam on 02/01/2016.
 */
@Entity
public class Inscription {
    private long codeevent;
    private long identifiant;
    private Timestamp dateinscription;
    private Double note;
    private long idinscription;

    public Inscription(){};
    public Inscription(long codeevent, long identifiant, Timestamp dateinscription, Double note, long idinscription)
    {
        this.codeevent = codeevent;
        this.identifiant = identifiant;
        this.dateinscription = dateinscription;
        this.note = note;
        this.idinscription = idinscription;
    }

    public void setNote(Double note) {
        this.note = note;
    }

    @Basic
    @Column(name = "codeevent")
    public long getCodeevent() {
        return codeevent;
    }

    public void setCodeevent(long codeevent) {
        this.codeevent = codeevent;
    }

    @Basic
    @Column(name = "identifiant")
    public long getIdentifiant() {
        return identifiant;
    }

    public void setIdentifiant(long identifiant) {
        this.identifiant = identifiant;
    }

    @Basic
    @Column(name = "dateinscription")
    public Timestamp getDateinscription() {
        return dateinscription;
    }

    public void setDateinscription(Timestamp dateinscription) {
        this.dateinscription = dateinscription;
    }

    @Basic
    @Column(name = "note")
    public Double getNote() {
        return note;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Inscription that = (Inscription) o;

        if (codeevent != that.codeevent) return false;
        if (identifiant != that.identifiant) return false;
        if (dateinscription != null ? !dateinscription.equals(that.dateinscription) : that.dateinscription != null)
            return false;
        if (note != null ? !note.equals(that.note) : that.note != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (codeevent ^ (codeevent >>> 32));
        result = 31 * result + (int) (identifiant ^ (identifiant >>> 32));
        result = 31 * result + (dateinscription != null ? dateinscription.hashCode() : 0);
        result = 31 * result + (note != null ? note.hashCode() : 0);
        return result;
    }

    @Id
    @Column(name = "idinscription")
    public long getIdinscription() {
        return idinscription;
    }

    public void setIdinscription(long idinscription) {
        this.idinscription = idinscription;
    }
}
