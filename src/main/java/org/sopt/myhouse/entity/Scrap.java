package org.sopt.myhouse.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
public class Scrap {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn (name =  "POST_ID")
    private Post post_id;

    @OneToOne
    @JoinColumn (name =  "IMAGE_ID")
    private Image image_id;

    @OneToOne
    @JoinColumn (name =  "PRODUCT_ID")
    private Product product_id;

    @ManyToOne( fetch = FetchType.LAZY)
    @JoinColumn (name =  "FOLDER_ID")
    private Folder folder_id;

    private String image_url;

    private Scrap(Post post_id, Image image_id,Product product_id, Folder folder_id, String image_url){
        this.post_id = post_id;
        this.image_id = image_id;
        this.product_id = product_id;
        this.folder_id = folder_id;
        this.image_url = image_url;
    }
    public static Scrap newInstance(Post post_id, Image image_id,Product product_id, Folder folder_id, String image_url){
        return  new Scrap(post_id, image_id, product_id, folder_id,image_url);
    }
}
