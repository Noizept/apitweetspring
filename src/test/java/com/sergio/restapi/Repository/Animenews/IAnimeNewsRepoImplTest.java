package com.sergio.restapi.Repository.Animenews;

import com.sergio.restapi.Entity.AnimeNew;
import com.sergio.restapi.RestapiApplication;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest(classes = RestapiApplication.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class IAnimeNewsRepoImplTest {

    @Autowired
    IAnimeNewsRepo animeRepo;
    List<AnimeNew> animeList;

    @Test
    @Order(1)
    void CountShouldBeZeroInitialy() {
        assertEquals(0,animeRepo.count());
    }

    @Test
    @Order(2)
    void CountShouldBeOneAfterInsert() {
        animeRepo.save(animeList.get(0));
        assertEquals(1,animeRepo.count());
    }

    @Test
    @Order(3)
    void GetRecordWithIdOne() {
        AnimeNew anime = animeRepo.getById(1);
        assertEquals(1,anime.getId());
        assertEquals("Wave, Listen to Me!  Episode 3",anime.getTitle());
    }

    @Test
    @Order(4)
    void CountShouldBeZeroAfterTruncate(){
        animeRepo.truncate();
        assertEquals(0,animeRepo.count());
    }

    @Test
    @Order(5)
    void ShouldSaveAllTwentyInstances() {
        animeRepo.saveAll(animeList);
        assertEquals(20,animeRepo.count());
    }

    @Test
    @Order(6)
    void ShouldReturnListOfTwentyAnimes() {
        List<AnimeNew> animes=animeRepo.getAll();
        assertEquals(20,animes.size());
    }
    @Test
    @Order(7)
    void ShouldReturnTheLastTweet(){
        AnimeNew anime=animeRepo.getLastTweet();
        assertEquals("Bleach",anime.getTitle());
    }

    @Test
    @Order(8)
    void ShouldReturnTenTweets(){
        List<AnimeNew> anime=animeRepo.getLatest(10);
        assertEquals(10,anime.size());
    }



    @BeforeAll
    void initList(){
       animeList =new ArrayList<AnimeNew>(){{
            add(new AnimeNew(
                    "Wave, Listen to Me!  Episode 3",
                    "http://www.animenewsnetwork.com/review/wave-listen-to-me/episode-3/.158740",
                    "https://www.animenewsnetwork.com/cms/.158740",
                    "Having officially been canned from Voyager, Minare's existential and financial crisis is the focus of much of the plot",
                    new Date(),
                    "Anime"));
            add(new AnimeNew(
                    "Naruto",
                    "http://www.animenewsnetwork.com/review/wave-listen-to-me/episode-3/.158740",
                    "https://www.animenewsnetwork.com/cms/.158740",
                    "Having officially been canned from Voyager, Minare's existential and financial crisis is the focus of much of the plot",
                    new Date(),
                    "Anime"));
            add(new AnimeNew(
                    "Bleach",
                    "http://www.animenewsnetwork.com/review/wave-listen-to-me/episode-3/.158740",
                    "https://www.animenewsnetwork.com/cms/.158740",
                    "Having officially been canned from Voyager, Minare's existential and financial crisis is the focus of much of the plot",
                     new Date(new Date().getTime() + (1000 * 60 * 60 * 24)),
                    "Anime"));
            add(new AnimeNew(
                    "Doraemon",
                    "http://www.animenewsnetwork.com/review/wave-listen-to-me/episode-3/.158740",
                    "https://www.animenewsnetwork.com/cms/.158740",
                    "Having officially been canned from Voyager, Minare's existential and financial crisis is the focus of much of the plot",
                    new Date(),
                    "Anime"));
            add(new AnimeNew(
                    "Trigun",
                    "http://www.animenewsnetwork.com/review/wave-listen-to-me/episode-3/.158740",
                    "https://www.animenewsnetwork.com/cms/.158740",
                    "Having officially been canned from Voyager, Minare's existential and financial crisis is the focus of much of the plot",
                    new Date(),
                    "Anime"));
           add(new AnimeNew(
                   "Wave, Listen to Me!  Episode 3",
                   "http://www.animenewsnetwork.com/review/wave-listen-to-me/episode-3/.158740",
                   "https://www.animenewsnetwork.com/cms/.158740",
                   "Having officially been canned from Voyager, Minare's existential and financial crisis is the focus of much of the plot",
                   new Date(),
                   "Anime"));
           add(new AnimeNew(
                   "Naruto",
                   "http://www.animenewsnetwork.com/review/wave-listen-to-me/episode-3/.158740",
                   "https://www.animenewsnetwork.com/cms/.158740",
                   "Having officially been canned from Voyager, Minare's existential and financial crisis is the focus of much of the plot",
                   new Date(),
                   "Anime"));
           add(new AnimeNew(
                   "Bleach",
                   "http://www.animenewsnetwork.com/review/wave-listen-to-me/episode-3/.158740",
                   "https://www.animenewsnetwork.com/cms/.158740",
                   "Having officially been canned from Voyager, Minare's existential and financial crisis is the focus of much of the plot",
                   new Date(),
                   "Anime"));
           add(new AnimeNew(
                   "Doraemon",
                   "http://www.animenewsnetwork.com/review/wave-listen-to-me/episode-3/.158740",
                   "https://www.animenewsnetwork.com/cms/.158740",
                   "Having officially been canned from Voyager, Minare's existential and financial crisis is the focus of much of the plot",
                   new Date(),
                   "Anime"));
           add(new AnimeNew(
                   "Trigun",
                   "http://www.animenewsnetwork.com/review/wave-listen-to-me/episode-3/.158740",
                   "https://www.animenewsnetwork.com/cms/.158740",
                   "Having officially been canned from Voyager, Minare's existential and financial crisis is the focus of much of the plot",
                   new Date(),
                   "Anime"));
           add(new AnimeNew(
                   "Wave, Listen to Me!  Episode 3",
                   "http://www.animenewsnetwork.com/review/wave-listen-to-me/episode-3/.158740",
                   "https://www.animenewsnetwork.com/cms/.158740",
                   "Having officially been canned from Voyager, Minare's existential and financial crisis is the focus of much of the plot",
                   new Date(),
                   "Anime"));
           add(new AnimeNew(
                   "Naruto",
                   "http://www.animenewsnetwork.com/review/wave-listen-to-me/episode-3/.158740",
                   "https://www.animenewsnetwork.com/cms/.158740",
                   "Having officially been canned from Voyager, Minare's existential and financial crisis is the focus of much of the plot",
                   new Date(),
                   "Anime"));
           add(new AnimeNew(
                   "Bleach",
                   "http://www.animenewsnetwork.com/review/wave-listen-to-me/episode-3/.158740",
                   "https://www.animenewsnetwork.com/cms/.158740",
                   "Having officially been canned from Voyager, Minare's existential and financial crisis is the focus of much of the plot",
                   new Date(),
                   "Anime"));
           add(new AnimeNew(
                   "Doraemon",
                   "http://www.animenewsnetwork.com/review/wave-listen-to-me/episode-3/.158740",
                   "https://www.animenewsnetwork.com/cms/.158740",
                   "Having officially been canned from Voyager, Minare's existential and financial crisis is the focus of much of the plot",
                   new Date(),
                   "Anime"));
           add(new AnimeNew(
                   "Trigun",
                   "http://www.animenewsnetwork.com/review/wave-listen-to-me/episode-3/.158740",
                   "https://www.animenewsnetwork.com/cms/.158740",
                   "Having officially been canned from Voyager, Minare's existential and financial crisis is the focus of much of the plot",
                   new Date(),
                   "Anime"));
           add(new AnimeNew(
                   "Wave, Listen to Me!  Episode 3",
                   "http://www.animenewsnetwork.com/review/wave-listen-to-me/episode-3/.158740",
                   "https://www.animenewsnetwork.com/cms/.158740",
                   "Having officially been canned from Voyager, Minare's existential and financial crisis is the focus of much of the plot",
                   new Date(),
                   "Anime"));
           add(new AnimeNew(
                   "Naruto",
                   "http://www.animenewsnetwork.com/review/wave-listen-to-me/episode-3/.158740",
                   "https://www.animenewsnetwork.com/cms/.158740",
                   "Having officially been canned from Voyager, Minare's existential and financial crisis is the focus of much of the plot",
                   new Date(),
                   "Anime"));
           add(new AnimeNew(
                   "Bleach",
                   "http://www.animenewsnetwork.com/review/wave-listen-to-me/episode-3/.158740",
                   "https://www.animenewsnetwork.com/cms/.158740",
                   "Having officially been canned from Voyager, Minare's existential and financial crisis is the focus of much of the plot",
                   new Date(),
                   "Anime"));
           add(new AnimeNew(
                   "Doraemon",
                   "http://www.animenewsnetwork.com/review/wave-listen-to-me/episode-3/.158740",
                   "https://www.animenewsnetwork.com/cms/.158740",
                   "Having officially been canned from Voyager, Minare's existential and financial crisis is the focus of much of the plot",
                   new Date(),
                   "Anime"));
           add(new AnimeNew(
                   "Trigun",
                   "http://www.animenewsnetwork.com/review/wave-listen-to-me/episode-3/.158740",
                   "https://www.animenewsnetwork.com/cms/.158740",
                   "Having officially been canned from Voyager, Minare's existential and financial crisis is the focus of much of the plot",
                   new Date(),
                   "Anime"));
        }};
    }


}