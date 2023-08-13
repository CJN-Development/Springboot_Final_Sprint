package com.keyin;

import com.keyin.entities.Genre;
import com.keyin.restrepos.GenreRestRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;

//public class GenreTest {
//    @Mock
//    private GenreRestRepository genreRestRepository;
//
//    @Test
//    @DisplayName("Testing Find All Genres Method")
//    public void testFindAllGenres(){
//
//        Genre genre1 = new Genre();
//
//        genre1.setGenreName("Single Player");
//        genre1.setId(1L);
//
//
//        Genre genre2 = new Genre();
//
//        genre2.setGenreName("Tester");
//        genre2.setId(2L);
//
//        List<Genre> genreList = Arrays.asList(genre1, genre2);
//
//        when(genreRestRepository.findAll()).thenReturn(genreList);
//
//        List<Genre> result = genreRestRepository.findAll();
//
//        Assertions.assertEquals(2, result.size());
//
//        Assertions.assertEquals(genre1,result.get(0));
//        Assertions.assertEquals(genre2,result.get(1));
//        Assertions.assertNotEquals(3, result.size());
//    }
//
//    @Test
//    @DisplayName("Testing Create")
//    public void testCreate(){
//
//        Genre genre1 = new Genre();
//
//        genre1.setGenreName("Single Player");
//        genre1.setId(1L);
//
//
//        Genre genre2 = new Genre();
//
//        genre2.setGenreName("Tester");
//        genre2.setId(2L);
//
//        List<Genre> genreList = Arrays.asList(genre1, genre2);
//
//        Assertions.assertTrue(genreList.contains(genre1) && genreList.contains(genre2));
//    }
//
//    @Test
//    @DisplayName("Testing Find By ID")
//    public void findById(){
//
//        Genre genre1 = new Genre();
//
//        genre1.setGenreName("Single Player");
//        genre1.setId(1L);
//
//
//        when(genreRestRepository.findById(genre1.getId())).thenReturn(Optional.of(genre1));
//
//        Optional<Genre> result = genreRestRepository.findById(genre1.getId());
//
//        Assertions.assertEquals(genre1, result.get());
//    }
//
//    @Test
//    @DisplayName("Testing Delete By ID")
//    public void deleteById(){
//
//        Genre genre1 = new Genre();
//
//        genre1.setGenreName("Single Player");
//        genre1.setId(1L);
//
//
//        Genre genre2 = new Genre();
//
//        genre2.setGenreName("Tester");
//        genre2.setId(2L);
//
//        genreRestRepository.deleteById(genre1.getId());
//
//        verify(genreRestRepository,times(1)).deleteById(genre1.getId());
//    }
//
//    @Test
//    @DisplayName("Testing Count Method")
//    public  void testCountPlatforms(){
//
//        Genre genre1 = new Genre();
//
//        genre1.setGenreName("Single Player");
//        genre1.setId(1L);
//
//
//        Genre genre2 = new Genre();
//
//        genre2.setGenreName("Tester");
//        genre2.setId(2L);
//
//        List<Genre> genreList = Arrays.asList(genre1, genre2);
//
//        when(genreRestRepository.count()).thenReturn((long) genreList.size());
//
//        long count = genreRestRepository.count();
//
//        Assertions.assertEquals(genreList.size(),count);
//    }
//}


@SpringBootTest
public class GenreTest {

    @Mock
    private GenreRestRepository genreRestRepository;

    @Test
    @DisplayName("Testing Find All Genre Method")
    public void testFindAllGenre(){

        Genre genre1 = new Genre();

        genre1.setGenreName("genreTest1");
        genre1.setId(1L);


        Genre genre2 = new Genre();

        genre2.setGenreName("genreTest2");
        genre2.setId(2L);


        List<Genre> genreList = Arrays.asList(genre1, genre2);

        when(genreRestRepository.findAll()).thenReturn(genreList);

        List<Genre> result = genreRestRepository.findAll();

        Assertions.assertEquals(2, result.size());

        Assertions.assertEquals(genre1,result.get(0));
        Assertions.assertEquals(genre2,result.get(1));
        Assertions.assertNotEquals(3, result.size());
    }

    @Test
    @DisplayName("Testing Create")
    public void testCreate(){

        Genre genre1 = new Genre();

        genre1.setGenreName("genreTest1");
        genre1.setId(1L);


        Genre genre2 = new Genre();

        genre2.setGenreName("genreTest2");
        genre2.setId(2L);



        List<Genre> genreList = Arrays.asList(genre1, genre2);

        Assertions.assertTrue(genreList.contains(genre1) && genreList.contains(genre2));
    }

    @Test
    @DisplayName("Testing Find By ID")
    public void findById(){

        Genre genre1 = new Genre();

        genre1.setGenreName("genreTest1");
        genre1.setId(1L);

        when(genreRestRepository.findById(genre1.getId())).thenReturn(Optional.of(genre1));

        Optional<Genre> result = genreRestRepository.findById(genre1.getId());

        Assertions.assertEquals(genre1, result.get());
    }

    @Test
    @DisplayName("Testing Delete By ID")
    public void deleteById(){

        Genre genre1 = new Genre();

        genre1.setGenreName("genreTest1");
        genre1.setId(1L);


        Genre genre2 = new Genre();

        genre2.setGenreName("genreTest2");
        genre2.setId(2L);



        genreRestRepository.deleteById(genre1.getId());

        verify(genreRestRepository,times(1)).deleteById(genre1.getId());
    }

    @Test
    @DisplayName("Testing Count Method")
    public  void testCountGenre(){

        Genre genre1 = new Genre();

        genre1.setGenreName("genreTest1");
        genre1.setId(1L);


        Genre genre2 = new Genre();

        genre2.setGenreName("genreTest2");
        genre2.setId(2L);


        List<Genre> genreList = Arrays.asList(genre1, genre2);

        when(genreRestRepository.count()).thenReturn((long) genreList.size());

        long count = genreRestRepository.count();

        Assertions.assertEquals(genreList.size(),count);
    }
}