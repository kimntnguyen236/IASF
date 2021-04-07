/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fpt.aptech.Lab4.Services;

import fpt.aptech.Lab4.Models.Vmanpro;
import fpt.aptech.Lab4.Repository.VmanproRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author sinhtm
 */
@Service
public class VmanproServiceImpl implements VmanproService {

    @Autowired
    VmanproRepository vmanproRepository;

    @Override
    public List<Vmanpro> findProList() {
        return vmanproRepository.findAll();
    }

}
