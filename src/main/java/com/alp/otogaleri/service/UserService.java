package com.alp.otogaleri.service;

import com.alp.otogaleri.model.User;
import com.alp.otogaleri.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<User> findById(long id) {
        return userRepository.findById(id);
    }

    public User findByUserName(String name){
        return userRepository.findByUsername(name);
    }

    @Transactional
    public void delete(User user){
        userRepository.delete(user);
    }

    @Transactional
    public User edit(User user, Long id) {
        User editedUser = findById(id).orElseGet(User ::new);
        editedUser.setName(user.getName());
        editedUser.setLastName(user.getLastName());
        editedUser.setPassword(user.getPassword());
        return save(editedUser);
    }

    @Transactional
    public User save(User user) {
        return userRepository.save(user);
    }

    public List<User> findAll(){
        return (List<User>) userRepository.findAll();
    }

    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
