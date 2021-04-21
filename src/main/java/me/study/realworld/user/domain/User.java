package me.study.realworld.user.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class User {
    @Id
    @GeneratedValue
    private Long id;

    private String email;

    private String token;

    private String username;

    private String bio;

    private String image;
}
