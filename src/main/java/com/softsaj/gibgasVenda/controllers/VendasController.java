
package com.softsaj.gibgasVenda.controllers;



/**
 *
 * @author Marcos
 */

import com.softsaj.gibgasVenda.models.Produto;
import com.softsaj.gibgasVenda.models.RequestWrapper;
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
import com.softsaj.gibgasVenda.models.Vendidos;
import com.softsaj.gibgasVenda.services.ProdutoService;
import com.softsaj.gibgasVenda.services.VendasService;
import com.softsaj.gibgasVenda.services.VendidosService;
import com.softsaj.gibgasVenda.util.validateToken;
import java.net.URI;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
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
     
     @Autowired
    private VendidosService vds;
     
    @GetMapping
    public ResponseEntity<List<Vendas>> getAll() {
        List<Vendas> vendas =  vs.findAll();
        return new ResponseEntity<>(vendas, HttpStatus.OK);
    }
    
    //GEt Vendas
     @GetMapping("/venda/{id}")
    public ResponseEntity<Vendas> getCienfiloById (@PathVariable("id") Long id
            ,@RequestParam("token") String token) {
        
      //  if(!validatetoken.isLogged(token)){
        //     throw new IllegalStateException("token not valid");
        //}
        
        Vendas venda = vs.findVendasById(id);
        return new ResponseEntity<>(venda, HttpStatus.OK);
    }
    
    @PostMapping("/venda")
    public ResponseEntity<Vendas> addVendas(
            @RequestBody RequestWrapper requestWrapper,
            @RequestParam("token") String token) {
        
       // if(!validatetoken.isLogged(token)){
        //     throw new IllegalStateException("token not valid");
       // }
        
       Vendas venda =  requestWrapper.getVendas();
       List<Produto> produtos = requestWrapper.getProdutos();
       
        
        Locale locale = new Locale("pt","BR");
                GregorianCalendar calendar = new GregorianCalendar();
                SimpleDateFormat formatador = new SimpleDateFormat("YYYY-MM-dd hh:mm:ssXXX",locale);
                Date d = new Date();
                String data = formatador.format(d.getTime());
                System.out.println("DATA: "+data);
                //Salva venda e pega id venda
        venda.setStatus("0");
        venda.setDatavenda(data);
        Vendas newVendas = vs.addVendas(venda);
                
        //Salva produtos vendidos
        for(Produto p : produtos){
            Vendidos v = new Vendidos();
            v.setCodigo(p.getCodigo());
            v.setDataSaida(data);
            v.setIdVenda(newVendas.getId().intValue());
            v.setQuantidade(p.getQuantidade());
            v.setTipo(p.getTipo());
            v.setVendedor_ID(newVendas.getVendedor_id());
            
        }
        
        
        URI uri = ServletUriComponentsBuilder.
                fromCurrentRequest().path("/venda/{id}").buildAndExpand(venda.getId()).toUri();
        
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
    
     @PostMapping("/venda/cancela")
    public ResponseEntity<Vendas> addVendascancel(
            @RequestParam("id") Long id
             ,@RequestParam("token") String token) {
        
       // if(!validatetoken.isLogged(token)){
         //    throw new IllegalStateException("token not valid");
        //}
        
        Vendas venda = vs.findVendasById(id);
        
        Locale locale = new Locale("pt","BR");
                GregorianCalendar calendar = new GregorianCalendar();
                SimpleDateFormat formatador = new SimpleDateFormat("YYYY-MM-dd hh:mm:ssXXX",locale);
                Date d = new Date();
                String data = formatador.format(d.getTime());
                
                //Salva venda e pega id venda
        venda.setStatus("7");
        venda.setDatacancelamento(data);
        Vendas newVendas = vs.addVendas(venda);
        
        
        URI uri = ServletUriComponentsBuilder.
                fromCurrentRequest().path("/venda/{id}").buildAndExpand(venda.getId()).toUri();
        
        return new ResponseEntity<>(newVendas, HttpStatus.CREATED);
    }
    
    @Transactional
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteVendas(@PathVariable("id") Long id
             ,@RequestParam("token") String token) {
        
       // if(!validatetoken.isLogged(token)){
         //    throw new IllegalStateException("token not valid");
        //}
        vs.deleteVendas(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}


