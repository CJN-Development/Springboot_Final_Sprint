package com.keyin.restrepos;

import com.keyin.entities.Genre;
import com.keyin.entities.Platform;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "platform", path = "platform")
public interface PlatformRestRepository extends JpaRepository<Platform, Long> {

    Platform findByPlatformName(String platformName);

    List<Platform> findByPlatformNameIn(List<Platform> platformName);






}
