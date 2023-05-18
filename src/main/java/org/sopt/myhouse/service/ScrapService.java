package org.sopt.myhouse.service;

import lombok.RequiredArgsConstructor;
import org.sopt.myhouse.entity.*;
import org.sopt.myhouse.exception.ErrorStatus;
import org.sopt.myhouse.exception.model.ConflictException;
import org.sopt.myhouse.repository.*;
import org.sopt.myhouse.service.dto.ScrapSaveServiceDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class ScrapService {
    @Autowired
    private final ScrapRepository scrapRepository;
    @Autowired
    private final PostRepository postRepository;
    @Autowired
    private final ImageRepository imageRepository;
    @Autowired
    private final ProductRepository productRepository;
    @Autowired
    private final FolderRepository folderRepository;
    //모든 폴더에 저장
    @Transactional
    public Scrap saveToAll(ScrapSaveServiceDto requestDto){
        Long folder_id = 1L;
        Folder folder = folderRepository.findById(folder_id);
        Post post = postRepository.findById(requestDto.getPost_id());
        Image image = imageRepository.findById(requestDto.getImage_id());
        Product product = productRepository.findById(requestDto.getProduct_id());
        Scrap newScrap = Scrap.newInstance(post, image ,product, folder,requestDto.getImage_url());
        return scrapRepository.save(newScrap);
    }
}
