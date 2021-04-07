/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fpt.aptech.Lab03.Repository;

import fpt.aptech.Lab03.Models.Account;
import java.util.List;
import javax.websocket.server.PathParam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.PathVariable;

/**
 *
 * @author ThienKim
 */
public interface AccountRepository extends JpaRepository<Account, String>{
    @Query("SELECT a FROM Account a WHERE a.accountno = :accountno AND a.pincode = :pincode AND a.role = :role")
    Account checkLogin(@PathVariable("accountno") String accountno,@PathVariable("pincode") String pincode, @PathVariable("role") Boolean role);
    
    @Query("SELECT a FROM Account a WHERE a.accountname LIKE :accountname")
    List<Account> findByLikeName(@PathVariable("accountname") String accountname);
    
//    @Query("SELECT a FROM Account a WHERE a.balance WHERE :min AND :max")
//    List<Account> findByBalance(@PathParam("min") int min, @PathParam("max") int max);
}
