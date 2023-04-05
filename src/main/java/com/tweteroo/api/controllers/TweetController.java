package com.tweteroo.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.tweteroo.api.dto.TweetDTO;
import com.tweteroo.api.models.Tweet;
import com.tweteroo.api.services.TweetService;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/tweets")
public class TweetController {
    
    @Autowired
    private TweetService service; 

    @ResponseStatus(value = HttpStatus.CREATED)
    @PostMapping    
    public void create(@RequestBody @Valid TweetDTO req){
        service.create(new Tweet(req));
    }

    @GetMapping
    public List<Tweet> getAll() {
        return service.findAll();
    }
    
        
}
