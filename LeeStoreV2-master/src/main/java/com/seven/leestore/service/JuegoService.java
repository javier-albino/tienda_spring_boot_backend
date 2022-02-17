package com.seven.leestore.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.seven.leestore.entity.Juego;
import com.seven.leestore.repository.JuegoRepository;

@Service
@Transactional
public class JuegoService {
	
	 @Autowired
	    JuegoRepository juegoRepository;
	 
	 public List<Juego> list(){
	        return juegoRepository.findAll();
	    }

	    public Optional<Juego> getOne(int id){
	        return juegoRepository.findById(id);
	    }

	    public Optional<Juego> getByNombre(String nombre){
	        return juegoRepository.findByNombre(nombre);
	    }

	    public void  save(Juego juego){
	    	juegoRepository.save(juego);
	    }

	    public void delete(int id){
	    	juegoRepository.deleteById(id);
	    }

	    public boolean existsById(int id){
	        return juegoRepository.existsById(id);
	    }

	    public boolean existsByNombre(String nombre){
	        return juegoRepository.existsByNombre(nombre);
	    }

}
