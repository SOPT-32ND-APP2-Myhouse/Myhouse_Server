package org.sopt.myhouse.controller;

import lombok.RequiredArgsConstructor;
import org.sopt.myhouse.common.advice.dto.ApiResponseDto;
import org.sopt.myhouse.exception.SuccessStatus;
import org.sopt.myhouse.service.ProductService;
import org.sopt.myhouse.service.dto.response.ProductResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;
@RestController
@RequiredArgsConstructor
public class ProductController {

    @Autowired
    private final ProductService productService;

    @GetMapping("/home/product")
    public ApiResponseDto<List<ProductResponseDto>> showRank(){
        return ApiResponseDto.success(SuccessStatus.GET_RANK_PRODUCT , productService.showRank());
    }
}
