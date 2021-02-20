package com.dev.curdProject.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dev.curdProject.entity.Flight;
@Repository
public interface IFlightRepository extends CrudRepository<Flight, Integer> {

}
