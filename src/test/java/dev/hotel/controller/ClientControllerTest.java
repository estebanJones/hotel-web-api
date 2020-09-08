package dev.hotel.controller;

import java.util.Arrays;
import java.util.Optional;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import dev.hotel.entite.Client;
import dev.hotel.service.ClientService;


@WebMvcTest(ClientController.class)
public class ClientControllerTest {
	
	@MockBean
	ClientService service;
	@Autowired
	MockMvc mockMvc;

	
	@Test
	public void testListerClients() throws Exception {
		Client client = new Client("Esteban", "Jones");
		Client client2 = new Client("Sylver", "Alfred");

		Mockito.when(this.service.listerClient(0, 2)).thenReturn(Arrays.asList(client, client2));

		mockMvc.perform(MockMvcRequestBuilders.get("/clients?start=0&size=2"))
											  .andExpect(MockMvcResultMatchers.status().isOk())
											  .andExpect(MockMvcResultMatchers.jsonPath("[0].nom").value("Esteban"))
											  .andExpect(MockMvcResultMatchers.jsonPath("[0].prenoms").value("Jones"))
											  .andExpect(MockMvcResultMatchers.jsonPath("[1].nom").value("Sylver"))
											  .andExpect(MockMvcResultMatchers.jsonPath("[1].prenoms").value("Alfred"));

	}
	

	public void testGetClient() throws Exception {
		Client client = new Client();
		UUID uuid = UUID.randomUUID();
		client.setUuid(uuid);
		client.setNom("Joe");
		client.setPrenoms("Mercury");
		
		Mockito.when(this.service.getClientById(uuid)).thenReturn(Optional.of(client));
		
		mockMvc.perform(MockMvcRequestBuilders.get("/client/{idClient}", uuid))
			   .andExpect(MockMvcResultMatchers.status().isOk())
			   .andExpect(MockMvcResultMatchers.jsonPath("$.nom").value("Joe"))
			   .andExpect(MockMvcResultMatchers.jsonPath("$.prenom").value("Mercury"));
	}
}
