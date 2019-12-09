package com.example.restaurant;

import com.example.restaurant.service.RestaurantService;
import com.example.restaurant.domain.Restaurant;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;


@SpringBootApplication
public class RestaurantApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestaurantApplication.class, args);
	}
	
	@Bean
	CommandLineRunner runner(RestaurantService restaurantService){
	    return args -> {
	    	ObjectMapper mapper = new ObjectMapper();
			TypeReference<List<Restaurant>> typeReference = new TypeReference<List<Restaurant>>(){};
			InputStream inputStream = TypeReference.class.getResourceAsStream("/json/restaurants.json");
			try {
				List<Restaurant> users = mapper.readValue(inputStream,typeReference);
				restaurantService.save(users);
				System.out.println("restaurants Saved!");
			} catch (IOException e){
				System.out.println("Unable to save restaurants: " + e.getMessage());
			}
	    };

}
}
