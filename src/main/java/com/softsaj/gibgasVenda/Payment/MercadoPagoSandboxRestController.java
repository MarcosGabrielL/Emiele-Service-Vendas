/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.softsaj.gibgasVenda.Payment;

/**
 *
 * @author Marcos
 */

import com.mercadopago.exceptions.MPException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MercadoPagoSandboxRestController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private final PreferenceService preferenceService;

    public MercadoPagoSandboxRestController(PreferenceService preferenceService) {
        this.preferenceService = preferenceService;
    }
    

    @PostMapping(value = "/create", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity createPreference(
            @RequestBody NewPreferenceDTO preferenceDTO
            ) throws MPException {
        return this.preferenceService.create(preferenceDTO);
    }
    
    /*State: APROVED
Type: Mastercard
Number:    5031755734530604
CVV: 123
Expire at: 11/25
Holder: APRO GOMEZ
DNI: 31256588
Email: apro_gomez@gmail.com
---------------------------------
State: REJECTED
Type: Mastercard
Number:    5031755734530604
CVV: 123
Expire at: 11/25
Holder: EXPI GOMEZ
DNI: 31256588
Email: expi_gomez@gmail.com*/
}
