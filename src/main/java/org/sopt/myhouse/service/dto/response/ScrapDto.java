package org.sopt.myhouse.service.dto.response;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.sopt.myhouse.entity.Scrap;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ScrapDto {



    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class  PerScrapDto{
        private Long scrap_id;
        private String image_url;
    }

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class  FolderScrapsDto{
        private Long folder_id;
        private String folder_title;
        private ArrayList<PerScrapDto> scraps;
    }


}
