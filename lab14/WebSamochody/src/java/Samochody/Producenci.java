/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Samochody;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Student
 */
@Entity
@Table(name = "PRODUCENCI")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Producenci.findAll", query = "SELECT p FROM Producenci p")
    , @NamedQuery(name = "Producenci.findById", query = "SELECT p FROM Producenci p WHERE p.id = :id")
    , @NamedQuery(name = "Producenci.findByNazwa", query = "SELECT p FROM Producenci p WHERE p.nazwa = :nazwa")
    , @NamedQuery(name = "Producenci.findByRegon", query = "SELECT p FROM Producenci p WHERE p.regon = :regon")})
public class Producenci implements Serializable {

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
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 14)
    @Column(name = "REGON")
    private String regon;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idProducenta")
    private Collection<Towary> towaryCollection;

    public Producenci() {
    }

    public Producenci(Integer id) {
        this.id = id;
    }

    public Producenci(Integer id, String nazwa, String regon) {
        this.id = id;
        this.nazwa = nazwa;
        this.regon = regon;
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

    public String getRegon() {
        return regon;
    }

    public void setRegon(String regon) {
        this.regon = regon;
    }

    @XmlTransient
    public Collection<Towary> getTowaryCollection() {
        return towaryCollection;
    }

    public void setTowaryCollection(Collection<Towary> towaryCollection) {
        this.towaryCollection = towaryCollection;
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
        if (!(object instanceof Producenci)) {
            return false;
        }
        Producenci other = (Producenci) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Samochody.Producenci[ id=" + id + " ]";
    }
    
}
