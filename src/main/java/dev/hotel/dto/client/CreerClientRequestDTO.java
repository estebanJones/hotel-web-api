package dev.hotel.dto.client;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import dev.hotel.entite.BaseEntite;
import dev.hotel.entite.Client;

public class CreerClientRequestDTO extends BaseEntite{
	@NotBlank
	@Size(min = 3)
	private String nom;
	@NotBlank
	@Size(min = 3)
	private String prenom;
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
}
