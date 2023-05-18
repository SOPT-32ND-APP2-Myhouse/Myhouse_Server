package org.sopt.myhouse.service;

import lombok.RequiredArgsConstructor;
import org.sopt.myhouse.entity.*;
import org.sopt.myhouse.exception.ErrorStatus;
import org.sopt.myhouse.exception.model.ConflictException;
import org.sopt.myhouse.repository.*;
import org.sopt.myhouse.service.dto.ScrapSaveServiceDto;
import org.sopt.myhouse.service.dto.response.ScrapDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    public Optional<Long> deleteScrap(Long scrap_id) {
        if (scrapRepository.findById(scrap_id).isPresent()) {
            Long id = scrapRepository.deleteById(scrap_id);
            return Optional.of(id);
        } else
            return Optional.empty();
    }

    public ScrapDto.GetAllScrapRes getAllScrap(){
           ArrayList<Scrap> scraps =  scrapRepository.getAllScrap();
           List<Scrap> what = scrapRepository.findAll();

        System.out.println(what);
        System.out.println(what.size());
            return new ScrapDto.GetAllScrapRes(scraps);
    }
}
