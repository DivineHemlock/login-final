package com.example.springsecuritywithroles.model;

import com.example.springsecuritywithroles.enums.Role;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "usr")
@Setter
@Getter
public class User implements Serializable {
    @Id
    @Column
    @GeneratedValue(generator = "hibernate-uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private UUID id;

    @Column
    @NotNull
    private String username;

    @Column
    @NotNull
    private String password;

    @Column
    @Enumerated(value = EnumType.STRING)
    private Role role;
}
