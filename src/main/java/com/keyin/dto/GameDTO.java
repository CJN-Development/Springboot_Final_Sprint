package com.keyin.dto;

import com.keyin.entities.Publisher;

import java.util.List;

public class GameDTO {

    private Long id;
    private String gameName;

    private Long gamePublisherId;

    private String releaseDate;
    private List<String> genreNames;
    private List<String> gamePlatformNames;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getGamePublisherId() {
        return gamePublisherId;
    }

    public void setGamePublisherId(Long gamePublisherId) {
        this.gamePublisherId = gamePublisherId;
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



    public List<String> getGenreNames() {
        return genreNames;
    }

    public void setGenreNames(List<String> genreNames) {
        this.genreNames = genreNames;
    }

    public List<String> getGamePlatformNames() {
        return gamePlatformNames;
    }

    public void setGamePlatformNames(List<String> gamePlatformNames) {
        this.gamePlatformNames = gamePlatformNames;
    }
}
