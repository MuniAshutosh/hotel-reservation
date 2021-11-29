package com.accenture.hotelreservation;

import java.io.IOException;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class AdminControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void shouldReturnDefaultMessage() throws Exception {
		this.mockMvc.perform(get("/abc-hotel/v1/admin/test/")).andExpect(status().isOk());
	}
	
	/*
	 This is to test if the admin can see all the rooms with its booking details
	 "rooms" : [
	 	{
	 		"id": 1,
	 		"price": 125.00,
	 		"bookings" :[
	 			{
	 				"startDate":"2021-11-28"
	 				"endDate":"2021-11-29"
	 				"guest": {
	 					"id":1
	 					"fullname":"Ashutosh"
	 				}
	 			
	 			},
	 			{
	 				"startDate":"2021-11-29"
	 				"endDate":"2021-11-30"
	 				"guest": {
	 					"id":2
	 					"fullname":"Aditya"
	 				}
	 			
	 			},
	 			
	 		
	 		]
	 	},
	 	{
	 		"id": 2,
	 		"price": 250.00,
	 		"bookings" :[
	 			{
	 				"startDate":"2021-11-28"
	 				"endDate":"2021-11-29"
	 				"guest": {
	 					
	 					"fullname":"Ashutosh"
	 				}
	 			
	 			}
	 		
	 		]
	 	},
	 	{
	 		"id": 3,
	 		"price": 500.00,
	 		"bookings" :[]
	 	},
	 ]
	 	
	 */
	@Test
	void shouldReturnRoomsWithAllBookingDetails() {
		
		
		
		
	}

}
