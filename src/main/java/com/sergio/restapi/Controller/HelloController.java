package com.sergio.restapi.Controller;


import com.sergio.restapi.DTO.Tweet;
import com.sergio.restapi.Service.AnimeNewsService.IAnimeNewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "hello")
public class HelloController {

    @Autowired
    IAnimeNewService animeService;

    @GetMapping("/joe")
    public List<Tweet> getHello(){
        return animeService.getAll();
    }
}
