package org.sopt.myhouse.controller.dto.response;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.util.*;
import org.sopt.myhouse.service.dto.response.PostPopularResponseDto;
import org.sopt.myhouse.service.dto.response.ProductResponseDto;


public class HomeDto {



    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    static public class RecommendDto {
        private String tag;
        private String user_name ;
        private Long post_id;
        private String image_url;
        private String title;
    }

    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    static public class HomeRecommendRes{
        private RecommendDto post;
    }


    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    static public class PostPopularDto{
        private List<PostPopularResponseDto> postPopularResponseDto;
    }

    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    static public class ProductPopularDto{
        private List<ProductResponseDto> productResponseDto;
    }
}
