package org.sopt.myhouse.controller;

import lombok.RequiredArgsConstructor;
import org.sopt.myhouse.common.advice.dto.ApiResponseDto;
import org.sopt.myhouse.controller.dto.response.HomeControllerDto;
import org.sopt.myhouse.entity.Post;
import org.sopt.myhouse.exception.SuccessStatus;
import org.sopt.myhouse.exception.model.NotImageFoundException;
import org.sopt.myhouse.exception.model.NotPostFoundException;
import org.sopt.myhouse.service.PostService;
import org.sopt.myhouse.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

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
        HomeControllerDto.RecommendDto recommendDto = new HomeControllerDto.RecommendDto(post.getPost_category(),"nickname", post.getId(), post.getThumbnail(), post.getTitle());
        HomeControllerDto.HomeRecommendRes response = new HomeControllerDto.HomeRecommendRes(recommendDto);
        return ApiResponseDto.success(SuccessStatus.GET_RECOMMEND_POST_SUCCESS,response);
    }
    @GetMapping("/post/popular")
    public ApiResponseDto getRank() throws NotImageFoundException {
        return ApiResponseDto.success(SuccessStatus.GET_POSTS_RANK_SUCCESS ,postService.getRank());
    }


    @GetMapping("/product")
    public ApiResponseDto showRank() throws NotImageFoundException {
        return ApiResponseDto.success(SuccessStatus.GET_RANK_PRODUCT , productService.showRank());
    }
}
