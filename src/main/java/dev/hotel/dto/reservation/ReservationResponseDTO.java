package dev.hotel.dto.reservation;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import javax.validation.constraints.NotBlank;

import dev.hotel.entite.BaseEntite;
import dev.hotel.entite.Chambre;
import dev.hotel.entite.Reservation;

public class ReservationResponseDTO extends BaseEntite{
	 @NotBlank
	 private LocalDate dateDebut;
	 @NotBlank
	 private LocalDate dateFin;
	 @NotBlank
	 private UUID clientId;
	 @NotBlank
	 private List<String> chambres;
	 
	 public ReservationResponseDTO(Reservation reservation) {
		this.dateDebut = reservation.getDateDebut();
		this.dateFin = reservation.getDateFin();
		this.clientId = reservation.getClient().getUuid();
		
		for(Chambre chambre : reservation.getChambres()) {
			chambres.add(chambre.getUuid().toString());
		}
	}
}
