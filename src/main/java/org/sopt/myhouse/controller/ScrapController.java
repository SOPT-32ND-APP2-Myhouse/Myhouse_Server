package org.sopt.myhouse.controller;

import lombok.RequiredArgsConstructor;
import org.sopt.myhouse.common.advice.dto.ApiResponseDto;
import org.sopt.myhouse.controller.dto.request.ScrapRequestDto;
import org.sopt.myhouse.entity.Scrap;
import org.sopt.myhouse.exception.ErrorStatus;
import org.sopt.myhouse.exception.SuccessStatus;
import org.sopt.myhouse.service.ScrapService;
import org.sopt.myhouse.service.dto.response.ScrapDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import static org.sopt.myhouse.common.advice.dto.ApiResponseDto.success;

@RestController
@RequiredArgsConstructor
@RequestMapping("/scrap")
public class ScrapController {

    @Autowired
    private final ScrapService scrapService;


    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public ApiResponseDto<Scrap> create(@RequestBody final ScrapRequestDto request) {
        Scrap scrap = scrapService.saveToAll(request.toServiceDto());
        return ApiResponseDto.success(SuccessStatus.SCRAP_SUCCESS, scrap);
    }

    @DeleteMapping("{scrap_id}")
    public ApiResponseDto deleteScrap(@PathVariable("scrap_id") Long scrap_id){
       Optional<Long> id = scrapService.deleteScrap(scrap_id);
       if (id.isPresent()){
           return success(SuccessStatus.DELETE_SCRAP_SUCCESS, id);
       }
       return ApiResponseDto.error(ErrorStatus.NO_SCRAP);
    }

    @GetMapping("/all")
    public ApiResponseDto getAllScrap(){
        ScrapDto.GetAllScrapRes getAllScrapRes = scrapService.getAllScrap();
       return success(SuccessStatus.SCRAP_SUCCESS, getAllScrapRes);
    }
}
