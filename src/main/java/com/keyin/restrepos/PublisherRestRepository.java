package com.keyin.restrepos;


import com.keyin.entities.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@RepositoryRestResource(collectionResourceRel = "publisher", path = "publisher")
public interface PublisherRestRepository extends JpaRepository<Publisher, Long> {
//    List<Game> findByPublisherByName(Publisher publisher);
}
