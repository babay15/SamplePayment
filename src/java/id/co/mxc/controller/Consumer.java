/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.co.mxc.controller;

import id.co.mxc.dao.AdminDAO;
import id.co.mxc.model.Credit;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author user
 */
@Controller
@RequestMapping("consumers")
public class Consumer {
    
    @Autowired
    AdminDAO adminDao;
    
    
    @RequestMapping("/getdata")
    public String getCustomerData(HttpSession session){
        RestTemplate restTemplate = new RestTemplate();
        String uri = "";
        
        //BIKIN KELAS PENAMPUNG SEBELUM MASUK KE KELAS CUSTOMER
        //ASSIGN NILAI DARI KELAS PENAMPUNG TERSEBUT KE DALAM KELAS MODEL CUSTOMER 
        //MASUKAN KE DATABASE LALU MASUKAN KE SESSION AGAR BISA DIMASUKAN KE DALAM PROSES VALIDASI 
        Credit credit = new Credit(); //SEHARUSNYA AMBIL DARI REST TEMPLATE
        session.setAttribute("creditData", credit);
        
        return "redirect:/validasi";
        //LEMPAR KE KELAS VALIDASI
    }
    
    @RequestMapping("/validasi")
    public String formValidasi(HttpSession session){
        //DUMMY, SEHARUSNYA DARI REST TEMPLATE
        Credit credit = (Credit) session.getAttribute("creditData");
        //AMBIL DULU DARI FORM, ASSIGN KE BEAN, DARI BEAN BARU MASUK KE MODEL CREDIT
        
        Double hargaAwal = credit.getCreditBasePrice();
        Double uangMuka = credit.getCreditDownPayment();
        Double pokokCicilan = hargaAwal - uangMuka;
        int durasi = credit.getCreditDuration();
        Double persentaseBunga = credit.getCreditInterestRate();
        Double bungaCicilan = ((pokokCicilan * persentaseBunga * durasi)/12);
        Double bungaKredit = pokokCicilan + bungaCicilan;
        Double cicilanPerBulan = bungaKredit / durasi;
        
        //PERSONAL DATA
        double gaji = credit.getCreditSalary();
        double bonus = credit.getCredjtExtraRevenue();
        double penghasilanPerBulan = gaji + bonus;
        int tanggungan = credit.getCreditDependents();
        double limitPinjaman = penghasilanPerBulan/(tanggungan+1);
        
        if(hargaAwal<=limitPinjaman){
            //MASUK KE DATABASE
            adminDao.saveCredit(credit);
            return ""; //KE JSP YANG SUKSES MELAKUKAN CREDIT
        }else{
            return ""; //KE JSP YANG DITOLAK CREDITNYA
        }
    }
    
    
}
