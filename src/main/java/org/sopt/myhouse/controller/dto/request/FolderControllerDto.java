package org.sopt.myhouse.controller.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class FolderControllerDto {

    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    public static class AssignFolderRequestDto {
        private Long folder_id;
        private String image_url;
    }
}
