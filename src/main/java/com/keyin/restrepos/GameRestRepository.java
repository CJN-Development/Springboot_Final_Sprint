package com.keyin.restrepos;

import com.keyin.entities.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;


@RepositoryRestResource(collectionResourceRel = "game", path = "game")
@CrossOrigin
public interface GameRestRepository extends JpaRepository<Game, Long> {
    Game findByGameName(String gameName);
}
