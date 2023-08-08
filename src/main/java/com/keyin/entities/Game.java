package com.keyin.entities;

import javax.persistence.*;
import java.util.List;

public class Game {

    @Id
    @SequenceGenerator(name = "games_sequence", sequenceName = "games_sequence", allocationSize = 1, initialValue=1)
    @GeneratedValue(generator = "games_sequence")
    private Long id;

    private String gameName;
    private String releaseDate;

    @OneToOne(mappedBy = "Publisher")
    private List<Publisher> gamePublisher;

    @OneToMany(mappedBy = "Platform")
    private List<Platform> gamePlatform;

    @OneToOne(mappedBy = "Genre")
    private List<Genre> gameGenre;

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

    public List<Publisher> getGamePublisher() {
        return gamePublisher;
    }

    public void setGamePublisher(List<Publisher> gamePublisher) {
        this.gamePublisher = gamePublisher;
    }

    public List<Platform> getGamePlatform() {
        return gamePlatform;
    }

    public void setGamePlatform(List<Platform> gamePlatform) {
        this.gamePlatform = gamePlatform;
    }

    public List<Genre> getGameGenre() {
        return gameGenre;
    }

    public void setGameGenre(List<Genre> gameGenre) {
        this.gameGenre = gameGenre;
    }

    @Override
    public String toString() {
        return "Game{" +
                "id=" + id +
                ", gameName='" + gameName + '\'' +
                ", releaseDate='" + releaseDate + '\'' +
                ", gamePublisher=" + gamePublisher +
                ", gamePlatform=" + gamePlatform +
                ", gameGenre=" + gameGenre +
                '}';
    }
}
