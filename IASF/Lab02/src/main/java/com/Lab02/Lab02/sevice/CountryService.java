/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Lab02.Lab02.sevice;

import com.Lab02.Lab02.models.Country;
import java.util.List;
import org.springframework.stereotype.Service;
import com.Lab02.Lab02.Reponsitory.*;
import org.springframework.beans.factory.annotation.Autowired;
/**
 *
 * @author Asus
 */
@Service
public class CountryService implements  ICountry{

    @Autowired
    CountryReponsitory repository;
    
    @Override
    public List<Country> findAll() {
        return repository.findAll();
    }

    @Override
    public Country findOne(int id) {
        return repository.findById(id);
    }

    @Override
    public void saveCountry(Country country) {
        repository.save(country);
    }

    @Override
    public void delete(Country country) {
        repository.delete(country);
    }
    
}
