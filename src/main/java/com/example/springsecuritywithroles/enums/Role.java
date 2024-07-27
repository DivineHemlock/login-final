package com.example.springsecuritywithroles.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Getter
@AllArgsConstructor
public enum Role {
    READ(Collections.singletonList("READ")),
    WRITE(Collections.singletonList("WRITE")),
    PATCH(Collections.singletonList("PATCH")),
    DELETE(Collections.singletonList("DELETE")),
    ADMIN(Arrays.asList("READ", "WRITE", "PATCH", "DELETE"));

    private final List<String> authorities;

}
