package org.sopt.myhouse.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
public class Product {
    @Id @GeneratedValue
    private Long id;

    private String catetory;
    private String image_url;
    private String brand;
    private String post_title;
    private Long discount;
    private String title;
    private Long price;

}
