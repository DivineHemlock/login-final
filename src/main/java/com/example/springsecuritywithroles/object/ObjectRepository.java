package com.example.springsecuritywithroles.object;

import com.example.springsecuritywithroles.model.Object;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ObjectRepository extends JpaRepository<Object, UUID> {
}
