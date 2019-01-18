/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Samochody;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Student
 */
@Entity
@Table(name = "TOWARY")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Towary.findAll", query = "SELECT t FROM Towary t")
    , @NamedQuery(name = "Towary.findById", query = "SELECT t FROM Towary t WHERE t.id = :id")
    , @NamedQuery(name = "Towary.findByNazwa", query = "SELECT t FROM Towary t WHERE t.nazwa = :nazwa")
    , @NamedQuery(name = "Towary.findByIloscWMagazynie", query = "SELECT t FROM Towary t WHERE t.iloscWMagazynie = :iloscWMagazynie")})
public class Towary implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "NAZWA")
    private String nazwa;
    @Column(name = "ILOSC_W_MAGAZYNIE")
    private Integer iloscWMagazynie;
    @JoinColumn(name = "ID_PRODUCENTA", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Producenci idProducenta;

    public Towary() {
    }

    public Towary(Integer id) {
        this.id = id;
    }

    public Towary(Integer id, String nazwa) {
        this.id = id;
        this.nazwa = nazwa;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public Integer getIloscWMagazynie() {
        return iloscWMagazynie;
    }

    public void setIloscWMagazynie(Integer iloscWMagazynie) {
        this.iloscWMagazynie = iloscWMagazynie;
    }

    public Producenci getIdProducenta() {
        return idProducenta;
    }

    public void setIdProducenta(Producenci idProducenta) {
        this.idProducenta = idProducenta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Towary)) {
            return false;
        }
        Towary other = (Towary) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Samochody.Towary[ id=" + id + " ]";
    }
    
}
