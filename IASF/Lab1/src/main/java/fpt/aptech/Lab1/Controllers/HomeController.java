/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fpt.aptech.Lab1.Controllers;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author vomin
 */
@Controller
public class HomeController {

    @RequestMapping("/")
    public String index(Model model) {
        DateFormat date = DateFormat.getDateTimeInstance(DateFormat.FULL, DateFormat.FULL, Locale.ENGLISH);
        model.addAttribute("day", date.format(new Date()));
        model.addAttribute("name", "Welcome");
        return "index";
    }

    @RequestMapping("/index")
    public String welcome(@RequestParam(name = "txtname", defaultValue = "", required = false) String name, Model model) {
        model.addAttribute("name2", name);
        return "index";
    }
}
