package org.sopt.myhouse.service;

import lombok.RequiredArgsConstructor;
import org.sopt.myhouse.entity.Image;
import org.sopt.myhouse.entity.Post;
import org.sopt.myhouse.repository.ImageRepository;
import org.sopt.myhouse.repository.PostRepository;
import org.sopt.myhouse.repository.ScrapRepository;
import org.sopt.myhouse.service.dto.response.GetPostDetailDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;

@Service
@RequiredArgsConstructor
public class PostService {

    @Autowired
    private final PostRepository postRepository ;

    @Autowired final ImageRepository imageRepository;

    public Post recommendPost(){
        return postRepository.recommendPost();
    }

    //Optional 추가하고 싶어!
    public GetPostDetailDto getPostDetail(Long post_id) {
        Post post = postRepository.findById(post_id);
        if (post == null){
            return null;
        } else{
            ArrayList<Image> images = imageRepository.findByPostId(post_id);
            return new GetPostDetailDto(post,images);
        }

    }

}
