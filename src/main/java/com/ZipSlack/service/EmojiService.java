package com.ZipSlack.service;

import com.ZipSlack.model.Message;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class EmojiService {

    RestTemplate restTemplate;

    public EmojiService() {
        restTemplate = new RestTemplate();
    }

    public void saveEmoji(){
        String postUrl = "https://api.github.com/emojis";
        Message message = new Message();
        ResponseEntity<String> postResponse = restTemplate.postForEntity(postUrl, message, String.class);

    }


}
