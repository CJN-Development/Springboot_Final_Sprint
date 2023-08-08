package com.keyin.restrepos;

import com.keyin.entities.Genre;
import com.keyin.entities.Platform;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "genre", path = "genre")
public interface GenreRestRepository extends JpaRepository<Genre, Long> {

    List<Genre> findByGenreName(String genreName);

    List<Genre> findByGenreNameIn(List<Genre> genreNames);


}
