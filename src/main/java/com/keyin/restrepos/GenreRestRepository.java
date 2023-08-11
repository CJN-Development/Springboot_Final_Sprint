package com.keyin.restrepos;

import com.keyin.entities.Genre;
import com.keyin.entities.Platform;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;
@CrossOrigin(allowedHeaders = "*")
@RepositoryRestResource(collectionResourceRel = "genre", path = "genre")
public interface GenreRestRepository extends JpaRepository<Genre, Long> {

    Genre findByGenreName(String genreName);

    List<Genre> findByGenreNameIn(List<Genre> genreNames);

}
