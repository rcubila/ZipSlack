package com.ZipSlack.service;


import com.ZipSlack.model.Joke;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class JokeService {

    public Joke getJoke(Joke joke) {
        try {
            RestTemplate restTemplate = new RestTemplate ();
            joke = restTemplate.getForObject ("https://08ad1pao69.execute-api.us-east-1.amazonaws.com/dev/random_joke", Joke.class);
        } catch (Exception e) {
            e.printStackTrace ();
        }
        return joke;
    }

}
