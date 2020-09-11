package com.isaiahfreshblog.demo.models;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String userName;
    private String email;
    private String password;

    @OneToMany(mappedBy = "user")
    List<Post> posts = new ArrayList<>();
    @OneToMany(mappedBy = "user")
    List<Comment> comments = new ArrayList<>();
    @OneToMany(mappedBy = "user")
    List<Like> likes = new ArrayList<>();

}
