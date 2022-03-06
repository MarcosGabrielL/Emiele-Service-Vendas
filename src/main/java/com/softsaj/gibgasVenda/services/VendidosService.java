/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.softsaj.gibgasVenda.services;

import com.softsaj.gibgasVenda.exception.UserNotFoundException;
import com.softsaj.gibgasVenda.models.Vendidos;
import com.softsaj.gibgasVenda.repositories.VendidosRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

/**
 *
 * @author Marcos
 */
 @Service
public class VendidosService {
    
  
    @Autowired
    private VendidosRepository rp;
    
     public List<Vendidos> findAll() {
        return rp.findAll();
    }
     
     public Vendidos findVendidosById(Long id) {
        return rp.findVendidosById(id)
                .orElseThrow(() -> new UserNotFoundException("Vendidos by id " + id + " was not found"));
    }
     
     public Vendidos addVendidos(Vendidos cinefilo) {
        return rp.save(cinefilo);
    }
     
      public Vendidos updateVendidos(Vendidos cinefilo) {
        return rp.save(cinefilo);
    }
      
      public void deleteVendidos(Long id){
        try{
          rp.deleteVendidosById(id);  
        }catch(DataIntegrityViolationException e){
            throw new DataIntegrityViolationException(
                    "Não foi possivel deletar o Vendidos");
        }
    }
    
}

