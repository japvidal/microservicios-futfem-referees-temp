package com.microservicios.app.futfem.referees.models.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="referees_temp")
public class Referee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	private String surname;
	private String country;
	
	private int casero;
	private int valiente;
	private int tarjetero;
	
	private String urlpic;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public int getCasero() {
		return casero;
	}

	public void setCasero(int casero) {
		this.casero = casero;
	}

	public int getValiente() {
		return valiente;
	}

	public void setValiente(int valiente) {
		this.valiente = valiente;
	}

	public int getTarjetero() {
		return tarjetero;
	}

	public void setTarjetero(int tarjetero) {
		this.tarjetero = tarjetero;
	}

	public String getUrlpic() {
		return urlpic;
	}

	public void setUrlpic(String urlpic) {
		this.urlpic = urlpic;
	}
	
	

}
