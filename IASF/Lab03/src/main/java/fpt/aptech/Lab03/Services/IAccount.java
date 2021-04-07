/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fpt.aptech.Lab03.Services;

import fpt.aptech.Lab03.Models.Account;
import java.util.List;

/**
 *
 * @author ThienKim
 */
public interface IAccount {
    List<Account> findAll();
    Account checkLogin(String accountno, String pincode, boolean role);
    List<Account> search(String accountname);
//    List<Account> searchByBalance(int min, int max);
    void save(Account account);
}
