package org.sopt.myhouse.service.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;


public class FolderServiceDto {

    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class FoldersRes{
        private ArrayList<ScrapServiceDto.FolderScrapsDto> scrap_folders;
    }

}
