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
    private Folder folder_id;

    private String image_url;

    private Scrap(Folder folder_id, String image_url){
        this.folder_id = folder_id;
        this.image_url = image_url;
    }
    public static Scrap newInstance(Folder folder_id, String image_url){
        return  new Scrap(folder_id,image_url);
    }
}
