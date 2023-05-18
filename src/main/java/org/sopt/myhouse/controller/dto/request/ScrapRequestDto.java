package org.sopt.myhouse.controller.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.sopt.myhouse.service.dto.ScrapSaveServiceDto;

@Getter
@AllArgsConstructor
public class ScrapRequestDto {
    private Long post_id;
    private Long image_id;
    private Long product_id;
    private String image_url;

    public ScrapSaveServiceDto toServiceDto(){
        return ScrapSaveServiceDto.of(post_id, image_id, product_id, image_url);
    }
}
