package com.dev.curdProject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dev.curdProject.dto.FlightDto;
import com.dev.curdProject.service.IFlightService;

@RestController
public class FlightController 
{
	
	@Autowired
	IFlightService flightService;
	
	@GetMapping(path = "/flight/{id}")
	public FlightDto getFlight(@PathVariable(name = "id") Integer flightId)
	{
		return flightService.getFlight(flightId);
	}
	
	@GetMapping(path = "/flights")
	public List<FlightDto> getAllFlights()
	{
		return flightService.getAllFlights();
	}
	
	@PostMapping(path="/flight")
	public FlightDto createFlight(@RequestBody FlightDto flightDto)
	{
		
		return flightService.createFlight(flightDto);
	}
	
	@PutMapping(path="/flight")
	public FlightDto updateFlight(@RequestBody FlightDto flightDto)
	{
		
		return flightService.updateFlight(flightDto);
	}
	
	@DeleteMapping(path = "/flight/delete/{id}")
	public void deleteFlight(@PathVariable(name = "id") Integer flightid)
	{
		flightService.deleteFlight(flightid);
	}
	
	

}
