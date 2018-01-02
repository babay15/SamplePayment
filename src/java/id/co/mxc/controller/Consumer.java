/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.co.mxc.controller;

import javax.servlet.http.HttpSession;
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
    
    @RequestMapping("/getdata")
    public String getCustomerData(HttpSession session){
        RestTemplate restTemplate = new RestTemplate();
        String uri = "";
        
        //BIKIN KELAS PENAMPUNG SEBELUM MASUK KE KELAS CUSTOMER
        //ASSIGN NILAI DARI KELAS PENAMPUNG TERSEBUT KE DALAM KELAS MODEL CUSTOMER 
        //MASUKAN KE DATABASE LALU MASUKAN KE SESSION AGAR BISA DIMASUKAN KE DALAM PROSES VALIDASI 
        
        
        return "redirect:/validasi";
        //LEMPAR KE KELAS VALIDASI
    }
    
    @RequestMapping("/validasi")
    public String formValidasi(HttpSession session){
        
        return "";
    }
    
    
}
