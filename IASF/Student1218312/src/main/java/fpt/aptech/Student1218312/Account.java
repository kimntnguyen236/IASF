/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fpt.aptech.Student1218312;

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
@Table(name = "Account")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Account.findAll", query = "SELECT a FROM Account a"),
    @NamedQuery(name = "Account.findByAccountno", query = "SELECT a FROM Account a WHERE a.accountno = :accountno"),
    @NamedQuery(name = "Account.findByAccountname", query = "SELECT a FROM Account a WHERE a.accountname = :accountname"),
    @NamedQuery(name = "Account.findByPincode", query = "SELECT a FROM Account a WHERE a.pincode = :pincode"),
    @NamedQuery(name = "Account.findByBalance", query = "SELECT a FROM Account a WHERE a.balance = :balance"),
    @NamedQuery(name = "Account.findByRole", query = "SELECT a FROM Account a WHERE a.role = :role")})
public class Account implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
//    @Basic(optional = false)
    // @NotNull
    @NotEmpty
    @Size(min = 1, max = 20, message = "From 1 to 20 characters")
    @Column(name = "accountno")
    private String accountno;
    
    @Size(max = 50)
    @NotEmpty(message = "Not null")
    @Column(name = "accountname")
    private String accountname;
    
    @Size(max = 50)
    @NotEmpty
    @Column(name = "pincode")
    private String pincode;
    
    @Column(name = "balance")
    @NotNull
    @Min(value = 1000, message = "Balance must > 1000")
    private Integer balance;
    
    @Column(name = "role")
    private Boolean role;

    public Account() {
    }

    public Account(String accountno) {
        this.accountno = accountno;
    }

    public String getAccountno() {
        return accountno;
    }

    public void setAccountno(String accountno) {
        this.accountno = accountno;
    }

    public String getAccountname() {
        return accountname;
    }

    public void setAccountname(String accountname) {
        this.accountname = accountname;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }

    public Boolean getRole() {
        return role;
    }

    public void setRole(Boolean role) {
        this.role = role;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (accountno != null ? accountno.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Account)) {
            return false;
        }
        Account other = (Account) object;
        if ((this.accountno == null && other.accountno != null) || (this.accountno != null && !this.accountno.equals(other.accountno))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fpt.aptech.Student1218312.Account[ accountno=" + accountno + " ]";
    }
    
}
