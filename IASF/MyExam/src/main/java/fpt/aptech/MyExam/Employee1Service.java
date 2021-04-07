/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fpt.aptech.MyExam;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ThienKim
 */
@Service
public class Employee1Service implements IEmployee1{
@Autowired
    Employee1Repository repository;

    @Override
    public List<Employee1> findAll() {
        return repository.findAll();
    }

    @Override
    public Employee1 checkLogin(String id, String password) {
        return repository.checkLogin(id, password);
    }

    @Override
    public void save(Employee1 employee1) {
        repository.save(employee1);
    }

    @Override
    public Employee1 findOne(String id) {
        return repository.findByid(id);
    }
}
