package org.sopt.myhouse.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.sopt.myhouse.entity.Image;
import org.sopt.myhouse.entity.Post;
import org.sopt.myhouse.exception.ErrorStatus;
import org.sopt.myhouse.exception.model.NotImageFoundException;
import org.sopt.myhouse.exception.model.NotPostFoundException;
import org.sopt.myhouse.repository.ImageRepository;
import org.sopt.myhouse.repository.PostRepository;
import org.sopt.myhouse.service.dto.response.PostServiceDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class PostService {

    @Autowired
    private final PostRepository postRepository ;

    @Autowired
    private final ImageRepository imageRepository;

    public Post recommendPost() throws NotPostFoundException{
        return postRepository.recommendPost().orElseThrow(()-> new NotPostFoundException(ErrorStatus.NO_POST, ErrorStatus.NO_POST.getMessage()));
    }


    public PostServiceDto.GetPostDetailDto getPostDetail(Long post_id) {
        Post post = postRepository.findById(post_id).orElseThrow(()->new NotPostFoundException(ErrorStatus.NO_POST, ErrorStatus.NO_POST.getMessage()));
        ArrayList<Image> images = imageRepository.findByPostId(post_id);
        return new PostServiceDto.GetPostDetailDto(post,images);
    }

    //post 둘러보기
    public List<PostServiceDto.PostListResponseDto> getOverview() throws NotImageFoundException {
        List<PostServiceDto.PostListResponseDto> responseDtos = new ArrayList<>();
        List<Post> posts = postRepository.getAll().orElseThrow(() -> new NotImageFoundException(ErrorStatus.IMAGE_URL_NOT_FOUND, ErrorStatus.IMAGE_URL_NOT_FOUND.getMessage()));
        for(Post post:posts){
            PostServiceDto.PostListResponseDto responseDto = new PostServiceDto.PostListResponseDto(post.getId(), post.getThumbnail(), post.getTitle());
            responseDtos.add(responseDto);
        }
        return responseDtos;
    }

    public List<PostServiceDto.PostPopularResponseDto> getRank() throws NotImageFoundException {
        List<PostServiceDto.PostPopularResponseDto> responseDtos = new ArrayList<>();
        List<Post> posts = postRepository.getPostByRank().orElseThrow(() -> new NotImageFoundException(ErrorStatus.NO_POST, ErrorStatus.NO_POST.getMessage()));
        int i = 1;
        for(Post post : posts){
            PostServiceDto.PostPopularResponseDto responseDto = new PostServiceDto.PostPopularResponseDto(post.getId(), post.getThumbnail(), post.getTitle(), post.getSubtitle(),i);
            i++;
            responseDtos.add(responseDto);
        }
        return responseDtos;
    }
}
