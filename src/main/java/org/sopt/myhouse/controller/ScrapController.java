package org.sopt.myhouse.controller;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.sopt.myhouse.common.advice.dto.ApiResponseDto;
import org.sopt.myhouse.controller.dto.request.ScrapRequestDto;
import org.sopt.myhouse.controller.dto.request.AssignFolderRequestDto;
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

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/scrap")
public class ScrapController {

    @Autowired
    private final ScrapService scrapService;


    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public ApiResponseDto create(@RequestBody final ScrapRequestDto request) {
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


//    @GetMapping("/all")
//    public ApiResponseDto getAllScrap(){
//        ScrapDto.GetAllScrapRes getAllScrapRes = scrapService.getAllScrap();
//       return success(SuccessStatus.SCRAP_SUCCESS, getAllScrapRes);
//    }


    @PostMapping("/{folder_id}")
    public ApiResponseDto assignScrapFolder(@PathVariable Long folder_id,
                                            @RequestBody AssignFolderRequestDto assignFolderRequestDto){
        AssignFolderRequestDto requestDto = new AssignFolderRequestDto(folder_id, assignFolderRequestDto.getImage_url());

        ScrapDto.AssignScrapFolderRes responseDto = scrapService.assignScrapToFolder(requestDto);
        if (responseDto == null){
            log.info("엥? 여기 컨트롤러 = {}" ,responseDto);
            return ApiResponseDto.error(ErrorStatus.NO_FOLDER);
        }
        return ApiResponseDto.success(SuccessStatus.SCRAP_SUCCESS, responseDto);

    }

}
