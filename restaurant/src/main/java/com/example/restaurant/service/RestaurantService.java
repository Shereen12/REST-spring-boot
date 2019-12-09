package com.example.restaurant.service;

import org.springframework.stereotype.Service;

import com.example.restaurant.domain.Restaurant;


import java.util.ArrayList;
import java.util.List;


@Service
public class RestaurantService {

  
	
	private List<Restaurant> restaurants;
	private List<Restaurant> openRestaurants;

   public RestaurantService() {
        this.openRestaurants = new ArrayList<Restaurant>(); 
        this.restaurants = new ArrayList<Restaurant>();
    }

    public List<Restaurant> list() {
    	return this.restaurants;
  
    
        
    }
    
   
    
    public List<Restaurant> openRestaurants(boolean value){
    	for(int i = 0 ; i<restaurants.size() ; i++) {
    		if(restaurants.get(i).IsClosed()==value)
    			openRestaurants.add(restaurants.get(i));
    	}
    	return openRestaurants;
    }

    public void save(List<Restaurant> restaurants) {
    
    	this.restaurants=restaurants;
    }

	public Restaurant add(Restaurant newRestaurant) {
		
		// TODO Auto-generated method stub
		
		this.restaurants.add(newRestaurant);
		return newRestaurant;
	}
	
	public Restaurant last() {
		return restaurants.get(restaurants.size()-1);
	}

	public boolean update(String uuid, Restaurant updatedRestaurant) {
		// TODO Auto-generated method stub
		for (int i = 0 ; i<restaurants.size();i++)
		{
			if(restaurants.get(i).getId()==uuid)
			{
				restaurants.set(i, updatedRestaurant);
				return true;
			}
		}
		return false;
		
	}
}
