package com.seven.leestore.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.seven.leestore.entity.Ciudad;

@Repository
public interface CiudadRepository extends JpaRepository<Ciudad, Integer> {
    Optional<Ciudad> findByNombre(String nombre);
    boolean existsByNombre(String nombre); 


}
