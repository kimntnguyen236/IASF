/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fpt.aptech.lab01.Repository;

import fpt.aptech.lab01.Models.Country;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author vomin
 */
public interface CountryRepository extends JpaRepository<Country, Integer >{
    //Country findById(int id);
}