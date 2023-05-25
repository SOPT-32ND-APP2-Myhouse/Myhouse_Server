package org.sopt.myhouse.service.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.sopt.myhouse.entity.Image;


public class ImageServiceDto {


    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class ImageDetailDto{
        private Long image_id;
        private String image_url;
        private String content;

        public ImageDetailDto(Image image) {
            this.image_id = image.getId();
            this.image_url = image.getImageUrl();
            this.content = image.getComment();
        }
    }

}
