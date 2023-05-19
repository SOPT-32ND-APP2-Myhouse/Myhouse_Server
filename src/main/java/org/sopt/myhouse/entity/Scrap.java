package org.sopt.myhouse.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
public class Scrap {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne( fetch = FetchType.LAZY)
    @JoinColumn (name =  "FOLDER_ID")
    private Folder folder;

    private String image_url;

    private Scrap(Folder folder, String image_url){
        this.folder = folder;
        this.image_url = image_url;
    }
    public static Scrap newInstance(Folder folder, String image_url){
        return  new Scrap(folder,image_url);
    }
}
