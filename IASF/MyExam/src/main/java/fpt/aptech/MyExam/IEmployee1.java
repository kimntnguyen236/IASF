/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fpt.aptech.MyExam;

import java.util.List;

/**
 *
 * @author ThienKim
 */
public interface IEmployee1 {
    List<Employee1> findAll();
    Employee1 checkLogin(String id, String password);
    void save(Employee1 account);
    Employee1 findOne(String id);
}
