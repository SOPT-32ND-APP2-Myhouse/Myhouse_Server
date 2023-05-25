package org.sopt.myhouse.controller.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.sopt.myhouse.service.dto.request.ScrapSaveServiceDto;


public class ScrapControllerDto {

    @AllArgsConstructor
    @Getter
    public static class AssignFolderScrapReq{
        private String image_url;
    }

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ScrapRequestDto {
        private  String image_url;

        public ScrapSaveServiceDto toServiceDto(){
            return ScrapSaveServiceDto.of(image_url);
        }
    }

}
