/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fpt.aptech.Lab4.Repository;

import fpt.aptech.Lab4.Models.Manufacture;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author sinhtm
 */
public interface ManRepository extends JpaRepository<Manufacture, Integer> {
    
}
