package com.keyin.entities;

import javax.persistence.*;
import java.util.ArrayList;
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

    private String publisherName;


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

    @Override
    public String toString() {
        return "Publisher{" +
                "id=" + id +
                ", publisherName='" + publisherName + '\'' +
                '}';
    }
}
