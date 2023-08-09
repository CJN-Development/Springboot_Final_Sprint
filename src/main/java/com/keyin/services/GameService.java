package com.keyin.services;

import com.keyin.dto.GameDTO;
import com.keyin.dto.GenreDTO;
import com.keyin.dto.PlatformDTO;
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

import java.util.ArrayList;
import java.util.List;

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
        Game newGame = new Game();
        newGame.setGameName(request.getName());
        newGame.setReleaseDate(request.getReleaseDate());


        Publisher publisher = new Publisher();
        publisher.setPublisherName(request.getGamePublisher());
        newGame.setGamePublisher(publisher);

        // TODO: Model after platform below

        List<GenreDTO> genreDTOs = request.getGenres();
        List<Genre> genres = new ArrayList<>();

            for (GenreDTO genre : genreDTOs) {
                Genre createdGenre = new Genre();
                createdGenre.setGenreName(genre.getGenreName());
                genres.add(createdGenre);
            }
            newGame.setListOfGenres(genres);


        List<PlatformDTO> platformDTOS = request.getPlatforms();
        List<Platform> platforms = new ArrayList<>();


        for (PlatformDTO platform : platformDTOS) {
            Platform createdPlatform = new Platform();
            createdPlatform.setPlatformName(platform.getPlatformName());
            platforms.add(createdPlatform);
        }
        newGame.setGamePlatform(platforms);


        return gameRepository.save(newGame);
    }

//    public Game createGameWithAssociations(GameDTO request) {
//        Game newGame = new Game();
//        newGame.setGameName(request.getGameName());
//        newGame.setReleaseDate(request.getReleaseDate());
//
//        PublisherDTO publisherDTO = request.getGamePublisherName();
//
//        String publisherName = publisherDTO.getPublisherName();
//        Publisher publisher = publisherRepository.findByPublisherName(publisherName);
//
//        newGame.setGamePublisher(publisher);

//        Publisher publisher = publisherRepository.findByPublisherName(request.getGamePublisherName());
//        if (request.getGamePublisherName() != null) {
//
//            newGame.setGamePublisher(publisher);
//        }
//
//        if (request.getGenreNames() != null) {
//            List<Genre> genres = genreRepository.findByGenreNameIn(request.getGenreNames());
//            newGame.setListOfGenres(genres);
//        }
//
//        if (request.getGamePlatformNames() != null) {
//            List<Platform> platforms = platformRepository.findByPlatformNameIn(request.getGamePlatformNames());
//
//            newGame.setGamePlatform(platforms);
//        }

//        return gameRepository.save(newGame);
//    }


}
