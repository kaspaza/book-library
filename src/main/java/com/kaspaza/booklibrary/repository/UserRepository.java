package com.kaspaza.booklibrary.repository;

import com.kaspaza.booklibrary.domain.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {
}
