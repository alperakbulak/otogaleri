package com.alp.otogaleri;

import com.alp.otogaleri.model.User;
import com.alp.otogaleri.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OtogaleriApplication implements CommandLineRunner {

    UserRepository userRepository;

    @Autowired
    public OtogaleriApplication(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(OtogaleriApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        User user1 = new User("alper", "Dd123456");
        user1.setName("Alper");
        user1.setLastName("AKBULAK");

        userRepository.save(user1);
    }
}
