package com.isaiahfreshblog.demo.services;

import com.isaiahfreshblog.demo.models.Post;
import com.isaiahfreshblog.demo.models.User;

import java.util.List;
import java.util.Stack;

public interface PostService {
    Post createPost (Post post);
    Stack<Post> getPostsByUserId (Long id);
    Post editPost (Post post);
    Stack<Post> getPosts ();
    boolean deletePostById (Long id);
}
