package com.tweteroo.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.tweteroo.api.models.Tweet;
import com.tweteroo.api.models.Users;
import com.tweteroo.api.repositories.TweetRepository;
import com.tweteroo.api.repositories.UserRepository;

@Service
public class TweetService {

    @Autowired
    private TweetRepository repository;

    @Autowired
    private UserRepository userRepository;

    public boolean create(Tweet data) {
        List <Users> user = userRepository.findByUsername(data.getUsername());

        if(user.size() >= 1){            
            data.setAvatar(user.get(0).getAvatar());
            repository.save(data);
            return true;
        
        }
       
        return false;
      
    }

    public Page<Tweet>findAll(String paging ){
        int page= Integer.parseInt(paging);
        int size=5;

        Pageable pageRequest = PageRequest.of(page, size, Sort.Direction.DESC, "id");
        return repository.findAll(pageRequest);
    }

    public List<Tweet> findByUsername(String username){
         return repository.findByUsername(username);
    }


  
}
