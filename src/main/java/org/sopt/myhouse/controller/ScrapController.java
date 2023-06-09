package org.sopt.myhouse.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.sopt.myhouse.common.advice.dto.ApiResponseDto;
import org.sopt.myhouse.controller.dto.request.FolderControllerDto;
import org.sopt.myhouse.controller.dto.request.ScrapControllerDto;
import org.sopt.myhouse.entity.Scrap;
import org.sopt.myhouse.exception.SuccessStatus;
import org.sopt.myhouse.exception.model.NotFolderFoundException;
import org.sopt.myhouse.exception.model.NotImageFoundException;
import org.sopt.myhouse.exception.model.NotScrapFoundException;
import org.sopt.myhouse.service.ScrapService;
import org.sopt.myhouse.service.dto.response.FolderServiceDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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
    public ApiResponseDto create(@RequestBody final ScrapControllerDto.ScrapRequestDto request) throws NotImageFoundException {
        Scrap scrap = scrapService.saveToAll(request.toServiceDto());
        return ApiResponseDto.success(SuccessStatus.SCRAP_SUCCESS, scrap);
    }

    @DeleteMapping("{scrap_id}")
    public ApiResponseDto deleteScrap(@PathVariable("scrap_id") Long scrap_id) throws NotScrapFoundException{
       return ApiResponseDto.success(SuccessStatus.DELETE_SCRAP_SUCCESS, scrapService.deleteScrap(scrap_id));
    }


    @GetMapping("/all")
    public ApiResponseDto getAllScrap() throws NotFolderFoundException ,NotScrapFoundException{
        FolderServiceDto.FoldersRes getAllScrapRes = scrapService.getAllScrap();
        return success(SuccessStatus.GET_ALL_FOLDER, getAllScrapRes);

    }

    @PostMapping("/{folder_id}")
    public ApiResponseDto assignScrapFolder(@PathVariable Long folder_id,
                                            @RequestBody FolderControllerDto.AssignFolderRequestDto assignFolderRequestDto)
    throws NotFolderFoundException{
        FolderControllerDto.AssignFolderRequestDto requestDto = new FolderControllerDto.AssignFolderRequestDto(folder_id, assignFolderRequestDto.getImage_url());
        return ApiResponseDto.success(SuccessStatus.SCRAP_SUCCESS, scrapService.assignScrapToFolder(requestDto));
    }

}
