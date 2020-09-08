package dev.hotel.dto.reservation;

import java.time.LocalDate;
import java.util.List;

import javax.validation.constraints.NotBlank;

import dev.hotel.entite.BaseEntite;

public class CreerReservationRequestDTO extends BaseEntite{
	 @NotBlank
	 private LocalDate dateDebut;
	 @NotBlank
	 private LocalDate dateFin;
	 @NotBlank
	 private List<String> chambres;
	 
	public LocalDate getDateDebut() {
		return dateDebut;
	}
	public void setDateDebut(LocalDate dateDebut) {
		this.dateDebut = dateDebut;
	}
	public LocalDate getDateFin() {
		return dateFin;
	}
	public void setDateFin(LocalDate dateFin) {
		this.dateFin = dateFin;
	}
	public List<String> getChambres() {
		return chambres;
	}
	public void setChambres(List<String> chambres) {
		this.chambres = chambres;
	}
	 
	
}
