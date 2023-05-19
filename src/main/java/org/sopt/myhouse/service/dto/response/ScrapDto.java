package org.sopt.myhouse.service.dto.response;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.sopt.myhouse.entity.Scrap;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ScrapDto {

        @NoArgsConstructor
        @AllArgsConstructor
        @Getter
        public static class AssignScrapFolderRes{
            private Long folder_id;
            private Long scrap_id;
            private String image_url;
        }
    }


//public static class GetAllScrapRes {
//    public List<FolderDto> scrap_folders;
//
//    public GetAllScrapRes(ArrayList<Scrap> scraps){
//        List<ScrapDto> scrapDtos = scraps.stream().map(scrap -> new ScrapDto(scrap)).collect(Collectors.toList());
//        this.scrap_folders = scraps.stream().map(scrap -> new FolderDto(
//                scrap.getFolder().getId(), scrap.getFolder().getTitle(), scrapDtos)
//        ).collect(Collectors.toList());
//    }
//}  @AllArgsConstructor




