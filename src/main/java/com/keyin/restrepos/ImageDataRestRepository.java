package com.keyin.restrepos;

import com.keyin.dto.GameDTO;
import com.keyin.entities.ImageData;
import com.keyin.entities.Platform;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

public interface ImageDataRestRepository extends JpaRepository<ImageData, Long>  {

    ImageData findByImageData(String imageData);
}
