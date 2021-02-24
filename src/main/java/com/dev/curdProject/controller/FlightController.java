package com.dev.curdProject.controller;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Positive;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
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
@Validated //it is used for enable path variable validation
public class FlightController 
{
	
//	private static Logger logger = LogManager.getLogger(FlightController.class);
	
	@Autowired
	IFlightService flightService;
	
	@GetMapping(path = "/flight/{id}")
	public FlightDto getFlight(@PathVariable(name = "id") @Positive Integer flightId)
	{
//		
//		logger.info("info flightId = "+flightId);
//		logger.debug("debug flightId = "+flightId);
//		logger.warn("warn flightId = "+flightId);
//		logger.error("error flightId = "+flightId);
//		logger.trace("trace flightId = "+flightId);
		return flightService.getFlight(flightId);
	}
	
	@GetMapping(path = "/flights")
	public List<FlightDto> getAllFlights()
	{
		return flightService.getAllFlights();
	}
	
	@PostMapping(path="/flight")
	public FlightDto createFlight(@RequestBody @Valid FlightDto flightDto)
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
