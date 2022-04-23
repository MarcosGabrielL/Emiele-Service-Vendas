/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.softsaj.gibgasVenda.Payment.models;

import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author Marcos
 */
public class ResultPago {
    
    public HttpServletRequest reques;
    public String collectionId;
    public String collectionStatus;
    public String externalReference;
    public String paymentType;
    public String merchantOrderId;
    public String preferenceId;
     public String siteId;
    public String processingMode;
    public String merchantAccountId;
    public RedirectAttributes attributes;
}
