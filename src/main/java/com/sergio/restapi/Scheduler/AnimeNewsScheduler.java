package com.sergio.restapi.Scheduler;


import com.sergio.restapi.Entity.AnimeNew;
import com.sergio.restapi.Repository.Animenews.IAnimeNewsRepo;
import com.sergio.restapi.Service.AnimeNewsCrawlerApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;


@Component
public class AnimeNewsScheduler {

    @Autowired
    IAnimeNewsRepo animeNewsRepo;

    /**
     * Schedule/Cron job that updates database tweets
     * @throws IOException
     */
    @Scheduled(fixedRate = 600000)
    public void UpdateDatabase() throws IOException {
        /*
        * The idea here is.. instead of blindly truncate and getting new information i tried to do
        * Some kind of UPSERT/MERGE but with the jdbc driver and H2 i couldn't find something for this
        * So what i did was...
        * Get the last record inserted from the DB and then filter the new array from the external API
        *
        * NOTE: There might be a bug with inserting duplicate record if something was introduced at the same
        * date + time exactly, for this API since its simple and without many tweets I left it like this
        */

        List<AnimeNew> animeObjects = AnimeNewsCrawlerApi.getAnimeNews();
        AnimeNew lastTweet;
        try{
            lastTweet=animeNewsRepo.getLastTweet();
        }catch(EmptyResultDataAccessException e){
            lastTweet=null;
        }
        AnimeNew finalLastTweet = lastTweet;
        List<AnimeNew> myFinalList;
        if (lastTweet == null) {
            myFinalList=animeObjects;
        } else {
            myFinalList = animeObjects.stream()
                    .filter(tweet -> tweet.getPubDate().compareTo(finalLastTweet.getPubDate()) > 0 || tweet.getPubDate().compareTo(finalLastTweet.getPubDate()) == 0)
                    .collect(Collectors.toList());
        }
        animeNewsRepo.saveAll(myFinalList);
    }
}