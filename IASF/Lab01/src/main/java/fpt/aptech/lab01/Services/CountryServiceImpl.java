/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fpt.aptech.lab01.Services;

import fpt.aptech.lab01.Models.Country;
import fpt.aptech.lab01.Repository.CountryRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author vomin
 */
@Service
public class CountryServiceImpl implements CountryServices {

    @Autowired
    CountryRepository repository;

    @Override
    public List<Country> findAll() {
        return repository.findAll();
    }

//    @Override
//    public Country findOne(int id) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public void saveCountry(Country country) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public void deleteCountry(int id) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }

}
