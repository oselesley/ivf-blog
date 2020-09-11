package com.isaiahfreshblog.demo.models;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String postContent;
    private Date dateCreated;
    private Date dateModified;

    @ManyToOne
    private User user;

    @OneToMany(mappedBy = "post")
    List<Comment> comments = new ArrayList<>();
    @OneToMany(mappedBy = "post")
    List<Like> likes = new ArrayList<>();
    @ManyToMany(mappedBy = "posts")
    List<Tag> tags = new ArrayList<>();
}
