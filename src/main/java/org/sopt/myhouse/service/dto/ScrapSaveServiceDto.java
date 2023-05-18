package org.sopt.myhouse.service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ScrapSaveServiceDto {
    private Long post_id;
    private Long image_id;
    private Long product_id;
    private String image_url;

    public static ScrapSaveServiceDto of(Long post_id, Long image_id, Long product_id, String image_url){
        return new ScrapSaveServiceDto(post_id, image_id, product_id, image_url);
    }
}
