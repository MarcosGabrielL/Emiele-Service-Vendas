/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.softsaj.gibgasVenda.Payment;

/**
 *
 * @author Marcos
 */

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mercadopago.MercadoPago;
import com.mercadopago.exceptions.MPException;
import com.mercadopago.resources.Preference;
import com.mercadopago.resources.datastructures.preference.BackUrls;
import com.mercadopago.resources.datastructures.preference.Item;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.thymeleaf.util.StringUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Collectors;

@Service
public class PreferenceService {
    private final Gson gson = new GsonBuilder().setPrettyPrinting().create();


    public String create(NewPreferenceDTO preferenceDTO) throws MPException {
       /* if (StringUtils.isEmpty(preferenceDTO.getAccessToken())) {
            return ResponseEntity.badRequest().body("Access token is mandatory");
        }
        if (preferenceDTO.getItems().isEmpty()) {
            return ResponseEntity.badRequest().body("Items empty");
        }*/

        MercadoPago.SDK.setAccessToken(preferenceDTO.getAccessToken());
        String notificationUrl = "https://emiele-service-vendas.herokuapp.com/generic";

        Preference p = new Preference();
        p.setBackUrls(
          new BackUrls().setSuccess(notificationUrl)
                  .setPending(notificationUrl)
                .setFailure(notificationUrl)
        );
        p.setItems(preferenceDTO.getItems().stream()
                .map(i -> {
                    Item item = new Item();
                    item.setUnitPrice(i.getPrice());
                    item.setTitle(i.getName());
                    item.setQuantity(i.getQuantity());

                    return item;
                })
                .collect(Collectors.toCollection(ArrayList::new)));

         var result = p.save();
         
         System.out.println(result);

        if (StringUtils.isEmpty(p.getId())) {
            return "Preference was not created. Check if Access Token is valid";
        }
        
        return result.getSandboxInitPoint();
    }
    
}
