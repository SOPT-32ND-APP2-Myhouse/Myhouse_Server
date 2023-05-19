package org.sopt.myhouse.service;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.sopt.myhouse.controller.dto.request.AssignFolderRequestDto;
import org.sopt.myhouse.entity.*;
import org.sopt.myhouse.repository.*;
import org.sopt.myhouse.service.dto.request.ScrapSaveServiceDto;
import org.sopt.myhouse.service.dto.response.ScrapDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class ScrapService {

    @Autowired
    private final ScrapRepository scrapRepository;
    @Autowired
    private final FolderRepository folderRepository;
    //모든 폴더에 저장
    @Transactional
    public Scrap saveToAll(ScrapSaveServiceDto requestDto){
        Long folder_id = 1L;
        Folder folder = folderRepository.findById(folder_id);
        Scrap newScrap = Scrap.newInstance(folder,requestDto.getImage_url());
        return scrapRepository.save(newScrap);
    }

    @Transactional
    public Optional<Long> deleteScrap(Long scrap_id) {
        Long returnValue = null;
        if (scrapRepository.findById(scrap_id).isPresent()) {
            scrapRepository.deleteById(scrap_id);
            returnValue = (scrap_id);
        }
        log.info("deleteService" );
        log.info("return value = {}", returnValue );
        return Optional.ofNullable(returnValue);
    }

//    @Transactional
//    public ScrapDto.GetAllScrapRes getAllScrap(){
//           ArrayList<Scrap> scraps =  scrapRepository.getAllScrap();
//           List<Scrap> what = scrapRepository.findAll();
//
//        System.out.println(what);
//        System.out.println(what.size());
//            return new ScrapDto.GetAllScrapRes(scraps);
//    }


    public ScrapDto.AssignScrapFolderRes assignScrapToFolder(AssignFolderRequestDto requestDto ){
        Folder folder = folderRepository.findById(requestDto.getFolder_id());
        log.info("엥? ={}", folderRepository.findById(requestDto.getFolder_id()));

        if (folder==null){
            log.info("엥? 여기  ={}", folder);
            return null;
        }
        //상의 필요,, 굳이 folder객체를 넣어야 할까?  -> folder 객체 찾는데도 시간 걸림
        Scrap scrap = Scrap.newInstance(folder, requestDto.getImage_url());
        Scrap newScrap = scrapRepository.save(scrap);
        return new ScrapDto.AssignScrapFolderRes(requestDto.getFolder_id(), newScrap.getId(), requestDto.getImage_url());
    }

}
