package com.keyin.services;

import com.keyin.dto.GameDTO;
import com.keyin.entities.Game;
import com.keyin.entities.Publisher;
import com.keyin.restrepos.GameRestRepository;
import com.keyin.restrepos.GenreRestRepository;
import com.keyin.restrepos.PlatformRestRepository;
import com.keyin.restrepos.PublisherRestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

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
        newGame.setGameName(request.getGameName());
        newGame.setGamePublisher(publisherRepository.findById(request.getGamePublisherId()));

        Long publisherId = request.getGamePublisherId();
        if (publisherId != null) {
            Publisher publisher = publisherRepository.findById(publisherId)
                    .orElseThrow(() -> new EntityNotFoundException("Publisher with ID " + publisherId + " not found"));
            newGame.setGamePublisher(publisher);
        }



        gameRepository.save(newGame);



        return newGame;
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
