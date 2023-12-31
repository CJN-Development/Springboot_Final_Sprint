package com.keyin.restrepos;

import com.keyin.entities.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
@RepositoryRestResource(collectionResourceRel = "publisher", path = "publisher")
@CrossOrigin
public interface PublisherRestRepository extends JpaRepository<Publisher, Long> {
        Publisher findByPublisherName(String publisherName);
}
