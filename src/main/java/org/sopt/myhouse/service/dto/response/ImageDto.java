package org.sopt.myhouse.service.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.sopt.myhouse.entity.Image;

@Getter
@AllArgsConstructor
public class ImageDto {
    private Long image_id;
    private String image_url;
    private String content;

    public ImageDto(Image image) {
        this.image_id = image.getId();
        this.image_url = image.getImageUrl();
        this.content = image.getComment();
    }
}
