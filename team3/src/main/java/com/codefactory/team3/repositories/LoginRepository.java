package com.codefactory.team3.repositories;

import com.codefactory.team3.model.Login;
import org.springframework.data.repository.CrudRepository;

public interface LoginRepository extends CrudRepository<Login, Integer> {
}
