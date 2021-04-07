/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fpt.aptech.Student1218312;

import java.util.List;

/**
 *
 * @author ThienKim
 */
public interface IAccount {
    List<Account> findAll();
    Account checkLogin(String accountno, String pincode, boolean role);
    List<Account> search(String accountname);
//    List<Account> searchBySalary(int min, int max);
//    List<Account> searchByMin(int min);
//    List<Account> searchByMax(int max);
    void save(Account account);
    Account findOne(String accountno);
    void delete(Account account);
}
