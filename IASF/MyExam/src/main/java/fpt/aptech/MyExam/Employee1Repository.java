/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fpt.aptech.MyExam;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.PathVariable;

/**
 *
 * @author ThienKim
 */
public interface Employee1Repository extends JpaRepository<Employee1, String> {
    @Query("SELECT e FROM Employee1 e WHERE e.id = :id AND e.password = :password")
    Employee1 checkLogin(@PathVariable("id") String id,@PathVariable("password") String password);
    
    @Query("SELECT e FROM Employee1 e WHERE e.id = :id")
    Employee1 findByid(@PathVariable("id") String id);
}
