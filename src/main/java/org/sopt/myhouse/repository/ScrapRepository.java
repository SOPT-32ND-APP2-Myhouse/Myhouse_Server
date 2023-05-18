package org.sopt.myhouse.repository;


import org.sopt.myhouse.entity.Image;
import org.sopt.myhouse.entity.Post;
import org.sopt.myhouse.entity.Product;
import org.sopt.myhouse.entity.Scrap;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.Repository;

public interface ScrapRepository extends Repository<Scrap, Long> {
    Scrap save(Scrap scrap);

}
