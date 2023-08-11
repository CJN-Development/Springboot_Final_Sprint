package com.keyin.services;

import com.keyin.dto.GameDTO;
import com.keyin.dto.GenreDTO;
import com.keyin.dto.PlatformDTO;
//import com.keyin.dto.PublisherDTO;
//import com.keyin.dto.PublisherDTO;
import com.keyin.dto.PublisherDTO;
import com.keyin.entities.Game;
import com.keyin.entities.Genre;
import com.keyin.entities.Platform;
import com.keyin.entities.Publisher;
import com.keyin.restrepos.GameRestRepository;
import com.keyin.restrepos.GenreRestRepository;
import com.keyin.restrepos.PlatformRestRepository;
import com.keyin.restrepos.PublisherRestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.ArrayList;
import java.util.List;
@CrossOrigin(allowedHeaders = "*")
@Service
public class GameService {

    @Autowired
    private GameRestRepository gameRepository;

    @Autowired
    private PublisherRestRepository publisherRepository;

    @Autowired
    private GenreRestRepository genreRepository;

    @Autowired
    private PlatformRestRepository platformRepository;

    public Game createGameWithAssociations(GameDTO request) {
        try {

            Game existingGame = gameRepository.findByGameName(request.getName());
            if (existingGame != null) {
                throw new IllegalArgumentException("A game with the same name already exists");
            }

            Game newGame = new Game();
            if (request.getName() != null) {
                newGame.setGameName(request.getName());
            } else {
                throw new Error("Game Name Is Null In The Request");
            }
            if (request.getReleaseDate() != null) {
                newGame.setReleaseDate(request.getReleaseDate());
            } else {
                throw new Error("Release Date Is Null In Request");
            }


            setPublisher(request, newGame);

            setPlatforms(request, newGame);

            setGenres(request, newGame);

            return gameRepository.save(newGame);
        } catch (Error e) {
            System.out.println(e);
        }
        return null;
    }

    // helper method for publisher
    private void setPublisher(GameDTO request, Game game) {
        if (request.getGamePublisher() != null) {
            String publisherName = request.getGamePublisher();
            Publisher existingPublisher = publisherRepository.findByPublisherName(publisherName);

            if (existingPublisher == null) {
                existingPublisher = new Publisher();
                existingPublisher.setPublisherName(publisherName);
                publisherRepository.save(existingPublisher);
            }

            game.setGamePublisher(existingPublisher);
        } else {
            throw new IllegalArgumentException("Publisher Is Null In The Request");
        }
    }


    public void setGenres(GameDTO request, Game game) {
        if (request.getGenres() != null) {
            List<GenreDTO> genreDTOS = request.getGenres();
            List<Genre> genre = new ArrayList<>();

            for (GenreDTO genres : genreDTOS) {
                Genre existingGenre = genreRepository.findByGenreName(genres.getGenreName());
                if (existingGenre == null) {
                    existingGenre = new Genre();
                    existingGenre.setGenreName(genres.getGenreName());
                    genreRepository.save(existingGenre);
                }
                genre.add(existingGenre);
            }

            game.setListOfGenres(genre);
        } else {
            throw new IllegalArgumentException("Genres Are Null In The Request");
        }

    }

    private void setPlatforms(GameDTO request, Game game) {
        if (request.getPlatforms() != null) {
            List<PlatformDTO> platformDTOS = request.getPlatforms();
            List<Platform> platforms = new ArrayList<>();

            for (PlatformDTO platform : platformDTOS) {
                Platform existingPlatform = platformRepository.findByPlatformName(platform.getPlatformName());
                if (existingPlatform == null) {
                    existingPlatform = new Platform();
                    existingPlatform.setPlatformName(platform.getPlatformName());
                    platformRepository.save(existingPlatform);
                }
                platforms.add(existingPlatform);
            }

            game.setGamePlatform(platforms);
        } else {
            throw new IllegalArgumentException("Platforms Are Null In The Request");
        }
    }
}


