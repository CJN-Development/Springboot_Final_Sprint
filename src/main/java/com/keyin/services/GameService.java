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

        try{
            Game newGame = new Game();
            if(request.getName() != null){
                newGame.setGameName(request.getName());


            } else {
                throw new Error("Game Name Is Null In The Request");
            }

            if(request.getReleaseDate() != null){
                newGame.setReleaseDate(request.getReleaseDate());


            } else{
                throw  new Error("Release Date Is Null In Request");
            }

            Publisher publisher = new Publisher();
            publisher.setPublisherName(request.getGamePublisher());
            newGame.setGamePublisher(publisher);

            createGenreAssociation(request,newGame);



//            if(request.getGenres() != null){
//                List<GenreDTO> genreDTOs = request.getGenres();
//                List<Genre> genres = new ArrayList<>();
//
//                for (GenreDTO genre : genreDTOs) {
//                    Genre createdGenre = new Genre();
//                    createdGenre.setGenreName(genre.getGenreName());
//                    genres.add(createdGenre);
//                }
//                newGame.setListOfGenres(genres);
//
//            } else{
//                throw new Error("Genre Is Null In The Request");
//            }


            if(request.getPlatforms() != null){
                List<PlatformDTO> platformDTOS = request.getPlatforms();
                List<Platform> platforms = new ArrayList<>();


                for (PlatformDTO platform : platformDTOS) {
                    Platform createdPlatform = new Platform();
                    createdPlatform.setPlatformName(platform.getPlatformName());
                    platforms.add(createdPlatform);
                }
                newGame.setGamePlatform(platforms);


            } else {
                throw  new Error("Platform Is Null in The Request");
            }
            return gameRepository.save(newGame);

        } catch(Error e){
            System.out.println(e);


        }


        return null;
    }


    public void createGenreAssociation(GameDTO request, Game game){
        if(request.getGenres() != null){
            List<GenreDTO> genreDTOs = request.getGenres();
            List<Genre> genres = new ArrayList<>();

            for (GenreDTO genre : genreDTOs) {
                Genre createdGenre = new Genre();
                createdGenre.setGenreName(genre.getGenreName());
                genres.add(createdGenre);
            }
            game.setListOfGenres(genres);

        } else{
            throw new Error("Genre Is Null In The Request");
        }

    }


}


