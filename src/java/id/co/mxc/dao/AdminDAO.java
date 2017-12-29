/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.co.mxc.dao;

import id.co.mxc.model.Admin;
import id.co.mxc.model.Credit;
import id.co.mxc.model.Customer;
import id.co.mxc.model.Payment;
import java.util.List;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author user
 */
@Repository
@Transactional
public class AdminDAO {
    
    static final Logger logger = Logger.getLogger(AdminDAO.class.getName());
    
    @PersistenceUnit
    EntityManagerFactory emf;
    
    private EntityManager em;
    
    public List<Admin> showAllAdmin(){
        em = emf.createEntityManager();
        Query query = em.createNamedQuery("Admin.findAll");
        List<Admin> admins = query.getResultList();
        return admins;
    }
    
    public List<Customer> showCustomer(){
        em = emf.createEntityManager();
        Query query = em.createNamedQuery("Customer.findAll");
        List<Customer> customers = query.getResultList();
        return customers;
    }
    
    public List<Payment> showPayment(){
        em = emf.createEntityManager();
        Query query = em.createNamedQuery("Payment.findAll");
        List<Payment> payments = query.getResultList();
        return payments;
    }
    
    public Credit findCreditById(Integer id){
        em = emf.createEntityManager();
        Query query = em.createNamedQuery("Credit.findByCreditId");
        query.setParameter("creditId", id);
        Credit credit = (Credit) query.getSingleResult();
        return credit;
    }
    
    public void editCredit(Credit credit){
        em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(credit);
        em.getTransaction().commit();
        em.close();
    }
    
    
    
    public List<Credit> showCreditApproved(){
        
        em = emf.createEntityManager();
        Query query = em.createNamedQuery("Credit.findByCreditStatusAndFlag");
        query.setParameter("creditFlag", "y");
        query.setParameter("creditStatus", "approved");
        List<Credit> credits = query.getResultList();
        return credits;        
    }
    
    public List<Credit> showCreditUnapproved(){
        
        em = emf.createEntityManager();
        Query query = em.createNamedQuery("Credit.findByCreditStatusAndFlag");
        query.setParameter("creditFlag", "y");
        query.setParameter("creditStatus", "unapproved");
        List<Credit> credits = query.getResultList();
        return credits;        
    }
    /**
     * @return the em
     */
    public EntityManager getEm() {
        return em;
    }

    /**
     * @param em the em to set
     */
    public void setEm(EntityManager em) {
        this.em = em;
    }
    
    
}
