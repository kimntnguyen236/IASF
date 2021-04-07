/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fpt.aptech.Lab4.Controllers;

import fpt.aptech.Lab4.Models.*;
import fpt.aptech.Lab4.Services.*;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author sinhtm
 */
@Controller
public class HomeController {

    @Autowired
    ManService manService;
    @Autowired
    ProService proService;
    @Autowired
    VmanproService vmanproService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Model model) {
        model.addAttribute("list", vmanproService.findProList());
        return "index";
    }

    @RequestMapping(value = "/doCreate", method = RequestMethod.GET)
    public String doCreate(Model model, Product product) {
        product = new Product();
        model.addAttribute("list", manService.findAll());
        model.addAttribute("product", product);
        return "create";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String create(@Valid Product product,BindingResult bindingResult, Model model) {
        if(bindingResult.hasErrors()){
           model.addAttribute("list", manService.findAll());
            return "/create";
        }
        proService.saveProduct(product);
        return "redirect:/";
    }
    /*   @RequestMapping(value = "/",method = RequestMethod.GET)
    public ResponseEntity<List<Vmanpro>> findAll() {
        List<Vmanpro> list=vmanproService.findProList();
        if(list.isEmpty()){
            return new ResponseEntity<List<Vmanpro>>(HttpStatus.NO_CONTENT);
        }
        else{
            return new ResponseEntity<List<Vmanpro>>(list,HttpStatus.OK);
        }
    }
     */
}
