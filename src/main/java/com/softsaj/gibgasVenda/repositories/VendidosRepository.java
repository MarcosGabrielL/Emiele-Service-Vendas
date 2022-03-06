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
public interface VendidosRepository extends JpaRepository<Vendidos, Long> {
    
     Optional<Vendidos> findVendidosById(Long id);
     
     void deleteVendidosById(Long id);
}