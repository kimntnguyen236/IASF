/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Lab02.Lab02.sevice;

import com.Lab02.Lab02.models.Country;
import java.util.List;

/**
 *
 * @author Asus
 */
public interface ICountry {
    List<Country> findAll();
    Country findOne(int id);
    void saveCountry(Country country);
    void delete(Country country);
}
