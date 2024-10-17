package com.ITMentor.SpringBoot.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "users")
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String lastName;

    public User (String username, String email, String lastName) {
        this.name = username;
        this.email = email;
        this.lastName = lastName;
    }
}