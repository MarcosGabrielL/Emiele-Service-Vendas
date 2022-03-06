/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.softsaj.gibgasVenda.controllers;



/**
 *
 * @author Marcos
 */

import com.softsaj.gibgasVenda.models.Vendas;
import com.softsaj.gibgasVenda.repositories.VendasRepository;
import com.softsaj.gibgasVenda.services.VendasService;
import java.net.URI;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.softsaj.gibgasVenda.models.Vendas;
import com.softsaj.gibgasVenda.services.VendasService;
import com.softsaj.gibgasVenda.util.validateToken;
import java.net.URI;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/vendas")
public class VendasController {
    
    
     @Autowired
    private VendasService vs;
   
     @Autowired
     private validateToken validatetoken;
     
    @GetMapping
    public ResponseEntity<List<Vendas>> getAll() {
        List<Vendas> movies =  vs.findAll();
        return new ResponseEntity<>(movies, HttpStatus.OK);
    }
    
    //GEt Vendas
     @GetMapping("/venda/{id}")
    public ResponseEntity<Vendas> getCienfiloById (@PathVariable("id") Long id
            ,@RequestParam("token") String token) {
        
        if(!validatetoken.isLogged(token)){
             throw new IllegalStateException("token not valid");
        }
        
        Vendas venda = vs.findVendasById(id);
        return new ResponseEntity<>(venda, HttpStatus.OK);
    }
    
    @PostMapping("/venda/add")
    public ResponseEntity<Vendas> addVendas(@RequestBody Vendas movie
             ,@RequestParam("token") String token) {
        
        if(!validatetoken.isLogged(token)){
             throw new IllegalStateException("token not valid");
        }
       
        Vendas newVendas = vs.addVendas(movie);
        URI uri = ServletUriComponentsBuilder.
                fromCurrentRequest().path("/venda/{id}").buildAndExpand(movie.getId()).toUri();
        
        return new ResponseEntity<>(newVendas, HttpStatus.CREATED);
    }
    
    //Update nome,telefone,idade,foto;
    @PutMapping("/venda/update/{id}")
    public ResponseEntity<Vendas> updateVendas(@PathVariable("id") Long id, @RequestBody Vendas newvenda
     ,@RequestParam("token") String token) {
        
        if(!validatetoken.isLogged(token)){
             throw new IllegalStateException("token not valid");
        }
        Vendas venda = vs.findVendasById(id);
        //venda.setNome(newvenda.getNome());
        //c//inefilo.setTelefone(newvenda.getTelefone());
        //venda.setIdade(newvenda.getIdade());
        //venda.setFoto(newvenda.getFoto());
        Vendas updateVendas = vs.updateVendas(venda);//s
        return new ResponseEntity<>(updateVendas, HttpStatus.OK);
    }
    
    @Transactional
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteVendas(@PathVariable("id") Long id
             ,@RequestParam("token") String token) {
        
        if(!validatetoken.isLogged(token)){
             throw new IllegalStateException("token not valid");
        }
        vs.deleteVendas(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}


