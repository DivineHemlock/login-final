package com.example.springsecuritywithroles;

import com.example.springsecuritywithroles.enums.Role;
import com.example.springsecuritywithroles.model.User;
import com.example.springsecuritywithroles.user.UserRepository;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class CommandLineRunner implements org.springframework.boot.CommandLineRunner {
    private final UserRepository repository;

    public CommandLineRunner(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(String... args) throws Exception {
        User writer = new User();
        writer.setUsername("writer");
        writer.setPassword("{noop}1234");
        writer.setRole(Role.WRITE);
        User reader = new User();
        reader.setUsername("reader");
        reader.setPassword("{bcrypt}$2a$12$INxoGDBDZp2vlEz1GwTOyuJGL74jx010FXpF9p2shRpaX/PNdt.5i");
        reader.setRole(Role.READ);
        User patcher = new User();
        patcher.setUsername("patcher");
        patcher.setPassword("{bcrypt}$2a$12$INxoGDBDZp2vlEz1GwTOyuJGL74jx010FXpF9p2shRpaX/PNdt.5i");
        patcher.setRole(Role.PATCH);
        User deleter = new User();
        deleter.setUsername("deleter");
        deleter.setPassword("{bcrypt}$2a$12$INxoGDBDZp2vlEz1GwTOyuJGL74jx010FXpF9p2shRpaX/PNdt.5i");
        deleter.setRole(Role.DELETE);
        User admin = new User();
        admin.setUsername("admin");
        admin.setPassword("{bcrypt}$2a$12$INxoGDBDZp2vlEz1GwTOyuJGL74jx010FXpF9p2shRpaX/PNdt.5i");
        admin.setRole(Role.ADMIN);
//        repository.saveAll(Arrays.asList(admin, deleter, patcher, reader, writer));
    }
}
