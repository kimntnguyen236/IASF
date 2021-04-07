/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fpt.aptech.Lab4.Models;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
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
 * @author sinhtm
 */
@Entity
@Table(name = "Manufacture")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Manufacture.findAll", query = "SELECT m FROM Manufacture m"),
    @NamedQuery(name = "Manufacture.findByManid", query = "SELECT m FROM Manufacture m WHERE m.manid = :manid"),
    @NamedQuery(name = "Manufacture.findByManname", query = "SELECT m FROM Manufacture m WHERE m.manname = :manname")})
public class Manufacture implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "manid")
    private Integer manid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "manname")
    private String manname;
    @OneToMany(mappedBy = "manid")
    private List<Product> productList;

    public Manufacture() {
    }

    public Manufacture(Integer manid) {
        this.manid = manid;
    }

    public Manufacture(Integer manid, String manname) {
        this.manid = manid;
        this.manname = manname;
    }

    public Integer getManid() {
        return manid;
    }

    public void setManid(Integer manid) {
        this.manid = manid;
    }

    public String getManname() {
        return manname;
    }

    public void setManname(String manname) {
        this.manname = manname;
    }

    @XmlTransient
    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (manid != null ? manid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Manufacture)) {
            return false;
        }
        Manufacture other = (Manufacture) object;
        if ((this.manid == null && other.manid != null) || (this.manid != null && !this.manid.equals(other.manid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fpt.aptech.Lab4.Models.Manufacture[ manid=" + manid + " ]";
    }
    
}
