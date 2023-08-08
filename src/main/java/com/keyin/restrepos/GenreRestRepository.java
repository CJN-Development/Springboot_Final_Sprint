package com.keyin.restrepos;

import com.keyin.entities.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "genre", path = "genre")
public interface GenreRestRepository extends JpaRepository<Genre, Long> {

    //Platform findByGenreName(String genreName);


}
