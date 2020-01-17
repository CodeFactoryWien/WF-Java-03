package com.codefactory.team3.repositories;

import com.codefactory.team3.model.Bookingdate;
import org.springframework.data.repository.CrudRepository;

public interface DateRepository extends CrudRepository<Bookingdate, Integer> {
}
