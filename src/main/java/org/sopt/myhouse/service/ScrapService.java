package org.sopt.myhouse.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.sopt.myhouse.entity.*;
import org.sopt.myhouse.exception.ErrorStatus;
import org.sopt.myhouse.exception.model.NotFolderFoundException;
import org.sopt.myhouse.exception.model.NotImageFoundException;
import org.sopt.myhouse.exception.model.NotScrapFoundException;
import org.sopt.myhouse.repository.*;
import org.sopt.myhouse.service.dto.request.ScrapSaveServiceDto;
import org.sopt.myhouse.service.dto.response.FolderServiceDto;
import org.sopt.myhouse.service.dto.response.ScrapServiceDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.sopt.myhouse.controller.dto.request.FolderControllerDto;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ScrapService {

    @Autowired
    private final ScrapRepository scrapRepository;
    @Autowired
    private final FolderRepository folderRepository;
    @Autowired
    private final ImageRepository imageRepository;
    //모든 폴더에 저장
    @Transactional
    public Scrap saveToAll(ScrapSaveServiceDto requestDto) throws NotImageFoundException {
        Long folder_id = 1L;
        Folder folder = folderRepository.findById(folder_id).orElseThrow(() -> new NotFolderFoundException(ErrorStatus.NO_FOLDER,ErrorStatus.NO_FOLDER.getMessage() ));
        List<Image> images = imageRepository.findByImageUrl(requestDto.getImage_url()).get();
        if( images.isEmpty()){
            throw new NotImageFoundException(ErrorStatus.IMAGE_URL_NOT_FOUND, ErrorStatus.IMAGE_URL_NOT_FOUND.getMessage());
        };
        System.out.println(images);
        Scrap newScrap = Scrap.newInstance(folder,requestDto.getImage_url());
        return scrapRepository.save(newScrap);
    }

    @Transactional
    public Long deleteScrap(Long scrap_id) {
        scrapRepository.findById(scrap_id).orElseThrow(()-> new NotScrapFoundException(ErrorStatus.NO_SCRAP,ErrorStatus.NO_FOLDER.getMessage()));
        scrapRepository.deleteById(scrap_id);
        return scrap_id;
    }


    @Transactional
    public  FolderServiceDto.FoldersRes getAllScrap() throws NotFolderFoundException{
            ArrayList<Folder> getFolders = folderRepository.findAll().orElseThrow(()-> new NotFolderFoundException(ErrorStatus.NO_FOLDER,ErrorStatus.NO_FOLDER.getMessage()));
           ArrayList<Scrap> scraps =  scrapRepository.getAllScrap().orElseThrow(()->new NotScrapFoundException(ErrorStatus.NO_SCRAP, ErrorStatus.NO_SCRAP.getMessage()));
           HashMap<Long, ArrayList<ScrapServiceDto.PerScrapDto>> folders = new HashMap<Long, ArrayList<ScrapServiceDto.PerScrapDto>>();

           Long i = 1L;
           for (i=1L; i<5; i++){
               folders.put(i, new ArrayList<ScrapServiceDto.PerScrapDto>());
           }

            for (Scrap scrap:scraps
             ) {
                Long folderId = scrap.getFolder().getId();
                ArrayList <ScrapServiceDto.PerScrapDto> scrapList = folders.get(folderId);
                scrapList.add(new ScrapServiceDto.PerScrapDto(scrap.getId(),scrap.getImage_url()));
                folders.put(folderId, scrapList);
                }
            // service 반환 Dto


            // 각 folder의 Dto
            ArrayList<ScrapServiceDto.FolderScrapsDto> res = new ArrayList<ScrapServiceDto.FolderScrapsDto>();

            for (Long k = 1L; k<5L; k++) {
                ScrapServiceDto.FolderScrapsDto folder_scrap = new ScrapServiceDto.FolderScrapsDto(
                        k,
                        getFolders.get(Math.toIntExact(k)-1).getTitle(),
                        folders.get(k));
                res.add(folder_scrap);
            }
            return new FolderServiceDto.FoldersRes(res);
    }


    public ScrapServiceDto.AssignScrapFolderRes assignScrapToFolder(FolderControllerDto.AssignFolderRequestDto requestDto ) throws NotImageFoundException {
        Folder folder = folderRepository.findById(requestDto.getFolder_id()).orElseThrow(()-> new NotFolderFoundException(ErrorStatus.NO_FOLDER, ErrorStatus.NO_FOLDER.getMessage()));
        // 이 부분에서 exception 던지는 것을 바꿔줘야할 것 같습니다!

        //상의 필요, 굳이 folder객체를 넣어야 할까?  -> folder 객체 찾는데도 시간 걸림
        Scrap scrap = Scrap.newInstance(folder, requestDto.getImage_url());
        Scrap newScrap = scrapRepository.save(scrap);
        return new ScrapServiceDto.AssignScrapFolderRes(requestDto.getFolder_id(), newScrap.getId(), requestDto.getImage_url());

    }

}
