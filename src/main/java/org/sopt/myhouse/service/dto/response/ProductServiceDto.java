package org.sopt.myhouse.service.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ProductServiceDto {
    @Getter
    @AllArgsConstructor
    static public class ProductResponseDto {
        private String category;
        private String image_url;
        private String post_title;
        private double discount;
        private Long price;
        private double rate;
        private Long reviews_count;
        private int rank;
    }

}
