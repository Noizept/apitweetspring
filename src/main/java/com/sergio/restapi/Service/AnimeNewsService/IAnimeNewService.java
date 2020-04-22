package com.sergio.restapi.Service.AnimeNewsService;

import com.sergio.restapi.DTO.Tweet;

import java.util.List;

public interface IAnimeNewService {
    Tweet getById(Integer Id);
    List<Tweet> getAll();
    List<Tweet> getLatest(Integer limit);
}
