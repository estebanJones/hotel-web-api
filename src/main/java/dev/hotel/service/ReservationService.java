package dev.hotel.service;

import java.time.LocalDate;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.hotel.entite.Chambre;
import dev.hotel.entite.Client;
import dev.hotel.entite.Reservation;
import dev.hotel.repository.ReservationRepository;

@Service
public class ReservationService {
	@Autowired
	ReservationRepository repo;
	@Autowired
	static ClientService service;
	
	@Transactional
	public Reservation creerReservation(LocalDate dateDebut, LocalDate dateFin, Client client, List<Chambre> chambres) {
		return this.repo.save(new Reservation(dateDebut, dateFin, client, chambres));
	}
}
