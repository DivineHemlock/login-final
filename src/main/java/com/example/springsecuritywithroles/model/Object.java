package com.example.springsecuritywithroles.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "obj")
@Setter
@Getter
public class Object implements Serializable {
    @Id
    @Column(nullable = false)
    @GeneratedValue(generator = "hibernate-uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @NotNull
    private UUID id;

    @Column
    private String name;

    @Column
    private String lastName;

    @Column
    private Integer number;
}
