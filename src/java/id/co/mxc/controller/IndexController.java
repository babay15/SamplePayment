/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.co.mxc.controller;

import id.co.mxc.dao.AdminDAO;
import id.co.mxc.model.Admin;
import id.co.mxc.model.Credit;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author user
 */
@Controller
@RequestMapping("/index")
public class IndexController {
    
    @Autowired
    AdminDAO adminDao;
    
    @RequestMapping("")
    public String toIndex(Model model){
        List<Credit> credits = adminDao.showCreditApproved();
        model.addAttribute("admins", credits);
        
        List<Credit> creditz = adminDao.showCreditUnapproved();
        model.addAttribute("adminz", creditz);
        return "index";
    }
    
    @RequestMapping("/delete/{id}")
    public String deleteCredit(@PathVariable Integer id, Model model){
        Credit credit = adminDao.findCreditById(id);
        credit.setCreditFlag("n");
        adminDao.editCredit(credit);
        
        List<Credit> credits = adminDao.showCreditApproved();
        model.addAttribute("admins", credits);
        
        List<Credit> creditz = adminDao.showCreditUnapproved();
        model.addAttribute("adminz", creditz);
        return "redirect:/index";
    }
    
    @RequestMapping("/approve/{id}")
    public String approveCredit(@PathVariable Integer id, Model model){
        Credit credit = adminDao.findCreditById(id);
        credit.setCreditStatus("approved");
        adminDao.editCredit(credit);
        
        List<Credit> credits = adminDao.showCreditApproved();
        model.addAttribute("admins", credits);
        
        List<Credit> creditz = adminDao.showCreditUnapproved();
        model.addAttribute("adminz", creditz);
        return "redirect:/index";
    }
}
