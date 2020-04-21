package com.sergio.restapi.DTO;


import lombok.*;

import java.util.Date;

@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@NoArgsConstructor
public class Tweet {

    private Integer id;
    @NonNull private  String title;
    @NonNull private  String newUrl;
    @NonNull private  String animeUrl;
    @NonNull private  String description;
    @NonNull private  Date published_at;
    @NonNull private  String category;

}