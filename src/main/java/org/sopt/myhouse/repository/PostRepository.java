package org.sopt.myhouse.repository;

import org.sopt.myhouse.entity.Post;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import java.util.Optional;

public interface PostRepository extends Repository<Post, Long> {
    Post findById(Long post_id);


    @Query("select p from Post p where (p.comment_count + p.like_count + p.scrap_count + p.views_count) = " +
            "(select max(p.comment_count + p.like_count + p.scrap_count + p.views_count) from Post p)")
    Post recommendPost();
}
