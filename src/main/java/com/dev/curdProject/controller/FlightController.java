package com.dev.curdProject.controller;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Positive;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
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
	public EntityModel<FlightDto> getFlight(@PathVariable(name = "id") @Positive Integer flightId)
	{
//		
//		logger.info("info flightId = "+flightId);
//		logger.debug("debug flightId = "+flightId);
//		logger.warn("warn flightId = "+flightId);
//		logger.error("error flightId = "+flightId);
//		logger.trace("trace flightId = "+flightId);
		
		Link link = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(FlightController.class).getFlight(flightId)).withSelfRel();
		FlightDto dto =  flightService.getFlight(flightId);
		dto.add(link);
		return EntityModel.of(dto);
	}
	
	@GetMapping(path = "/flights")
	public CollectionModel<FlightDto> getAllFlights()
	{
		List<FlightDto> list = flightService.getAllFlights();
		for(FlightDto dto : list)
		{
			Link link = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(FlightController.class).getFlight(dto.getId())).withSelfRel();
			dto.add(link);
		}
		Link link = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(FlightController.class).getAllFlights()).withSelfRel();

		return CollectionModel.of(list,link);
	}
	
	@PostMapping(path="/flight")
	public EntityModel<FlightDto> createFlight(@RequestBody @Valid FlightDto flightDto)
	{
		FlightDto dto =  flightService.createFlight(flightDto);
		Link link = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(FlightController.class).getFlight(dto.getId())).withSelfRel();
		
		dto.add(link);
		return EntityModel.of(dto);
	}
	
	@PutMapping(path="/flight")
	public EntityModel<FlightDto> updateFlight(@RequestBody FlightDto flightDto)
	{
		FlightDto dto =  flightService.updateFlight(flightDto);
		Link link = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(FlightController.class).getFlight(dto.getId())).withSelfRel();
		
		dto.add(link);
		return EntityModel.of(dto);
	
	}
	
	@DeleteMapping(path = "/flight/delete/{id}")
	public void deleteFlight(@PathVariable(name = "id") Integer flightid)
	{
		flightService.deleteFlight(flightid);
	}
	
	

}
