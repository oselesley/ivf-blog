package com.isaiahfreshblog.demo.models;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String tagContent;

    @ManyToMany
    List<Post> posts = new ArrayList<>();
}
