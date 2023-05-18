package org.sopt.myhouse.controller.dto.response;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.sopt.myhouse.entity.Post;



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
}
