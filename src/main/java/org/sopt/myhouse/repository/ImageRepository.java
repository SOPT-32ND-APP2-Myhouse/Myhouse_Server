package org.sopt.myhouse.repository;

import org.sopt.myhouse.entity.Image;
import org.springframework.data.repository.Repository;

import java.util.ArrayList;


public interface ImageRepository extends Repository<Image, Long> {
    Image findById(Long id);

    ArrayList<Image> findByPostId(Long id);
}
