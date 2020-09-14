package dev.hotel.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import dev.hotel.entite.Client;
import dev.hotel.repository.ClientRepository;

@Service
public class ClientService {
	@Autowired
	static ClientRepository clientRepo;

	public List<Client> listerClient(int start, int size) {
		Pageable page = PageRequest.of(start, size);
        return clientRepo.findAll(page).toList();
	}
	
	public Optional<Client> getClientById(UUID idClient) {
		return clientRepo.findById(idClient);
	}
	
	@Transactional
	public static Client creerNouveauClient(String nom, String prenom) {
		return clientRepo.save(new Client(nom, prenom));
	}
}
