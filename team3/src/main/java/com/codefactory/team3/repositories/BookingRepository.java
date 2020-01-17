package com.codefactory.team3.repositories;

import com.codefactory.team3.model.Booking;
import org.springframework.data.repository.CrudRepository;

import javax.persistence.criteria.CriteriaBuilder;

public interface BookingRepository extends CrudRepository<Booking, Integer> {
}
