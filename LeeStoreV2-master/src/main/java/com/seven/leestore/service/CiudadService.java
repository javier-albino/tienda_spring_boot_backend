package com.seven.leestore.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.seven.leestore.entity.Ciudad;
import com.seven.leestore.repository.CiudadRepository;

@Service
@Transactional
public class CiudadService {

	 @Autowired
	    CiudadRepository ciudadRepository;
	 
	 public List<Ciudad> listCiudad(){
	        return ciudadRepository.findAll();
	    }

	    public Optional<Ciudad> getOne(int id){
	        return ciudadRepository.findById(id);
	    }

	    public Optional<Ciudad> getByNombre(String nombre){
	        return ciudadRepository.findByNombre(nombre);
	    }

	    public void  save(Ciudad ciudad){
	    	ciudadRepository.save(ciudad);
	    }

	    public void delete(int id){
	    	ciudadRepository.deleteById(id);
	    }

	    public boolean existsById(int id){
	        return ciudadRepository.existsById(id);
	    }

	    public boolean existsByNombre(String nombre){
	        return ciudadRepository.existsByNombre(nombre);
	    }

}
