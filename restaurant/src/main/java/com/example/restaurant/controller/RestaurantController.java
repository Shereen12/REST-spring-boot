package com.example.restaurant.controller;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.restaurant.domain.Restaurant;
import com.example.restaurant.service.RestaurantService;





@RestController
@RequestMapping("/api")
public class RestaurantController {

    private RestaurantService restaurantService;

    public RestaurantController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }
    
    @RequestMapping(value="restaurants", produces = MediaType.APPLICATION_JSON_VALUE,  method = RequestMethod.GET)
    public @ResponseBody  List<Restaurant> listOpenRestaurants(@RequestParam("closed") boolean value) {
        return restaurantService.openRestaurants(value);
     } 
  @RequestMapping(value="restaurant", produces = MediaType.APPLICATION_JSON_VALUE,  method = RequestMethod.GET)
   public  List<Restaurant> list() {
       return restaurantService.list();
    }
    
  @PostMapping(value="restaurant")
   
    public  ResponseEntity<Restaurant> add(@RequestBody Restaurant newRestaurant) {
	  restaurantService.add(newRestaurant);
	  if(restaurantService.last() == newRestaurant) {
        	return new ResponseEntity<Restaurant> (newRestaurant, HttpStatus.OK);
        }
        else return new ResponseEntity<Restaurant> (HttpStatus.I_AM_A_TEAPOT);
     }
    
   @PutMapping("restaurant/{uuid}")
   public ResponseEntity<Restaurant>update(@PathVariable(value="uuid") String uuid, @RequestBody Restaurant updatedRestaurant) {
	   
	   
	   
		  if(restaurantService.update(uuid, updatedRestaurant) == true) {
	        	return new ResponseEntity<Restaurant> (updatedRestaurant, HttpStatus.OK);
	        }
	        else return new ResponseEntity<Restaurant> (HttpStatus.I_AM_A_TEAPOT);
	     }
   
   

}
