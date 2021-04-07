/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fpt.aptech.Lab4.Services;

import fpt.aptech.Lab4.Models.Product;
import fpt.aptech.Lab4.Repository.ProRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author sinhtm
 */
@Service
public class ProServiceImpl implements ProService {

    @Autowired
    ProRepository proRepository;

    @Override
    public void saveProduct(Product product) {
         proRepository.save(product);        
    }
    
}
