package com.alp.otogaleri.repository;

import com.alp.otogaleri.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
    User findByUsername(String username);
}
