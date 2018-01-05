package com.ZipSlack.controller;


import com.ZipSlack.model.Emoji2;
import com.ZipSlack.service.Emoji2Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class Emoji2Controller {

    @Autowired
    Emoji2Service emoji2Service;

    @GetMapping("/emoji2")
    public ResponseEntity<Emoji2> getEmoji2(){

        Emoji2  emoji2 = emoji2Service.getEmoji2 ();


        return new ResponseEntity<>(emoji2,HttpStatus.ACCEPTED);
    }




}
