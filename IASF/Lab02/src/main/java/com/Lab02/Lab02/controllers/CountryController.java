/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Lab02.Lab02.controllers;

import com.Lab02.Lab02.models.Country;
import com.Lab02.Lab02.sevice.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Asus
 */
@Controller
@RequestMapping("/")
public class CountryController {

    @Autowired
    CountryService service;

    @RequestMapping("/")
    public String page(Model model) {
        model.addAttribute("list", service.findAll());
        return "index";
    }

    @RequestMapping(value = "/doCreate", method = RequestMethod.GET)
    public String doCreate(Model model) {
        model.addAttribute("c", new Country());
        return "create";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String create(Country country, Model model) {
        service.saveCountry(country);
        return "redirect:/";
    }

    @RequestMapping(value = "/doEdit/{id}", method = RequestMethod.GET)
    public String doEdit(@PathVariable("id") int id, Model model) {
        Country country = service.findOne(id);
        if (country != null) {
            model.addAttribute("country", country);
        }
        return "edit";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String edit(Country country, Model model) {
        service.saveCountry(country);
        return "redirect:/";
    }

    @RequestMapping(value = "/delete/{id}")
    public String delete(@PathVariable("id") int id, Model model) {
        Country country = service.findOne(id);
        if (country != null) {
            service.delete(country);
            model.addAttribute("list", service.findAll());
        }

        return "redirect:/";
    }

}
