package com.dev.curdProject.service;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.dev.curdProject.dto.FlightDto;
import com.dev.curdProject.entity.Flight;
import com.dev.curdProject.repository.IFlightRepository;


@Service
public class FlightService implements IFlightService {

	@Autowired
	IFlightRepository flightRepo;
	
	@Override
	public FlightDto createFlight(FlightDto flightDto) {
		
		Flight flight = new Flight();
		BeanUtils.copyProperties(flightDto, flight);
		flight = flightRepo.save(flight);
		BeanUtils.copyProperties(flight, flightDto);
		return flightDto;
	}

	@Override
	public FlightDto getFlight(Integer flightId) {
		Optional<Flight> flight = flightRepo.findById(flightId);
		FlightDto dto = null;
		if(flight.isPresent())
		{
			dto = new FlightDto();
			BeanUtils.copyProperties(flight.get(), dto);
		}
		else
		{
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Flight Not Found");
		}
		return dto;
	}

	@Override
	public FlightDto updateFlight(FlightDto flightDto) {
		
		Optional<Flight> flightOpt = flightRepo.findById(flightDto.getId());
		
		if(flightOpt.isPresent())
		{
			Flight flight = new Flight();
			BeanUtils.copyProperties(flightDto, flight);
			flight = flightRepo.save(flight);
			BeanUtils.copyProperties(flight, flightDto);
		}
		else
		{
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Flight Not Found");
		}
		
		return flightDto;
	}

	@Override
	public void deleteFlight(Integer flightId) {
		
		Optional<Flight> flightOpt = flightRepo.findById(flightId);
		
		if(flightOpt.isPresent())
		{
		
			flightRepo.deleteById(flightId);
		}
		else
		{
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Flight Not Found"); 
		}	
		
	}

	@Override
	public List<FlightDto> getAllFlights() {
		Iterable<Flight> iterable = flightRepo.findAll();
		
		List<FlightDto> flights = StreamSupport.stream(iterable.spliterator(), false).map(flight -> {
			FlightDto dto = new FlightDto();
			BeanUtils.copyProperties(flight, dto);
			return dto;
		}).collect(Collectors.toList());
		
		return flights;
	}

}
