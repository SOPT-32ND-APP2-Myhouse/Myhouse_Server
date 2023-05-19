package org.sopt.myhouse.repository;


import org.sopt.myhouse.entity.Image;
import org.sopt.myhouse.entity.Post;
import org.sopt.myhouse.entity.Product;
import org.sopt.myhouse.entity.Scrap;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface ScrapRepository extends Repository<Scrap, Long> {
    Scrap save(Scrap scrap);

    Optional<Long> findById(Long scrap_id);
    Long deleteById(Long scrap_id);

    // 엔티티 변수명 바꿔야댐
    @Query("select s from Scrap s group by s.folder.id, s.id")
    ArrayList<Scrap> getAllScrap();

    List<Scrap> findAll();

}
