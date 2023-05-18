package org.sopt.myhouse.repository;

import org.sopt.myhouse.entity.Post;
import org.springframework.data.repository.Repository;

public interface PostRepository extends Repository<Post, Long> {
    Post findById(Long post_id);
}
