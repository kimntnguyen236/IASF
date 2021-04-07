/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fpt.aptech.Lab4.Models;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author sinhtm
 */
@Entity
@Table(name = "Vmanpro")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vmanpro.findAll", query = "SELECT v FROM Vmanpro v"),
    @NamedQuery(name = "Vmanpro.findById", query = "SELECT v FROM Vmanpro v WHERE v.id = :id"),
    @NamedQuery(name = "Vmanpro.findByName", query = "SELECT v FROM Vmanpro v WHERE v.name = :name"),
    @NamedQuery(name = "Vmanpro.findByPrice", query = "SELECT v FROM Vmanpro v WHERE v.price = :price"),
    @NamedQuery(name = "Vmanpro.findByManid", query = "SELECT v FROM Vmanpro v WHERE v.manid = :manid"),
    @NamedQuery(name = "Vmanpro.findByManname", query = "SELECT v FROM Vmanpro v WHERE v.manname = :manname")})
public class Vmanpro implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private int id;
    @Size(max = 100)
    @Column(name = "name")
    private String name;
    @Column(name = "price")
    private Integer price;
    @Column(name = "manid")
    private Integer manid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "manname")
    private String manname;

    public Vmanpro() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
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
    
}
