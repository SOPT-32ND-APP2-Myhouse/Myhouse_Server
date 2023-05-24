package org.sopt.myhouse.controller;

import lombok.RequiredArgsConstructor;
import org.sopt.myhouse.common.advice.dto.ApiResponseDto;
import org.sopt.myhouse.controller.dto.response.HomeDto;
import org.sopt.myhouse.entity.Post;
import org.sopt.myhouse.exception.ErrorStatus;
import org.sopt.myhouse.exception.SuccessStatus;
import org.sopt.myhouse.exception.model.NotImageFoundException;
import org.sopt.myhouse.exception.model.NotPostFoundException;
import org.sopt.myhouse.service.PostService;
import org.sopt.myhouse.service.ProductService;
import org.sopt.myhouse.service.dto.response.ProductResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/home")
public class HomeController {

    @Autowired
    private final PostService postService;

    @Autowired
    private final ProductService productService;


    @GetMapping("/post/recommend")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ApiResponseDto getRecommendPost() throws NotPostFoundException {
        Post post = postService.recommendPost();
        HomeDto.RecommendDto recommendDto = new HomeDto.RecommendDto(post.getPost_category(),"nickname", post.getId(), post.getThumbnail(), post.getTitle());
        HomeDto.HomeRecommendRes response = new HomeDto.HomeRecommendRes(recommendDto);
        return ApiResponseDto.success(SuccessStatus.GET_RECOMMEND_POST_SUCCESS,response);
    }
    @GetMapping("/post/popular")
    public ApiResponseDto getRank() throws NotImageFoundException {
        HomeDto.PostPopularDto postPopularDto = new HomeDto.PostPopularDto(postService.getRank());
        return ApiResponseDto.success(SuccessStatus.GET_POSTS_RANK_SUCCESS ,postPopularDto);
    }


    @GetMapping("/product")
    public ApiResponseDto showRank() throws NotImageFoundException {
        HomeDto.ProductPopularDto productPopularDto = new HomeDto.ProductPopularDto(productService.showRank());
        return ApiResponseDto.success(SuccessStatus.GET_RANK_PRODUCT , productPopularDto);
    }
}
