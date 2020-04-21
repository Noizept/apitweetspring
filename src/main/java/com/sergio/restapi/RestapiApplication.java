package com.sergio.restapi;

import com.sergio.restapi.DTO.Tweet;
import com.sergio.restapi.Entity.AnimeNew;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class RestapiApplication {

    public static void main(String[] args) {
        SpringApplication.run(RestapiApplication.class, args);
    }

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.addMappings(new PropertyMap<AnimeNew, Tweet>() {
            @Override
            protected void configure() {
                map().setId(source.getId());
                map().setTitle(source.getTitle());
                map().setNewUrl(source.getLink());
                map().setAnimeUrl(source.getGuid());
                map().setDescription(source.getDescription());
                map().setPublished_at(source.getPubDate());
                map().setCategory(source.getCategory());
            }
        });


        return modelMapper;
    }
}
