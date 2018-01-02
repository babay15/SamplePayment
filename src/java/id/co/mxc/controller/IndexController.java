/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.co.mxc.controller;

import id.co.mxc.bean.CreditFormBean;
import id.co.mxc.dao.AdminDAO;
import id.co.mxc.model.Admin;
import id.co.mxc.model.Credit;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpSession;
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
    
    @RequestMapping("/edit/{id}")
    public String editCredit(HttpSession session,@PathVariable Integer id, Model model){
        Credit credit = adminDao.findCreditById(id);
        CreditFormBean creditBean = new CreditFormBean();
        session.setAttribute("credit",credit);
        model.addAttribute("creditBean",creditBean);
        return "edit";
    }
    
    @RequestMapping("/edit/save")
    public String saveEditCredit(HttpSession session, CreditFormBean creditBean, Model model){       
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
        String tanggal = sdf.format(new Date());
        creditBean.setCreditMonthlyInstallment();
        creditBean.setCreditTotal();
        Credit credit = (Credit) session.getAttribute("credit");
        credit.setCreditBasePrice(creditBean.getCreditBasePrice());
        credit.setCreditDownPayment(creditBean.getCreditDownPayment());
        credit.setCreditDuration(creditBean.getCreditDuration());

        double pokokCicilan = creditBean.getCreditBasePrice() - creditBean.getCreditDownPayment();
        double bungaCicilan = ((pokokCicilan * creditBean.getCreditInterestRate() * creditBean.getCreditDuration())/12);
        double bungaKredit = pokokCicilan + bungaCicilan;
 
        credit.setCreditInterestRate(creditBean.getCreditInterestRate());
        credit.setCreditTotal(bungaKredit + creditBean.getCreditDownPayment());
        credit.setCreditMonthlyInstallment(bungaKredit/creditBean.getCreditDuration());
        
        credit.setCreditUpdatedtime(tanggal);
        adminDao.editCredit(credit);
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
