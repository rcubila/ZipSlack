package com.slackhubb.zach.andrea.raul.hubslack.controller;

import com.slackhubb.zach.andrea.raul.hubslack.service.MessageService;
import com.slackhubb.zach.andrea.raul.hubslack.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.logging.Logger;

@RestController
@RequestMapping("/chat/messages")
@CrossOrigin(origins = "http://localhost:4200")
public class MessageController {

    Logger logger = Logger.getGlobal();

    @Autowired
    MessageService messageService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity list(){
        return new ResponseEntity(messageService.getAll(),HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity create(@RequestBody Message message){
        logger.info("create from controller");
        messageService.addMessage(message);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(message.getMessageID())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public ResponseEntity getMessage(@PathVariable Long id){

        Message message = messageService.get(id);
        if(message == null){
            return new ResponseEntity("Not Found",HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity(messageService.get(id),HttpStatus.OK);

    }

    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public ResponseEntity delete(@PathVariable Long id){
        messageService.delete(id);
        return new ResponseEntity(id,HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.PUT)
    public ResponseEntity update(@PathVariable Long id, @RequestBody String msg){

        Message existingMessage = messageService.get(id);

        if(existingMessage == null){
            return new ResponseEntity("Not Found",HttpStatus.NOT_FOUND);
        }
        messageService.update(id,msg);
        return new ResponseEntity(id,HttpStatus.OK);
    }

}
