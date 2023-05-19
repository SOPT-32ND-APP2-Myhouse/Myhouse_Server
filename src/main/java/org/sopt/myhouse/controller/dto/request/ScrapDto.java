package org.sopt.myhouse.controller.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

public class ScrapDto {

    @AllArgsConstructor
    @Getter
    public static class AssignFolderScrapReq{
        private String image_url;
    }
}
