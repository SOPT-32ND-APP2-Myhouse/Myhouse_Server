package org.sopt.myhouse.repository;

import org.sopt.myhouse.entity.Image;
import org.springframework.data.repository.Repository;


public interface ImageRepository extends Repository<Image, Long> {
    Image findById(Long id);
}
