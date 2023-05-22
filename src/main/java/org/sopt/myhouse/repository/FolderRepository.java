package org.sopt.myhouse.repository;

import org.sopt.myhouse.entity.Folder;
import org.springframework.data.repository.Repository;

import java.util.ArrayList;
import java.util.Optional;

public interface FolderRepository extends Repository<Folder, Long> {
    Optional<Folder> findById(Long folder_id);


    Optional<ArrayList<Folder>> findAll();

}
