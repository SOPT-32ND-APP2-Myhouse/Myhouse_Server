package org.sopt.myhouse.service.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.sopt.myhouse.entity.Scrap;

import java.util.ArrayList;
import java.util.List;


public class FolderDto {

    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class FoldersRes{
        private ArrayList<ScrapDto.FolderScrapsDto> scrap_folders;
    }

}
