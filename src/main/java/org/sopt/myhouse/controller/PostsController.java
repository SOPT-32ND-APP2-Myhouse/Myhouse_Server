package org.sopt.myhouse.controller;

import lombok.RequiredArgsConstructor;
import org.sopt.myhouse.common.advice.dto.ApiResponseDto;
import org.sopt.myhouse.exception.ErrorStatus;
import org.sopt.myhouse.exception.SuccessStatus;
import org.sopt.myhouse.repository.PostRepository;
import org.sopt.myhouse.service.PostService;
import org.sopt.myhouse.service.dto.response.GetPostDetailDto;
import org.sopt.myhouse.service.dto.response.PostListResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/posts")
public class PostsController {

    @Autowired
    private final PostService postService;

    @GetMapping("/{post_id}")
    public ApiResponseDto getPostDetail(@PathVariable("post_id") Long post_id){
        GetPostDetailDto getPostDetailDto = postService.getPostDetail(post_id);
        //Optional 추가 하고 싶음
        if (getPostDetailDto == null){
            return ApiResponseDto.error(ErrorStatus.NO_POST);
        }
        return ApiResponseDto.success(SuccessStatus.GET_POST_DETAIL_SUCCESS, getPostDetailDto);
    }


    @GetMapping("")
    public ApiResponseDto<List<PostListResponseDto>> getOverview(){
        return ApiResponseDto.success(SuccessStatus.GET_OVERALL_POSTS_SUCCESS, postService.getOverview());
    }
}
