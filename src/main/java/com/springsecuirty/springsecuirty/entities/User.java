package com.springsecuirty.springsecuirty.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String username;

    private String password;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "users_authorties", joinColumns =
    @JoinColumn (name = "user_id") ,
            inverseJoinColumns = @JoinColumn(name = "authority_id"))
    private Set<Autority> authorites ;


}
