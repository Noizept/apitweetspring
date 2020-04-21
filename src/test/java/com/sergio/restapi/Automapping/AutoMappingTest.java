package com.sergio.restapi.Automapping;

import com.sergio.restapi.DTO.Tweet;
import com.sergio.restapi.Entity.AnimeNew;
import com.sergio.restapi.RestapiApplication;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes = RestapiApplication.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class AutoMappingTest {

    private AnimeNew animeNew;

    @Autowired
    private ModelMapper modelMapper;

    @Test
    public void EntityAndDTOShouldMatch(){
        Tweet tweet = modelMapper.map(animeNew,Tweet.class);
        assertEquals(tweet.getAnimeUrl(),animeNew.getGuid());
        assertEquals(tweet.getNewUrl(),animeNew.getLink());
        assertEquals(tweet.getCategory(),animeNew.getCategory());
        assertEquals(tweet.getId(),animeNew.getId());
        assertEquals(tweet.getPublished_at(),animeNew.getPubDate());



    }



    @BeforeAll
    void init(){
         animeNew = new AnimeNew(
                "Wave, Listen to Me!  Episode 3",
                "http://www.animenewsnetwork.com/review/wave-listen-to-me/episode-3/.158740",
                "https://www.animenewsnetwork.com/cms/.158740",
                "Having officially been canned from Voyager, Minare's existential and financial crisis is the focus of much of the plot",
                new Date(),
                "Anime");

    }


}
