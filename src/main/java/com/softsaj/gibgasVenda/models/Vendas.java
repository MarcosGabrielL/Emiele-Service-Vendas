/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.softsaj.gibgasVenda.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Marcos
 */
@Entity
@Table(name = "vendas")
public class Vendas {
    
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
     
   @Column(nullable = false, unique = true, length = 10)
   private String DiaVenda; 
   private int IdVendas;
   private String Caixa;
   private String Loja;
   @Column(nullable = false, unique = false, length = 20)
   private String DataVenda;
   @Column(nullable = false, unique = false, length = 20)
   private String Valor;
   @Column(nullable = false, unique = false)
   private float recebido1; 
   private float recebido2; 
   private float recebido3; 
   private float troco;
   @Column(nullable = false, unique = false, length = 20)
   private String ModoPagamento1;
   private String ModoPagamento2;
   private String ModoPagamento3;
   
   @Column(nullable = false, unique = false, length = 20)
    private String Vendedor_ID;
   
   @Column(nullable = false, unique = false, length = 20)
    private String Comprador_ID;
   
   
   /*1-Carrinho
    2-Pago
    3-Pronto
    4-Despachado
    5-Em Caminho
    6-Entregue
    7-Cancelado
    8-Extraviado
    9-Danificado*/
   @Column(nullable = false, unique = false, length = 20)
    private String Status;

    public Vendas() {
        super();
    }

    public Vendas(Long id, String DiaVenda, int IdVendas, String Caixa, String Loja, String DataVenda, String Valor, float recebido1, float recebido2, float recebido3, float troco, String ModoPagamento1, String ModoPagamento2, String ModoPagamento3, String Vendedor_ID, String Comprador_ID, String Status) {
        this.id = id;
        this.DiaVenda = DiaVenda;
        this.IdVendas = IdVendas;
        this.Caixa = Caixa;
        this.Loja = Loja;
        this.DataVenda = DataVenda;
        this.Valor = Valor;
        this.recebido1 = recebido1;
        this.recebido2 = recebido2;
        this.recebido3 = recebido3;
        this.troco = troco;
        this.ModoPagamento1 = ModoPagamento1;
        this.ModoPagamento2 = ModoPagamento2;
        this.ModoPagamento3 = ModoPagamento3;
        this.Vendedor_ID = Vendedor_ID;
        this.Comprador_ID = Comprador_ID;
        this.Status = Status;
    }

    public String getVendedor_ID() {
        return Vendedor_ID;
    }

    public void setVendedor_ID(String Vendedor_ID) {
        this.Vendedor_ID = Vendedor_ID;
    }

    public String getComprador_ID() {
        return Comprador_ID;
    }

    public void setComprador_ID(String Comprador_ID) {
        this.Comprador_ID = Comprador_ID;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }

    
   

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
   
   

    public int getIdVendas() {
        return IdVendas;
    }

    public void setIdVendas(int IdVendas) {
        this.IdVendas = IdVendas;
    }

    public String getCaixa() {
        return Caixa;
    }

    public void setCaixa(String Caixa) {
        this.Caixa = Caixa;
    }

    public String getLoja() {
        return Loja;
    }

    public void setLoja(String Loja) {
        this.Loja = Loja;
    }

    public String getDataVenda() {
        return DataVenda;
    }

    public void setDataVenda(String DataVenda) {
        this.DataVenda = DataVenda;
    }

    public String getValor() {
        return Valor;
    }

    public void setValor(String Valor) {
        this.Valor = Valor;
    }

    public String getDiaVenda() {
        return DiaVenda;
    }

    public void setDiaVenda(String DiaVenda) {
        this.DiaVenda = DiaVenda;
    }
    
    public float getTroco() {
        return troco;
    }

    public void setTroco(float troco) {
        this.troco = troco;
    }

    public float getRecebido1() {
        return recebido1;
    }

    public void setRecebido1(float recebido1) {
        this.recebido1 = recebido1;
    }

    public float getRecebido2() {
        return recebido2;
    }

    public void setRecebido2(float recebido2) {
        this.recebido2 = recebido2;
    }

    public float getRecebido3() {
        return recebido3;
    }

    public void setRecebido3(float recebido3) {
        this.recebido3 = recebido3;
    }

    public String getModoPagamento1() {
        return ModoPagamento1;
    }

    public void setModoPagamento1(String ModoPagamento1) {
        this.ModoPagamento1 = ModoPagamento1;
    }

    public String getModoPagamento2() {
        return ModoPagamento2;
    }

    public void setModoPagamento2(String ModoPagamento2) {
        this.ModoPagamento2 = ModoPagamento2;
    }

    public String getModoPagamento3() {
        return ModoPagamento3;
    }

    public void setModoPagamento3(String ModoPagamento3) {
        this.ModoPagamento3 = ModoPagamento3;
    }
    
    

  

    
}