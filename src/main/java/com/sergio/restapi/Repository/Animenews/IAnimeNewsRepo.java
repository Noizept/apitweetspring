package com.sergio.restapi.Repository.Animenews;

import com.sergio.restapi.Entity.AnimeNew;

import java.util.List;

public interface IAnimeNewsRepo {

    List<AnimeNew> getAll();
    AnimeNew getById(Integer Id);
    void save(AnimeNew entity);
    void saveAll(List<AnimeNew> Entities);
    Integer count();
    void truncate();
    List<AnimeNew> getLatest(Integer total);
    AnimeNew getLastTweet();


}
