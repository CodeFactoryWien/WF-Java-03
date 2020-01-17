package com.codefactory.team3.repositories;

import com.codefactory.team3.model.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository <Category, Integer> {
}
