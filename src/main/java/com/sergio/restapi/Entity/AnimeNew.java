package com.sergio.restapi.Entity;


import lombok.*;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

// https://www.animenewsnetwork.com/all/rss.xml?ann-edition=us


@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@NoArgsConstructor
public class AnimeNew {

    private Integer id;
    @NonNull private  String title;
    @NonNull private  String link;
    @NonNull private  String guid;
    @NonNull private  String description;

    @Temporal(TemporalType.TIMESTAMP)
    @NonNull
    private  Date pubDate;

    @NonNull private  String category;
    private  Date createdDate;




    @Override
    public String toString() {
        return "AnimeNew{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", link='" + link + '\'' +
                ", guid='" + guid + '\'' +
                ", description='" + description + '\'' +
                ", pubDate=" + pubDate +
                ", category='" + category + '\'' +
                ", createdDate=" + createdDate +
                '}';
    }
}