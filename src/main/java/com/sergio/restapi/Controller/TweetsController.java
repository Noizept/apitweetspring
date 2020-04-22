package com.sergio.restapi.Controller;

import com.sergio.restapi.DTO.Tweet;
import com.sergio.restapi.Service.AnimeNewsService.IAnimeNewServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "tweets")
public class TweetsController {

    @Autowired
    IAnimeNewServiceImpl animeNewService;

    @GetMapping("")
    @ResponseStatus(code =HttpStatus.OK)
    public List<Tweet> Get(){
        return animeNewService.getAll();
    }

    @GetMapping("/latest")
    @ResponseStatus(code =HttpStatus.OK)
    public List<Tweet> GetLatest(@RequestParam(required = false) Integer limit){
        if(limit!=null)
            return animeNewService.getLatest(limit);
        return animeNewService.getLatest(10);
    }

    @GetMapping(path = "/{id}")
    @ResponseStatus(code =HttpStatus.OK)
    public Tweet GetById(@PathVariable("id") Integer Id){
        return animeNewService.getById(Id);
    }

}
