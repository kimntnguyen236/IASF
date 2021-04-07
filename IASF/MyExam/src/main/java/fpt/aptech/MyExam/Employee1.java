/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fpt.aptech.MyExam;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ThienKim
 */
@Entity
@Table(name = "Employee1")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Employee1.findAll", query = "SELECT e FROM Employee1 e"),
    @NamedQuery(name = "Employee1.findById", query = "SELECT e FROM Employee1 e WHERE e.id = :id"),
    @NamedQuery(name = "Employee1.findByPassword", query = "SELECT e FROM Employee1 e WHERE e.password = :password"),
    @NamedQuery(name = "Employee1.findByName", query = "SELECT e FROM Employee1 e WHERE e.name = :name"),
    @NamedQuery(name = "Employee1.findByAge", query = "SELECT e FROM Employee1 e WHERE e.age = :age")})
public class Employee1 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
//    @Basic(optional = false)
//    @NotNull
    @NotEmpty
    @Size(min = 1, max = 20, message = "From 1 to 20 characters")
    @Column(name = "id")
    private String id;
    
    @Size(max = 30)
    @NotEmpty(message = "Not null")
    @Column(name = "password")
    private String password;
    
    @Size(min = 2, max = 100)
    @NotEmpty(message = "From 1 to 20 characters")
    @Column(name = "name")
    private String name;
    
    @NotNull
    @Min(value = 18, message = "Age greater than or equals 18")
    @Column(name = "age")
    private Integer age;

    public Employee1() {
    }

    public Employee1(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
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
        if (!(object instanceof Employee1)) {
            return false;
        }
        Employee1 other = (Employee1) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fpt.aptech.MyExam.Employee1[ id=" + id + " ]";
    }
    
}
