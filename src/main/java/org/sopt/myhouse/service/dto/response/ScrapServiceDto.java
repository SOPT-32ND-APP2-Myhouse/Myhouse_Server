package org.sopt.myhouse.service.dto.response;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

public class ScrapServiceDto {


    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class PerScrapDto {
        private Long scrap_id;
        private String image_url;
    }

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class FolderScrapsDto {
        private Long folder_id;
        private String folder_title;
        private ArrayList<PerScrapDto> scraps;
    }

    @NoArgsConstructor
    @AllArgsConstructor
    @Getter
    public static class AssignScrapFolderRes {
        private Long folder_id;
        private Long scrap_id;
        private String image_url;
    }
}




