package com.keyin.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Game {

    @Id
    @SequenceGenerator(name = "games_sequence", sequenceName = "games_sequence", allocationSize = 1, initialValue=1)
    @GeneratedValue(generator = "games_sequence")
    private Long id;

    @Column(unique = true)
    private String gameName;
    private String releaseDate;
    private byte[] imageData;
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Publisher gamePublisher;
//
    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "game_platform",
            joinColumns = @JoinColumn(name = "game_id"),
            inverseJoinColumns = @JoinColumn(name = "platform_name"))
    private List<Platform> gamePlatform = new ArrayList<>();

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "game_genre",
            joinColumns = @JoinColumn(name = "game_id"),
            inverseJoinColumns = @JoinColumn(name = "genre_name"))
    private List<Genre> listOfGenres = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Publisher getGamePublisher() {
        return gamePublisher;
    }

    public void setGamePublisher(Publisher gamePublisher) {
        this.gamePublisher = gamePublisher;
    }

    public List<Platform> getGamePlatform() {
        return gamePlatform;
    }

    public void setGamePlatform(List<Platform> gamePlatform) {
        this.gamePlatform = gamePlatform;
    }

    public List<Genre> getListOfGenres() {
        return listOfGenres;
    }

    public void setListOfGenres(List<Genre> listOfGenres) {
        this.listOfGenres = listOfGenres;
    }

    public byte[] getImageData() {
        return imageData;
    }

    public void setImageData(byte[] imageData) {
        this.imageData = imageData;
    }

    @Override
    public String toString() {
        return "Game{" +
                "id=" + id +
                ", gameName='" + gameName + '\'' +
                ", releaseDate='" + releaseDate + '\'' +
//                ", gamePublisher=" + gamePublisher +
//                ", gamePlatform=" + gamePlatform +
//                ", gameGenre=" + gameGenre +
                '}';
    }
}
