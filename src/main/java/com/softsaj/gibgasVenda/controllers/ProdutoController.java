/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.softsaj.gibgasVenda.controllers;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Marcos
 */

import com.softsaj.gibgasVenda.models.Produto;
import com.softsaj.gibgasVenda.repositories.ProdutoRepository;
import com.softsaj.gibgasVenda.services.ProdutoService;
import com.softsaj.gibgasVenda.util.validateToken;
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

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/produtos")
public class ProdutoController {
    
    
     @Autowired
    private ProdutoService vs;
     
     @Autowired
     private validateToken validatetoken;
     
    @GetMapping
    public ResponseEntity<List<Produto>> getAll() {
        List<Produto> produtos =  vs.findAll();
        return new ResponseEntity<>(produtos, HttpStatus.OK);
    }
    
    //GEt Produto
    @GetMapping(path = "produto")
    public ResponseEntity<Produto> getCienfiloById (
            @RequestParam("token") String token,
            @RequestParam("id") Long id) {
        
        
        
       // if(!validatetoken.isLogged(token)){
         //    throw new IllegalStateException("token not valid");
       // }
        
        Produto produto = vs.findProdutoById(id);
        return new ResponseEntity<>(produto, HttpStatus.OK);
    }
    
    @PostMapping("/produto/add")
    public ResponseEntity<Produto> addProduto(@RequestBody Produto produto
    ,@RequestParam("token") String token) {
        
       // if(!validatetoken.isLogged(token)){
        //     throw new IllegalStateException("token not valid");
      //  }
       
        Produto newProduto = vs.addProduto(produto);
        URI uri = ServletUriComponentsBuilder.
                fromCurrentRequest().path("/produto/{id}").buildAndExpand(produto.getId()).toUri();
        
        return new ResponseEntity<>(newProduto, HttpStatus.CREATED);
    }
    
    //Update nome,telefone,idade,foto;
    @PutMapping("/produto/update/{id}")
    public ResponseEntity<Produto> updateProduto(@PathVariable("id") Long id, 
            @RequestBody Produto newproduto, 
            @RequestParam("token") String token) {
        
        if(!validatetoken.isLogged(token)){
             throw new IllegalStateException("token not valid");
        }
        
        
        Produto produto = vs.findProdutoById(id);
        produto.setDescrição(newproduto.getDescrição());
        produto.setQuantidade(newproduto.getQuantidade());
        produto.setPreçoUn(newproduto.getPreçoUn());
        produto.setUnidade(newproduto.getUnidade());
        //produto.setFoto(newproduto.getFoto);
        
        Produto updateProduto = vs.updateProduto(produto);//s
        return new ResponseEntity<>(updateProduto, HttpStatus.OK);
    }
    
    @Transactional
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteProduto(@PathVariable("id") Long id,
            @RequestParam("token") String token) {
        
        if(!validatetoken.isLogged(token)){
             throw new IllegalStateException("token not valid");
        }
        
        vs.deleteProduto(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

