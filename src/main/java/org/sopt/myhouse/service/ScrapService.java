package org.sopt.myhouse.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.sopt.myhouse.entity.*;
import org.sopt.myhouse.repository.*;
import org.sopt.myhouse.service.dto.request.ScrapSaveServiceDto;
import org.sopt.myhouse.service.dto.response.FolderDto;
import org.sopt.myhouse.service.dto.response.ScrapDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.HashMap;
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

    @Transactional
    public  FolderDto.FoldersRes getAllScrap(){
            ArrayList<Folder> getFolders = folderRepository.findAll();
           ArrayList<Scrap> scraps =  scrapRepository.getAllScrap();
           HashMap<Long, ArrayList<ScrapDto.PerScrapDto>> folders = new HashMap<Long, ArrayList<ScrapDto.PerScrapDto>>();

           Long i = 1L;
           for (i=1L; i<5; i++){
               folders.put(i, new ArrayList<ScrapDto.PerScrapDto>());
           }

            for (Scrap scrap:scraps
             ) {
                Long folderId = scrap.getFolder().getId();
                ArrayList <ScrapDto.PerScrapDto> scrapList = folders.get(folderId);
                scrapList.add(new ScrapDto.PerScrapDto(scrap.getId(),scrap.getImage_url()));
                folders.put(folderId, scrapList);
                }
            // service 반환 Dto


            // 각 folder의 Dto
            ArrayList<ScrapDto.FolderScrapsDto> res = new ArrayList<ScrapDto.FolderScrapsDto>();

            for (Long k = 1L; k<5L; k++) {
                ScrapDto.FolderScrapsDto folder_scrap = new ScrapDto.FolderScrapsDto(
                        k,
                        getFolders.get(Math.toIntExact(k)-1).getTitle(),
                        folders.get(k));
                res.add(folder_scrap);
            }
            return new FolderDto.FoldersRes(res);
    }
}
