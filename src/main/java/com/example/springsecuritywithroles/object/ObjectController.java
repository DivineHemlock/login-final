package com.example.springsecuritywithroles.object;

import com.example.springsecuritywithroles.model.Object;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/security")
//@CrossOrigin("*")
public class ObjectController {
    private final ObjectService service;

    public ObjectController(ObjectService service) {
        this.service = service;
    }

    @PreAuthorize("hasAuthority('WRITE')")
    @PostMapping("/post")
    public ResponseEntity<Object> save(@RequestBody Object object) {
        return new ResponseEntity<>(service.save(object), HttpStatus.CREATED);
    }

    @PreAuthorize("hasAuthority('READ')")
    @GetMapping("/get/{id}")
    public ResponseEntity<Object> getOne(@PathVariable("id")UUID id) {
        return new ResponseEntity<>(service.getOne(id), HttpStatus.OK);
    }
}
