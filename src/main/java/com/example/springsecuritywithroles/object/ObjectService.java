package com.example.springsecuritywithroles.object;

import com.example.springsecuritywithroles.model.Object;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ObjectService {
    private final ObjectRepository repository;

    public ObjectService(ObjectRepository repository) {
        this.repository = repository;
    }

    public Object save(Object object) {
        return repository.save(object);
    }

    public Object getOne(UUID uuid) {
        return repository.findById(uuid).get();
    }
}
