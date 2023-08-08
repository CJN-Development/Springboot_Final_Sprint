package com.keyin.restrepos;

import com.keyin.entities.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "Game", path = "Game")
public interface GameRestRepository extends JpaRepository<Game, Long> {
    Game findByGameName(String gameName);
}
