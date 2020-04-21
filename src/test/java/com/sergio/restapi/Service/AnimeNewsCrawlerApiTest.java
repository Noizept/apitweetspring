package com.sergio.restapi.Service;

import com.rometools.rome.io.XmlReader;
import com.sergio.restapi.Entity.AnimeNew;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class AnimeNewsCrawlerApiTest {

    private XmlReader xmlRead;
    private List<AnimeNew> animeList;


    @Test
    public void ItShouldHaveWaveAnime() {
        AnimeNew anime = new AnimeNew(
                "Wave, Listen to Me!  Episode 3",
                "http://www.animenewsnetwork.com/review/wave-listen-to-me/episode-3/.158740",
                "https://www.animenewsnetwork.com/cms/.158740",
                "Having officially been canned from Voyager, Minare's existential and financial crisis is the focus of much of the plot",
                new Date("Sat, 18 Apr 2020 19:00:00 -0400"),
                "Anime");
        assertEquals(anime.getTitle(), animeList.get(0).getTitle());
       // assertEquals(anime.getPubDate(), animeList.get(0).getPubDate());
    }

    @Test
    public void ItShouldHaveThreeEntries() {
        assertEquals(3, animeList.size());
    }


    @BeforeAll
    public void init() throws IOException {
        String rawRSS = "<rss version=\"2.0\">\n" +
                "<channel>\n" +
                "<title>Anime News Network</title>\n" +
                "<link>https://www.animenewsnetwork.com/</link>\n" +
                "<description>ANN RSS feed</description>\n" +
                "<language>en-US</language>\n" +
                "<copyright>\n" +
                "All material Copyright 1998-2020 Anime News Network\n" +
                "</copyright>\n" +
                "<lastBuildDate>Sat, 18 Apr 2020 19:14:27 -0400</lastBuildDate>\n" +
                "<item>\n" +
                "<title>Wave, Listen to Me!  Episode 3</title>\n" +
                "<link>\n" +
                "http://www.animenewsnetwork.com/review/wave-listen-to-me/episode-3/.158740\n" +
                "</link>\n" +
                "<guid isPermaLink=\"true\">https://www.animenewsnetwork.com/cms/.158740</guid>\n" +
                "<description>\n" +
                "Having officially been canned from Voyager, Minare's existential and financial crisis is the focus of much of the plot\n" +
                "</description>\n" +
                "<pubDate>Sat, 18 Apr 2020 19:00:00 -0400</pubDate>\n" +
                "<category>Anime</category>\n" +
                "</item>\n" +
                "<item>\n" +
                "<title>\n" +
                "Kagaku Manga Survival Study Manga Series Gets Anime Film on July 31\n" +
                "</title>\n" +
                "<link>\n" +
                "http://www.animenewsnetwork.com/news/2020-04-18/kagaku-manga-survival-study-manga-series-gets-anime-film-on-july-31/.158733\n" +
                "</link>\n" +
                "<guid isPermaLink=\"true\">https://www.animenewsnetwork.com/cms/.158733</guid>\n" +
                "<description>\n" +
                "Film to screen alongside <cite>Ganbareiwa!! Robocon</cite> film in screenings\n" +
                "</description>\n" +
                "<pubDate>Sat, 18 Apr 2020 18:00:00 -0400</pubDate>\n" +
                "<category>Anime</category>\n" +
                "<category>Manga</category>\n" +
                "</item>\n" +
                "<item>\n" +
                "<title>Arte ‒ Episode 1, 2, & 3</title>\n" +
                "<link>\n" +
                "http://www.animenewsnetwork.com/review/arte/episode-1-2-and-3/.158736\n" +
                "</link>\n" +
                "<guid isPermaLink=\"true\">https://www.animenewsnetwork.com/cms/.158736</guid>\n" +
                "<description>\n" +
                "“Whoever wants to do things as they wish ought to take care not to be born a woman.”\n" +
                "</description>\n" +
                "<pubDate>Sat, 18 Apr 2020 17:58:39 -0400</pubDate>\n" +
                "<category>Anime</category>\n" +
                "</item>\n" +
                "</channel>\n" +
                "</rss>";
        InputStream xmlStream = new ByteArrayInputStream(rawRSS.getBytes());
        xmlRead = new XmlReader(xmlStream);
        animeList = AnimeNewsCrawlerApi.parseRSS(xmlRead);

    }

}