/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.co.mxc.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author user
 */
@Entity
@Table(name = "customer")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Customer.findAll", query = "SELECT c FROM Customer c")
    , @NamedQuery(name = "Customer.findByCustomerId", query = "SELECT c FROM Customer c WHERE c.customerId = :customerId")
    , @NamedQuery(name = "Customer.findByCustomerName", query = "SELECT c FROM Customer c WHERE c.customerName = :customerName")
    , @NamedQuery(name = "Customer.findByCustomerEmail", query = "SELECT c FROM Customer c WHERE c.customerEmail = :customerEmail")
    , @NamedQuery(name = "Customer.findByCustomerTelepon", query = "SELECT c FROM Customer c WHERE c.customerTelepon = :customerTelepon")
    , @NamedQuery(name = "Customer.findByCustomerUpdatedby", query = "SELECT c FROM Customer c WHERE c.customerUpdatedby = :customerUpdatedby")
    , @NamedQuery(name = "Customer.findByCustomerCreatedby", query = "SELECT c FROM Customer c WHERE c.customerCreatedby = :customerCreatedby")
    , @NamedQuery(name = "Customer.findByCustomerCreatedtime", query = "SELECT c FROM Customer c WHERE c.customerCreatedtime = :customerCreatedtime")
    , @NamedQuery(name = "Customer.findByCustomerUpdatedtime", query = "SELECT c FROM Customer c WHERE c.customerUpdatedtime = :customerUpdatedtime")
    , @NamedQuery(name = "Customer.findByCustomerFlag", query = "SELECT c FROM Customer c WHERE c.customerFlag = :customerFlag")})
public class Customer implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "customer_id")
    private Integer customerId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "customer_name")
    private String customerName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "customer_email")
    private String customerEmail;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "customer_address")
    private String customerAddress;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "customer_telepon")
    private String customerTelepon;
    @Size(max = 50)
    @Column(name = "customer_updatedby")
    private String customerUpdatedby;
    @Size(max = 50)
    @Column(name = "customer_createdby")
    private String customerCreatedby;
    @Size(max = 50)
    @Column(name = "customer_createdtime")
    private String customerCreatedtime;
    @Size(max = 50)
    @Column(name = "customer_updatedtime")
    private String customerUpdatedtime;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "customer_flag")
    private String customerFlag;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customerId")
    private List<Payment> paymentList;

    public Customer() {
    }

    public Customer(Integer customerId) {
        this.customerId = customerId;
    }

    public Customer(Integer customerId, String customerName, String customerEmail, String customerAddress, String customerTelepon, String customerFlag) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.customerAddress = customerAddress;
        this.customerTelepon = customerTelepon;
        this.customerFlag = customerFlag;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public String getCustomerTelepon() {
        return customerTelepon;
    }

    public void setCustomerTelepon(String customerTelepon) {
        this.customerTelepon = customerTelepon;
    }

    public String getCustomerUpdatedby() {
        return customerUpdatedby;
    }

    public void setCustomerUpdatedby(String customerUpdatedby) {
        this.customerUpdatedby = customerUpdatedby;
    }

    public String getCustomerCreatedby() {
        return customerCreatedby;
    }

    public void setCustomerCreatedby(String customerCreatedby) {
        this.customerCreatedby = customerCreatedby;
    }

    public String getCustomerCreatedtime() {
        return customerCreatedtime;
    }

    public void setCustomerCreatedtime(String customerCreatedtime) {
        this.customerCreatedtime = customerCreatedtime;
    }

    public String getCustomerUpdatedtime() {
        return customerUpdatedtime;
    }

    public void setCustomerUpdatedtime(String customerUpdatedtime) {
        this.customerUpdatedtime = customerUpdatedtime;
    }

    public String getCustomerFlag() {
        return customerFlag;
    }

    public void setCustomerFlag(String customerFlag) {
        this.customerFlag = customerFlag;
    }

    @XmlTransient
    public List<Payment> getPaymentList() {
        return paymentList;
    }

    public void setPaymentList(List<Payment> paymentList) {
        this.paymentList = paymentList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (customerId != null ? customerId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Customer)) {
            return false;
        }
        Customer other = (Customer) object;
        if ((this.customerId == null && other.customerId != null) || (this.customerId != null && !this.customerId.equals(other.customerId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "id.co.mxc.model.Customer[ customerId=" + customerId + " ]";
    }
    
}
