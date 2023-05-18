package org.sopt.myhouse.controller;

import lombok.RequiredArgsConstructor;
import org.sopt.myhouse.common.advice.dto.ApiResponseDto;
import org.sopt.myhouse.controller.dto.request.ScrapRequestDto;
import org.sopt.myhouse.exception.SuccessStatus;
import org.sopt.myhouse.service.ScrapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/scrap")
public class ScrapController {

    @Autowired
    private final ScrapService scrapService;

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public ApiResponseDto create(@RequestBody final ScrapRequestDto request) {
        scrapService.saveToAll(request.toServiceDto());
        return ApiResponseDto.success(SuccessStatus.SCRAP_SUCCESS);
    }

}
