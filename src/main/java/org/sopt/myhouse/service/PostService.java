package org.sopt.myhouse.service;

import lombok.RequiredArgsConstructor;
import org.sopt.myhouse.entity.Image;
import org.sopt.myhouse.entity.Post;
import org.sopt.myhouse.exception.ErrorStatus;
import org.sopt.myhouse.exception.model.NotImageFoundException;
import org.sopt.myhouse.repository.ImageRepository;
import org.sopt.myhouse.repository.PostRepository;
import org.sopt.myhouse.service.dto.response.GetPostDetailDto;
import org.sopt.myhouse.service.dto.response.PostListResponseDto;
import org.sopt.myhouse.service.dto.response.PostPopularResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {

    @Autowired
    private final PostRepository postRepository ;

    @Autowired
    private final ImageRepository imageRepository;

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

    //post 둘러보기
    public List<PostListResponseDto> getOverview() throws NotImageFoundException {
        List<PostListResponseDto> responseDtos = new ArrayList<>();
        List<Post> posts = postRepository.getAll().orElseThrow(() -> new NotImageFoundException(ErrorStatus.NO_POST, ErrorStatus.NO_POST.getMessage()));
        for(Post post:posts){
            PostListResponseDto responseDto = new PostListResponseDto(post.getId(), post.getThumbnail(), post.getTitle());
            responseDtos.add(responseDto);
        }
        return responseDtos;
    }

    public List<PostPopularResponseDto> getRank() throws NotImageFoundException {
        List<PostPopularResponseDto> responseDtos = new ArrayList<>();
        List<Post> posts = postRepository.getPostByRank().orElseThrow(() -> new NotImageFoundException(ErrorStatus.NO_POST, ErrorStatus.NO_POST.getMessage()));
        int i = 1;
        for(Post post : posts){
            PostPopularResponseDto responseDto = new PostPopularResponseDto(post.getId(), post.getThumbnail(), post.getTitle(), post.getSubtitle(),i);
            i++;
            responseDtos.add(responseDto);
        }
        return responseDtos;
    }
}
