/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fpt.aptech.Lab03.Services;

import fpt.aptech.Lab03.Models.Account;
import fpt.aptech.Lab03.Repository.AccountRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ThienKim
 */
@Service
public class AccountService implements IAccount{
@Autowired
AccountRepository repository;

    @Override
    public List<Account> findAll() {
        return repository.findAll();
    }

//    @Override
//    public Account checkLogin(String accountno, String pincode) {
//        return repository.checkLogin(accountno, pincode);
//    }

    @Override
    public List<Account> search(String accountname) {
        return repository.findByLikeName("%"+accountname+"%");
    }
    
    @Override
    public void save(Account account) {
        account.setRole(Boolean.FALSE);
        repository.save(account);
    }

    @Override
    public Account checkLogin(String accountno, String pincode, boolean role) {
        return repository.checkLogin(accountno, pincode, role);
    }

//    @Override
//    public List<Account> searchByBalance(int min, int max) {
//        return repository.findByBalance(min, max);
//    }
}
