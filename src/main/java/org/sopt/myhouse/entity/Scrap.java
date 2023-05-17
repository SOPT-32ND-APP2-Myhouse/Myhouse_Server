package org.sopt.myhouse.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
public class Scrap {
    @Id @GeneratedValue
    private Long scrap_id;

    @OneToOne
    @JoinColumn (name =  "POST_ID")
    private Post post_id;

    @OneToOne
    @JoinColumn (name =  "IMAGE_ID")
    private Image image;

    @OneToOne
    @JoinColumn (name =  "PRODUCT_ID")
    private Product product_id;

    @ManyToOne( fetch = FetchType.LAZY)
    @JoinColumn (name =  "FOLDER_ID")
    private Folder folder_id;

    private String image_url;
}
