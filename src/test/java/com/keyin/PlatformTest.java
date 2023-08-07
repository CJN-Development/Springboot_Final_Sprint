package com.keyin;

import com.keyin.entities.Platform;
import com.keyin.restrepos.PlatformRestRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;

@SpringBootTest
public class PlatformTest {

    @Mock
    private PlatformRestRepository platformRestRepository;
    @Test
    @DisplayName("Testing Find ALl Platforms Method")
    public void testFindAllPlatforms(){

        Platform platform1 = new Platform();

        platform1.setPlatformName("PC");
        platform1.setId(1L);
        Platform platform2 = new Platform();
        platform2.setId(2L);
        platform2.setPlatformName("Xbox");

        List<Platform> platformList = Arrays.asList(platform1,platform2);

        when(platformRestRepository.findAll()).thenReturn(platformList);

        List<Platform> result = platformRestRepository.findAll();

        Assertions.assertEquals(2,result.size());

        Assertions.assertEquals(platform1,result.get(0));
        Assertions.assertEquals(platform2,result.get(1));
        Assertions.assertNotEquals(3, result.size());


    }

    @Test
    @DisplayName("Testing Create")
    public void testCreate(){

        Platform platform1 = new Platform();

        platform1.setPlatformName("PC");
        platform1.setId(1L);
        Platform platform2 = new Platform();
        platform2.setId(2L);
        platform2.setPlatformName("Xbox");

        List<Platform> platformList = Arrays.asList(platform1,platform2);

        Assertions.assertTrue(platformList.contains(platform1) && platformList.contains(platform2));

    }

    @Test
    @DisplayName("Testing Find By ID")
    public void findById(){
        Platform platform1 = new Platform();
        platform1.setPlatformName("Xbox");
        platform1.setId(1L);

        when(platformRestRepository.findById(platform1.getId())).thenReturn(Optional.of(platform1));

        Optional<Platform> result = platformRestRepository.findById(platform1.getId());

        Assertions.assertEquals(platform1, result.get());
    }

    @Test
    @DisplayName("Testing Delete By ID")
    public void deleteById(){
        Platform platform1 = new Platform();
        platform1.setPlatformName("Xbox");
        platform1.setId(1L);

        Platform platform2 = new Platform();
        platform2.setPlatformName("Playstation");
        platform2.setId(2L);

        Platform platform3 = new Platform();
        platform3.setPlatformName("PC");
        platform3.setId(3L);

        platformRestRepository.deleteById(platform1.getId());

        verify(platformRestRepository,times(1)).deleteById(platform1.getId());

    }

    @Test
    @DisplayName("Testing Count Method")
    public  void testCountPlatforms(){
        Platform platform1 = new Platform();
        platform1.setPlatformName("Xbox");
        platform1.setId(1L);

        Platform platform2 = new Platform();
        platform2.setPlatformName("Playstation");
        platform2.setId(2L);

        Platform platform3 = new Platform();
        platform3.setPlatformName("PC");
        platform3.setId(3L);

        List<Platform> platformList = Arrays.asList(platform1,platform2,platform3);

        when(platformRestRepository.count()).thenReturn((long) platformList.size());

        long count = platformRestRepository.count();

        Assertions.assertEquals(platformList.size(),count);


    }


}
