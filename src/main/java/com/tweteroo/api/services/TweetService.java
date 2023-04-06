package com.tweteroo.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.tweteroo.api.models.Tweet;
import com.tweteroo.api.repositories.TweetRepository;

@Service
public class TweetService {

    @Autowired
    private TweetRepository repository;

    public void create(Tweet data) {
        repository.save(data);
    }

    public Page<Tweet>findAll(String paging){
        int page= Integer.parseInt(paging);
        int size=5;

        Pageable pageRequest = PageRequest.of(page, size, Sort.Direction.DESC, "id");
        return repository.findAll(pageRequest);
    }

    public List<Tweet> findByUsername(String username){
         return repository.findByUsername(username);
    }


  
}
