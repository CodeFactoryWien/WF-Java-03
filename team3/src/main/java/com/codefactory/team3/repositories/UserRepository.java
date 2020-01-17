package com.codefactory.team3.repositories;

import com.codefactory.team3.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Integer> {
}
