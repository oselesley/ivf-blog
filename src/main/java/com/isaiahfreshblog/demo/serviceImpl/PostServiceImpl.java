package com.isaiahfreshblog.demo.serviceImpl;

import com.isaiahfreshblog.demo.models.Post;
import com.isaiahfreshblog.demo.repositories.PostRepository;
import com.isaiahfreshblog.demo.services.PostService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

@Service
public class PostServiceImpl implements PostService {
    PostRepository postRepository;

    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public Post createPost(Post post) {
        return postRepository.save(post);
    }

    @Override
    public Stack<Post> getPostsByUserId(Long id) {
        Stack<Post> posts = new Stack<>();
        postRepository.findPostByUserId(id).forEach(posts::push);
        System.out.println(posts);
        return posts;
    }

    @Override
    public Stack<Post> getPosts() {
        Stack<Post> posts = new Stack<>();
        postRepository.findAll().forEach(posts::push);
        return posts;
    }

    @Override
    public Post editPost(Post post) {
        return null;
    }

    @Override
    public boolean deletePostById(Long id) {
        Post post = postRepository.findById(id).orElse(null);
        if (post == null) return false;
        postRepository.delete(post);
        return true;
    }
}
