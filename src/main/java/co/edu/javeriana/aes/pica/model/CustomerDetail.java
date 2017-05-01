/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.javeriana.aes.pica.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 * @author sebastianpacheco
 */
public class CustomerDetail {
    @JsonProperty("cust_id")
    private int customerId;
    
    @JsonProperty("cust_firstname")
    private String customerFirstName;
    
    @JsonProperty("cust_lastname")
    private String customerLastName;
    
    @JsonProperty("cust_phone")
    private String customerPhone;
    
    @JsonProperty("cust_address")
    private String customerAdress;
    
    @JsonProperty("cust_email")
    private String customerEmail;
    
    @JsonProperty("cust_password")
    private String customerPassword;
    
    @JsonProperty("cust_credit_card_type")
    private String customerCreditCardType;
    
    @JsonProperty("cust_credit_card_number")
    private String customerCreditCardNumber;
    
    @JsonProperty("cust_status")
    private String customerStatus;

    /**
     * @return the customerId
     */
    public int getCustomerId() {
        return customerId;
    }

    /**
     * @param customerId the customerId to set
     */
    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    /**
     * @return the customerFirstName
     */
    public String getCustomerFirstName() {
        return customerFirstName;
    }

    /**
     * @param customerFirstName the customerFirstName to set
     */
    public void setCustomerFirstName(String customerFirstName) {
        this.customerFirstName = customerFirstName;
    }

    /**
     * @return the customerLastName
     */
    public String getCustomerLastName() {
        return customerLastName;
    }

    /**
     * @param customerLastName the customerLastName to set
     */
    public void setCustomerLastName(String customerLastName) {
        this.customerLastName = customerLastName;
    }

    /**
     * @return the customerPhone
     */
    public String getCustomerPhone() {
        return customerPhone;
    }

    /**
     * @param customerPhone the customerPhone to set
     */
    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    /**
     * @return the customerAdress
     */
    public String getCustomerAdress() {
        return customerAdress;
    }

    /**
     * @param customerAdress the customerAdress to set
     */
    public void setCustomerAdress(String customerAdress) {
        this.customerAdress = customerAdress;
    }

    /**
     * @return the customerEmail
     */
    public String getCustomerEmail() {
        return customerEmail;
    }

    /**
     * @param customerEmail the customerEmail to set
     */
    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    /**
     * @return the customerPassword
     */
    public String getCustomerPassword() {
        return customerPassword;
    }

    /**
     * @param customerPassword the customerPassword to set
     */
    public void setCustomerPassword(String customerPassword) {
        this.customerPassword = customerPassword;
    }

    /**
     * @return the customerCreditCardType
     */
    public String getCustomerCreditCardType() {
        return customerCreditCardType;
    }

    /**
     * @param customerCreditCardType the customerCreditCardType to set
     */
    public void setCustomerCreditCardType(String customerCreditCardType) {
        this.customerCreditCardType = customerCreditCardType;
    }

    /**
     * @return the customerCreditCardNumber
     */
    public String getCustomerCreditCardNumber() {
        return customerCreditCardNumber;
    }

    /**
     * @param customerCreditCardNumber the customerCreditCardNumber to set
     */
    public void setCustomerCreditCardNumber(String customerCreditCardNumber) {
        this.customerCreditCardNumber = customerCreditCardNumber;
    }

    /**
     * @return the customerStatus
     */
    public String getCustomerStatus() {
        return customerStatus;
    }

    /**
     * @param customerStatus the customerStatus to set
     */
    public void setCustomerStatus(String customerStatus) {
        this.customerStatus = customerStatus;
    }
}
