package com.sabancidx.otogaleri.repository;

import com.sabancidx.otogaleri.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
    User findByUsername(String username);
}
