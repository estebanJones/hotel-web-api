package dev.hotel.controller;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.hotel.dto.client.ClientResponseRequestDTO;
import dev.hotel.dto.client.CreerClientRequestDTO;
import dev.hotel.entite.Client;
import dev.hotel.service.ClientService;

@RestController
@RequestMapping("/application")
public class ClientController {
	@Autowired
	ClientService clientService;
	
	@GetMapping("/clients/{start}/{size}")
	public List<Client> returnList(@PathVariable int start, @PathVariable int size) {
		return this.clientService.listerClient(start, size);
	}
	
	@GetMapping("/client/{idClient}")
	public ResponseEntity<?> getClient(@PathVariable UUID idClient) {
		Optional<Client> client = this.clientService.getClientById(idClient);
		
		if(client.isPresent()) {
			return ResponseEntity.status(HttpStatus.OK).body(client);
		} else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Veuillez entrer un autre ID CLIENT");
		}
	}
	
	@PostMapping("/register")
	public ResponseEntity<?> register(@RequestBody @Valid CreerClientRequestDTO clientDTO, BindingResult resultatValidation) {
		if(resultatValidation.hasErrors()) {
			return ResponseEntity.badRequest().body("Erreur");
		} else {
			return ResponseEntity.ok(new ClientResponseRequestDTO(ClientService.creerNouveauClient(clientDTO.getNom(), clientDTO.getPrenom())));
		}
	}
}
