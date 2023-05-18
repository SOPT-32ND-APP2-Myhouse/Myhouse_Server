package org.sopt.myhouse.service.dto.response;


import lombok.AllArgsConstructor;
import org.sopt.myhouse.entity.Scrap;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ScrapDto {

    public Long scrap_id;
    public String image_url;

    public ScrapDto(Scrap scrap){
        this.scrap_id = scrap.getId();
        this.image_url = scrap.getImage_url();
    }

    @AllArgsConstructor
     public static class GetAllScrapRes {
        public List<FolderDto> scrap_folders;

        public GetAllScrapRes(ArrayList<Scrap> scraps){
            List<ScrapDto> scrapDtos = scraps.stream().map(scrap -> new ScrapDto(scrap)).collect(Collectors.toList());
            this.scrap_folders = scraps.stream().map(scrap -> new FolderDto(
                    scrap.getFolder_id().getId(), scrap.getFolder_id().getTitle(), scrapDtos)
            ).collect(Collectors.toList());
        }
    }


}
