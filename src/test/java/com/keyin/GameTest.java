package com.keyin;

import com.keyin.entities.Game;
import com.keyin.entities.Game;
import com.keyin.restrepos.GameRestRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;

@SpringBootTest
public class GameTest {

    @Mock
    private GameRestRepository gameRestRepository;

    @Test
    @DisplayName("Testing Find All Games Method")
    public void testFindAllGames(){

        Game game1 = new Game();

        game1.setGameName("Red Dead Redemption 2");
        game1.setId(1L);
        game1.setReleaseDate("10/26/2018");

        Game game2 = new Game();

        game2.setGameName("Sly 2: Band of Thieves");
        game2.setId(2L);
        game2.setReleaseDate("09/14/2004");

        List<Game> gameList = Arrays.asList(game1, game2);

        when(gameRestRepository.findAll()).thenReturn(gameList);

        List<Game> result = gameRestRepository.findAll();

        Assertions.assertEquals(2, result.size());

        Assertions.assertEquals(game1,result.get(0));
        Assertions.assertEquals(game2,result.get(1));
        Assertions.assertNotEquals(3, result.size());
    }

    @Test
    @DisplayName("Testing Create")
    public void testCreate(){

        Game game1 = new Game();

        game1.setGameName("Red Dead Redemption 2");
        game1.setId(1L);
        game1.setReleaseDate("10/26/2018");

        Game game2 = new Game();

        game2.setGameName("Sly 2: Band of Thieves");
        game2.setId(2L);
        game2.setReleaseDate("09/14/2004");

        List<Game> gameList = Arrays.asList(game1, game2);

        Assertions.assertTrue(gameList.contains(game1) && gameList.contains(game2));
    }

    @Test
    @DisplayName("Testing Find By ID")
    public void findById(){

        Game game1 = new Game();

        game1.setGameName("Red Dead Redemption 2");
        game1.setId(1L);
        game1.setReleaseDate("10/26/2018");

        when(gameRestRepository.findById(game1.getId())).thenReturn(Optional.of(game1));

        Optional<Game> result = gameRestRepository.findById(game1.getId());

        Assertions.assertEquals(game1, result.get());
    }

    @Test
    @DisplayName("Testing Delete By ID")
    public void deleteById(){

        Game game1 = new Game();

        game1.setGameName("Red Dead Redemption 2");
        game1.setId(1L);
        game1.setReleaseDate("10/26/2018");

        Game game2 = new Game();

        game2.setGameName("Sly 2: Band of Thieves");
        game2.setId(2L);
        game2.setReleaseDate("09/14/2004");

        Game game3 = new Game();

        game3.setGameName("Ghost of Tsushima");
        game3.setId(3L);
        game3.setReleaseDate("07/17/2020");

        gameRestRepository.deleteById(game1.getId());

        verify(gameRestRepository,times(1)).deleteById(game1.getId());
    }

    @Test
    @DisplayName("Testing Count Method")
    public  void testCountPlatforms(){

        Game game1 = new Game();

        game1.setGameName("Red Dead Redemption 2");
        game1.setId(1L);
        game1.setReleaseDate("10/26/2018");

        Game game2 = new Game();

        game2.setGameName("Sly 2: Band of Thieves");
        game2.setId(2L);
        game2.setReleaseDate("09/14/2004");

        Game game3 = new Game();

        game3.setGameName("Ghost of Tsushima");
        game3.setId(3L);
        game3.setReleaseDate("07/17/2020");

        List<Game> gameList = Arrays.asList(game1, game2, game3);

        when(gameRestRepository.count()).thenReturn((long) gameList.size());

        long count = gameRestRepository.count();

        Assertions.assertEquals(gameList.size(),count);
    }
}
