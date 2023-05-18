package org.sopt.myhouse.service.dto.response;

import lombok.AllArgsConstructor;
import org.sopt.myhouse.entity.Scrap;

import java.util.List;

@AllArgsConstructor
public class FolderDto {
    private Long folder_id;
    private String folder_title;
    private List<ScrapDto> scraps;

}
