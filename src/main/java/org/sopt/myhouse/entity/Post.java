package org.sopt.myhouse.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
public class Post {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String thumbnail;
    private String title;
    private String post_category;
    private Date created_date;
    private Long like_count;
    private String hash_tag;
    private String option_tag;
    private Long scrap_count;
    private Long views_count;
    private Long comment_count;

}
