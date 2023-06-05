package org.sopt.myhouse.service.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ScrapSaveServiceDto {
    private String image_url;

    public static ScrapSaveServiceDto of(String image_url){
        return new ScrapSaveServiceDto( image_url);
    }
}
