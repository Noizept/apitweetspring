package com.sergio.restapi.Service.AnimeNewsService;

import com.sergio.restapi.DTO.Tweet;
import com.sergio.restapi.Repository.Animenews.IAnimeNewsRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class IAnimeNewServiceImpl implements IAnimeNewService {

    @Autowired
    IAnimeNewsRepo animeNewsRepo;
    @Autowired
    ModelMapper modelMapper;


    @Override
    public Tweet getById(Integer Id) {
        return modelMapper.map(animeNewsRepo.getById(Id),Tweet.class);
    }

    @Override
    public List<Tweet> getAll() {
        return Arrays.asList(modelMapper.map(animeNewsRepo.getAll(), Tweet[].class));
    }

    @Override
    public List<Tweet> getLatest(Integer limit) {
        return Arrays.asList(modelMapper.map(animeNewsRepo.getLatest(limit), Tweet[].class));

    }
}
