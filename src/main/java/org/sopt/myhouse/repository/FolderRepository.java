package org.sopt.myhouse.repository;

import org.sopt.myhouse.entity.Folder;
import org.springframework.data.repository.Repository;

import java.util.ArrayList;

public interface FolderRepository extends Repository<Folder, Long> {
    Folder findById(Long folder_id);


    ArrayList<Folder> findAll();
    //optional로 바꾸자!

}
