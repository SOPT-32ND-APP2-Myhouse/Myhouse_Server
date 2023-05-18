package org.sopt.myhouse.controller.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.sopt.myhouse.service.dto.ScrapSaveServiceDto;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ScrapRequestDto {
    private String image_url;

    public ScrapSaveServiceDto toServiceDto(){
        return ScrapSaveServiceDto.of(image_url);
    }
}
