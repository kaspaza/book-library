package com.kaspaza.booklibrary.repository;

import com.kaspaza.booklibrary.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
