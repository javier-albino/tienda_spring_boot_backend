package com.seven.leestore.controller;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.seven.leestore.dto.Mensaje;
import com.seven.leestore.dto.UsuarioDto;
import com.seven.leestore.entity.Ciudad;
import com.seven.leestore.entity.Juego;
import com.seven.leestore.entity.Usuario;
import com.seven.leestore.service.CiudadService;
import com.seven.leestore.service.JuegoService;
import com.seven.leestore.service.UsuarioService;

@RestController
@RequestMapping("/producto")
@CrossOrigin(origins = "http://localhost:4200")
public class LeeStoreController {

	@Autowired
	UsuarioService usuarioService;
	@Autowired
	CiudadService ciudadService;
	@Autowired
	JuegoService JuegoService;

	@GetMapping("/lista")
	public ResponseEntity<List<Juego>> list() {
		List<Juego> list = JuegoService.list();
		return new ResponseEntity(list, HttpStatus.OK);
	}
	
	@GetMapping("/listaCiudad")
	public ResponseEntity<List<Ciudad>> listCiudad() {
		List<Ciudad> listCiudad = ciudadService.listCiudad();
		return new ResponseEntity(listCiudad, HttpStatus.OK);
	}

	@GetMapping("/detail/{id}")
	public ResponseEntity<Usuario> getById(@PathVariable("id") int id) {
		if (!usuarioService.existsById(id))
			return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
		Usuario producto = usuarioService.getOne(id).get();
		return new ResponseEntity(producto, HttpStatus.OK);
	}

	@GetMapping("/detailname/{nombre}")
	public ResponseEntity<Usuario> getByNombre(@PathVariable("nombre") String nombre) {
		if (!usuarioService.existsByNombre(nombre))
			return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
		Usuario producto = usuarioService.getByNombre(nombre).get();
		return new ResponseEntity(producto, HttpStatus.OK);
	}

	@PostMapping("/create")
	public ResponseEntity<?> create(@RequestBody UsuarioDto usuarioDto) {
		if (StringUtils.isBlank(usuarioDto.getNombre()))
			return new ResponseEntity(new Mensaje("el nombre es obligatorio"), HttpStatus.BAD_REQUEST);
//        if(usuarioDto.getPrecio()==null || usuarioDto.getPrecio()<0 )
//            return new ResponseEntity(new Mensaje("el precio debe ser mayor que 0"), HttpStatus.BAD_REQUEST);
		if (usuarioService.existsByNombre(usuarioDto.getNombre()))
			return new ResponseEntity(new Mensaje("ese nombre ya existe"), HttpStatus.BAD_REQUEST);
		Usuario usuario = new Usuario(usuarioDto.getNombre(), usuarioDto.getPass(),
				usuarioDto.getEmail() /* usuarioDto.getPrecio() */);
		usuarioService.save(usuario);
		return new ResponseEntity(new Mensaje("producto creado"), HttpStatus.OK);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody UsuarioDto usuarioDto) {
		if (!usuarioService.existsById(id))
			return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
		if (usuarioService.existsByNombre(usuarioDto.getNombre())
				&& usuarioService.getByNombre(usuarioDto.getNombre()).get().getId() != id)
			return new ResponseEntity(new Mensaje("ese nombre ya existe"), HttpStatus.BAD_REQUEST);
		if (StringUtils.isBlank(usuarioDto.getNombre()))
			return new ResponseEntity(new Mensaje("el nombre es obligatorio"), HttpStatus.BAD_REQUEST);
//        if(usuarioDto.getPrecio()==null || usuarioDto.getPrecio()<0 )
//           return new ResponseEntity(new Mensaje("el precio debe ser mayor que 0"), HttpStatus.BAD_REQUEST);

		Usuario usuario = usuarioService.getOne(id).get();
		usuario.setNombre(usuarioDto.getNombre());
		// producto.setPrecio(usuarioDto.getPrecio());
		usuarioService.save(usuario);
		return new ResponseEntity(new Mensaje("usuario actualizado"), HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") int id) {
		if (!usuarioService.existsById(id))
			return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
		usuarioService.delete(id);
		return new ResponseEntity(new Mensaje("usuario eliminado"), HttpStatus.OK);
	}

}
