/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fpt.aptech.MyExam;

import javax.validation.Valid;
import javax.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author ThienKim
 */
@Controller
public class Employee1Controller {
    @Autowired
    IEmployee1 service;

    @RequestMapping("/index")
    public String index(Model model) {
        model.addAttribute("list", service.findAll());
        return "index";
    }
    
    @RequestMapping(value = "/doLogin", method = RequestMethod.POST)
    public String doLogin(@PathParam("id") String id,
            @PathParam("password") String password, 
            Model model) {
        Employee1 employee1 = service.checkLogin(id, password);
        if (employee1 != null) {
            return "redirect:/index";
        } else {
            return "redirect:/ERROR";
        }
        // return "login";
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
//    / thì sẽ chạy trước
    public String login(Model model) {
        model.addAttribute("employee1", new Employee1());
        return "login";
    }

    @RequestMapping("/ERROR")
    public String ERROR(Model model) {
        return "/ERROR";
    }

    @RequestMapping(value = "/doCreate", method = RequestMethod.GET)
    public String doCreate(Employee1 employee1, Model model) {
        employee1 = new Employee1();
        model.addAttribute("employee1", employee1);
        return "create";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String create(@Valid final Employee1 employee1, BindingResult bindingResult,
            Model model) {
        Employee1 existing = service.findOne(employee1.getId());
        if (existing != null) {
            return "/ERROR";
        }
        if (bindingResult.hasErrors()) {
            return "create";
        }
        service.save(employee1);
        return "redirect:/index";
    }
}
