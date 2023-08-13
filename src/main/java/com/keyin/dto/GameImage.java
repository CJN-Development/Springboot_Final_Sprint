package com.keyin.dto;
import com.keyin.entities.Game;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

public class GameImage {

    private Long id;

    private String imageData;

    @OneToOne(mappedBy = "image")
    private GameDTO gameDTO;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public byte[] getImageData() {
        return imageData;
    }

    public void setImageData(byte[] imageData) {
        this.imageData = imageData;
    }

    public GameDTO getGameDTO() {
        return gameDTO;
    }

    public void setGameDTO(GameDTO gameDTO) {
        this.gameDTO = gameDTO;
    }
}
