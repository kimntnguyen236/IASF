/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fpt.aptech.Lab03.Controllers;

import fpt.aptech.Lab03.Models.Account;
import fpt.aptech.Lab03.Services.IAccount;
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
public class AccountController {

    @Autowired
    IAccount service;

    @RequestMapping("/index")
    public String index(Model model) {
        model.addAttribute("list", service.findAll());
        return "index";
    }

    @RequestMapping("/search")
    public String search(@PathParam("accountname") String accountname, Model model) {
        if (accountname.equals("")) {
            return "index";
        } else {
            model.addAttribute("list", service.search(accountname));
            return "index";
        }
    }
    
//    @RequestMapping("/searchByBalance")
//    public String searchByBalance(@PathParam("min") int min,@PathParam("max") int max, Model model) {
//        if (min==0 || max==0) {
//            return "index";
//        } else if(min>=max){
//            return "redirect:/ERROR";
//        }
//        else {
//            model.addAttribute("list", service.searchByBalance(min, max));
//            return "index";
//        }
//    }

    @RequestMapping(value = "/doLogin", method = RequestMethod.POST)
    public String doLogin(@PathParam("accountno") String accountno,
            @PathParam("pincode") String pincode,@PathParam("role") boolean role,
            Model model) {
        Account account = service.checkLogin(accountno, pincode, true);
        if (account != null) {
            return "redirect:/index";
        } else {
            return "redirect:/ERROR";
        }
        // return "login";
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
//    / thì sẽ chạy trước
    public String login(Model model) {
        model.addAttribute("account", new Account());
        return "login";
    }

    @RequestMapping("/ERROR")
    public String ERROR(Model model) {
        return "/ERROR";
    }
    
    @RequestMapping(value = "/doCreate", method = RequestMethod.GET)
    public String doCreate(Account account, Model model) {
        account= new Account();
        model.addAttribute("account", account);
        return "create";
    }
    
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String create(@Valid Account account,BindingResult bindingResult,
            Model model) {
        if (bindingResult.hasErrors()) {
            return "create";
        } 
        service.save(account);
        return "redirect:/";
    }
}
