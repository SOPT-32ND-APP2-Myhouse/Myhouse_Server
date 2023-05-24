package org.sopt.myhouse.controller.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.sopt.myhouse.service.dto.response.PostListResponseDto;
import java.util.List;

public class OverviewDto {

    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    static public class PostOverviewDto{
        List<PostListResponseDto> postListResponseDto;
    }
}
