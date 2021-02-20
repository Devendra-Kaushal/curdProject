package com.dev.curdProject.service;

import java.util.List;

import com.dev.curdProject.dto.FlightDto;

public interface IFlightService {
	
	public FlightDto createFlight(FlightDto flightDto);

	public FlightDto getFlight(Integer flightId);

	public FlightDto updateFlight(FlightDto flightDto);

	public void deleteFlight(Integer flightid);

	public List<FlightDto> getAllFlights();

}
