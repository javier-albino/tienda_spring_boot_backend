package com.seven.leestore.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.seven.leestore.entity.Juego;

@Repository
public interface JuegoRepository extends JpaRepository<Juego, Integer> {
    Optional<Juego> findByNombre(String nombre);
    boolean existsByNombre(String nombre); 

}
