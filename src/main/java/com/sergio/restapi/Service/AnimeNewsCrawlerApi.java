package com.sergio.restapi.Service;

import com.rometools.rome.feed.synd.SyndEntry;
import com.rometools.rome.feed.synd.SyndFeed;
import com.rometools.rome.io.SyndFeedInput;
import com.rometools.rome.io.XmlReader;
import com.sergio.restapi.Entity.AnimeNew;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class AnimeNewsCrawlerApi {
    private static final String uri = "https://www.animenewsnetwork.com/all/rss.xml?ann-edition=us";

    public static List<AnimeNew> getAnimeNews() throws IOException {
       return  parseRSS(getRomeXML());
    }

    private static XmlReader getRomeXML() throws IOException {
        return new XmlReader(new URL(uri));
    }

    public static List<AnimeNew> parseRSS(XmlReader aXmlReader) {
        List<AnimeNew> animeEntries = new ArrayList<>();
        try {
            try (XmlReader reader = aXmlReader) {
                SyndFeed feed = new SyndFeedInput().build(reader);
                for (SyndEntry entry : feed.getEntries()) {
                    AnimeNew anime = new AnimeNew(
                            entry.getTitle(),
                            entry.getLink(),
                            entry.getUri(),
                            entry.getDescription().getValue(),
                            entry.getPublishedDate(),
                            entry.getCategories().get(0).getName());
                    animeEntries.add(anime);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return animeEntries;

    }

}
