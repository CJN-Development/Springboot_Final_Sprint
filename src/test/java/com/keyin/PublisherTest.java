package com.keyin;

import com.keyin.entities.Publisher;
import com.keyin.restrepos.PublisherRestRepository;
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
public class PublisherTest {

    @Mock
    private PublisherRestRepository publisherRestRepository;

    @Test
    @DisplayName("Testing Find ALl Publishers Method")
    public void testFindAllPublisher() {
        Publisher publisher1 = new Publisher();
        publisher1.setPublisherName("Nintendo");
        publisher1.setId(1L);

        Publisher publisher2 = new Publisher();
        publisher2.setPublisherName("Square Enix");
        publisher2.setId(2L);

        List<Publisher> publisherList = Arrays.asList(publisher1, publisher2);

        when(publisherRestRepository.findAll()).thenReturn(publisherList);

        List<Publisher> result = publisherRestRepository.findAll();

        Assertions.assertEquals(2, result.size());

        Assertions.assertEquals(publisher1, result.get(0));
        Assertions.assertEquals(publisher2, result.get(1));
        Assertions.assertNotEquals(3, result.size());
    }

    @Test
    @DisplayName("Testing Create Publisher")
    public void testCreatePub(){

        Publisher publisher1 = new Publisher();
        publisher1.setPublisherName("Nintendo");
        publisher1.setId(1L);

        Publisher publisher2 = new Publisher();
        publisher2.setPublisherName("Square Enix");
        publisher2.setId(2L);


        List<Publisher> pubList = Arrays.asList(publisher1,publisher2);

        Assertions.assertTrue(pubList.contains(publisher1) && pubList.contains(publisher2));

    }
    @Test
    @DisplayName("Testing Find Publisher By ID")
    public void findPubById(){
        Publisher publisher1 = new Publisher();
        publisher1.setPublisherName("Nintendo");
        publisher1.setId(1L);

        when(publisherRestRepository.findById(publisher1.getId())).thenReturn(Optional.of(publisher1));

        Optional<Publisher> result = publisherRestRepository.findById(publisher1.getId());

        Assertions.assertEquals(publisher1, result.get());
    }

    @Test
    @DisplayName("Testing Delete Publisher By ID")
    public void deletePubById(){
        Publisher publisher1 = new Publisher();
        publisher1.setPublisherName("Nintendo");
        publisher1.setId(1L);

        Publisher publisher2 = new Publisher();
        publisher2.setPublisherName("Square Enix");
        publisher2.setId(2L);

        Publisher publisher3 = new Publisher();
        publisher3.setPublisherName("Microsoft");
        publisher3.setId(3L);

        publisherRestRepository.deleteById(publisher1.getId());

        verify(publisherRestRepository,times(1)).deleteById(publisher1.getId());

    }

    @Test
    @DisplayName("Testing Count Publishers Method")
    public  void testCountPublishers(){
        Publisher publisher1 = new Publisher();
        publisher1.setPublisherName("Nintendo");
        publisher1.setId(1L);

        Publisher publisher2 = new Publisher();
        publisher2.setPublisherName("Square Enix");
        publisher2.setId(2L);

        Publisher publisher3 = new Publisher();
        publisher3.setPublisherName("Microsoft");
        publisher3.setId(3L);

        List<Publisher> publisherList = Arrays.asList(publisher1,publisher2,publisher3);

        when(publisherRestRepository.count()).thenReturn((long) publisherList.size());

        long count = publisherRestRepository.count();

        Assertions.assertEquals(publisherList.size(),count);


    }


}

