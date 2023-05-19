package org.sopt.myhouse.service.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PostPopularResponseDto {
    private Long post_id;
    private String image;
    private String title;
    private String subtitle;
    private int rate;
}
