package com.isaiahfreshblog.demo.models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String commentContent;

    @ManyToOne
    private User user;
    @ManyToOne
    private Post post;
}
