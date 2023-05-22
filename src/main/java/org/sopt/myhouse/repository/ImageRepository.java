package org.sopt.myhouse.repository;

import org.sopt.myhouse.entity.Image;
import org.springframework.data.repository.Repository;

import java.util.ArrayList;
import java.util.*;


public interface ImageRepository extends Repository<Image, Long> {
    Optional<List<Image>> findByImageUrl(String image_url);

    ArrayList<Image> findByPostId(Long id);
}
