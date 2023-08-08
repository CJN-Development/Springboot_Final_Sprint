package com.keyin.entities;

import javax.persistence.*;
import java.util.List;

@Entity
public class Publisher {
    // LIST OF TOP TEN VIDEO GAME PUBLISHERS FOR REFERENCE:
    //    Nintendo
    //    Activision Blizzard
    //    Electronic Arts (EA)
    //    Ubisoft
    //    Sony Interactive Entertainment
    //    Microsoft Game Studios
    //    Take-Two Interactive
    //    Square Enix
    //    Bandai Namco Entertainment
    //    Capcom


    @Id
    @SequenceGenerator(name = "publisher_sequence", sequenceName = "publisher_sequence", allocationSize = 1,
            initialValue=1)
    @GeneratedValue(generator = "publisher_sequence")
    private Long id;

    @Column(unique = true)
    private String publisherName;


//     List to keep track of games from each publisher
//    @OneToMany
//    private List<Game> publisherGamesList;


    // wondering if I need the id if auto generated with the sequences in the repo
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPublisherName() {
        return publisherName;
    }

    public void setPublisherName(String publisherName) {
        this.publisherName = publisherName;
    }




//    public void setPublisherGamesList(List<Game> publisherGamesList) {
//        this.publisherGamesList = publisherGamesList;
//    }

    @Override
    public String toString() {
        return "Publisher{" +
                "id=" + id +
                ", publisherName='" + publisherName + '\'' +
//                ", publisherGamesList=" + publisherGamesList +
                '}';
    }
}
