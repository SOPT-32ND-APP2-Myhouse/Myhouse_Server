package org.sopt.myhouse.controller.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class AssignFolderRequestDto {
    private Long folder_id;
    private String image_url;
}
