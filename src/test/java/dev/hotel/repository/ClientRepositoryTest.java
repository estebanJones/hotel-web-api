package dev.hotel.repository;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.mockito.Mockito;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import dev.hotel.controller.ClientController;
import dev.hotel.entite.Client;

@WebMvcTest(ClientController.class)
public class ClientRepositoryTest {
	@Autowired
	MockMvc mockMvc;
	
	@Autowired
	ClientRepository clientRepository;
	
	@BeforeEach
	public void init() {
		Client client = new Client();
		client.setNom("Joe");
		client.setPrenoms("Mercury");
		
		Client client2 = new Client();
		client2.setNom("Jones");
		client2.setPrenoms("Esteban");
		
		this.clientRepository = Mockito.mock(ClientRepository.class);
		Mockito.when(this.clientRepository.findAll(PageRequest.of(10, 20))).thenReturn(new PageImpl<>(Arrays.asList(client, client2)));
	}
	
	@Test
	public void testFindAll() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/clients"))
			   .andExpect(MockMvcResultMatchers.status().isOk())
			   .andExpect(MockMvcResultMatchers.jsonPath("[0].nom").value("Joe"))
			   .andExpect(MockMvcResultMatchers.jsonPath("[0].prenom").value("Mercury"))
			   .andExpect(MockMvcResultMatchers.jsonPath("[1].nom").value("Jones"))
			   .andExpect(MockMvcResultMatchers.jsonPath("[1].prenom").value("Esteban"));
	}
}
