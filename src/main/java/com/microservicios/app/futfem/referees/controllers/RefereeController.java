package com.microservicios.app.futfem.referees.controllers;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.microservicios.app.common.controllers.CommonController;
import com.microservicios.app.futfem.referees.models.entity.Referee;
import com.microservicios.app.futfem.referees.services.RefereeService;

@RestController
public class RefereeController extends CommonController<Referee, RefereeService>{
	
	@PutMapping("/{id}")
	public ResponseEntity<?> editar(@RequestBody Referee referee, @PathVariable Long id){
		Optional<Referee> o = service.findById(id);
		
		if (!o.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		Referee refereeDb = o.get();
		refereeDb.setName(referee.getName());
		refereeDb.setSurname(referee.getSurname());
		refereeDb.setCountry(referee.getCountry());
		refereeDb.setTarjetero(referee.getTarjetero());
		refereeDb.setCasero(referee.getCasero());
		refereeDb.setValiente(referee.getValiente());
		refereeDb.setUrlpic(referee.getUrlpic());
		
		// service.save(alumnoDb) permite persistir el alumno con los datos editados
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(refereeDb));  // HTTPStatus 201
	}
	
}
