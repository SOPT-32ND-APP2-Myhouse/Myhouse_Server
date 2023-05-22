package org.sopt.myhouse.repository;

import org.sopt.myhouse.entity.Post;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import java.util.*;

public interface PostRepository extends Repository<Post, Long> {
    Optional<Post> findById(Long post_id);


    @Query("select p from Post p where (p.comment_count + p.like_count + p.scrap_count + p.views_count) = " +
            "(select max(p.comment_count + p.like_count + p.scrap_count + p.views_count) from Post p)")
    Optional<Post> recommendPost();

    @Query("select p from Post p")
    Optional<List<Post>> getAll();

    @Query("select p from Post p order by p.comment_count + p.like_count + p.views_count ")
    Optional<List<Post>> getPostByRank();

}
