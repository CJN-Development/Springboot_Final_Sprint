package com.keyin.controllers;

import com.keyin.dto.GameDTO;
import com.keyin.dto.GenreDTO;
import com.keyin.entities.Game;
import com.keyin.entities.Genre;
import com.keyin.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/create")
public class GameController {
    @Autowired
    private GameService gameService;

    @PostMapping("/createGame")
    public ResponseEntity<Game> createGameWithAssociations(
            @RequestBody GameDTO request) {
        Game createdGame = gameService.createGameWithAssociations(request);
        return ResponseEntity.ok(createdGame);
    }

}

