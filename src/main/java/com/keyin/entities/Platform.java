package com.keyin.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Platform {

    @Id
    @SequenceGenerator(name = "platform_sequence", sequenceName = "platform_sequence", allocationSize = 1, initialValue=1)
    @GeneratedValue(generator = "platform_sequence")
    private Long id;

    private String platformName;

//    private List<Game> listOfGamesOnPlatform;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPlatformName() {
        return platformName;
    }

    public void setPlatformName(String platformName) {
        this.platformName = platformName;
    }

//    public List<Game> getListOfGamesOnPlatform() {
//        return listOfGamesOnPlatform;
//    }
//
//    public void setListOfGamesOnPlatform(List<Game> listOfGamesOnPlatform) {
//        this.listOfGamesOnPlatform = listOfGamesOnPlatform;
//    }

    @Override
    public String toString() {
        return "Platform{" +
                "id=" + id +
                ", platformName='" + platformName + '\'' +
//                ", listOfGamesOnPlatform=" + listOfGamesOnPlatform +
                '}';
    }
}
