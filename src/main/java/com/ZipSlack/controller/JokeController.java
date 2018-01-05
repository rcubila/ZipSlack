package com.ZipSlack.controller;


import com.ZipSlack.model.Joke;
import com.ZipSlack.service.JokeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/joke")
@CrossOrigin()
public class JokeController {


    @Autowired
    JokeService jokeService;

    @GetMapping
    public ResponseEntity<Joke> getJoke() {

        Joke joke = new Joke ();
        joke = this.jokeService.getJoke (joke);
        return new ResponseEntity<Joke> (joke, HttpStatus.OK);
    }


}
