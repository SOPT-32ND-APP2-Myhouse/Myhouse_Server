package org.sopt.myhouse.service.dto.response;


import lombok.AllArgsConstructor;
import lombok.Getter;
import org.sopt.myhouse.entity.Image;
import org.sopt.myhouse.entity.Post;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@AllArgsConstructor
public class GetPostDetailDto {
    private Long post_id;
    private String user_name;
    private String created_date;
    private String option_tag;
    private List<ImageDto> images;
    private String hast_tag;
    private Long like_count;
    private Long scrap_count;
    private Long comment_count;
    private Long view_count;

    public GetPostDetailDto(Post post, List<Image> images ){
        this.post_id = post.getId();
        this.user_name = "nickname";
        this.created_date = String.valueOf(post.getCreated_date()).substring(0,10);
        this.option_tag = post.getOption_tag();
        this.images = (List<ImageDto>) images.stream().map(image-> new ImageDto(image)).collect(Collectors.toList());
        this.hast_tag = post.getHash_tag();
        this.like_count = post.getLike_count();
        this.scrap_count = post.getScrap_count();
        this.comment_count = post.getComment_count();
        this.view_count = post.getComment_count();
    }




}
