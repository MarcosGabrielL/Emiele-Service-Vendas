/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.softsaj.gibgasVenda.repositories;

import com.softsaj.gibgasVenda.models.*;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Marcos
 */
@Repository
public interface VendasRepository extends JpaRepository<Vendas, Long> {
    
     Optional<Vendas> findVendasById(Long id);
     
     void deleteVendasById(Long id);
}