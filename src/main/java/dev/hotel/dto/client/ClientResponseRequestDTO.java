package dev.hotel.dto.client;

import dev.hotel.entite.BaseEntite;
import dev.hotel.entite.Client;

public class ClientResponseRequestDTO extends BaseEntite {
	private String nom;
	private String prenom;
	
	public ClientResponseRequestDTO(Client client) {
		super();
		this.nom = client.getNom();
		this.prenom = client.getPrenom();
	}

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
