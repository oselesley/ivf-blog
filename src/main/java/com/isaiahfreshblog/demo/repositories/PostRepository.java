package com.isaiahfreshblog.demo.repositories;

import com.isaiahfreshblog.demo.models.Post;
import com.isaiahfreshblog.demo.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    Iterable<Post> findPostByUser (User user);
    Iterable<Post> findPostByUserId (Long id);
}
