package org.sopt.myhouse.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
public class Image {

    @Id @GeneratedValue
    private Long id;

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "POST_ID")
    private Post post;
    private String comment;
    private String image_url;
}
