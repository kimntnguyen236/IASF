/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Lab02.Lab02.Reponsitory;
import com.Lab02.Lab02.models.*;
import org.springframework.data.jpa.repository.JpaRepository;
/**
 *
 * @author Asus
 */
public interface CountryReponsitory extends JpaRepository<Country,Integer>{
    Country findById(int id);
}
