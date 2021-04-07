/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fpt.aptech.lab01.Controllers;

import fpt.aptech.lab01.Services.CountryServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author vomin
 */
@Controller
public class HomeController {
    @Autowired
    CountryServices services;
    
    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String page(Model model) {
        model.addAttribute("list",services.findAll());
        return "index";
    }
    
}
