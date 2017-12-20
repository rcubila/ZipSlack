package com.ZipSlack.service;

import com.ZipSlack.model.Message;
import com.ZipSlack.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {
    @Autowired
    MessageRepository messageRepository;


    public List <Message> getAll() {
        return messageRepository.findAll();
    }

    public Message addMessage(Message newmessage){
        messageRepository.save(newmessage);
        return newmessage;
    }
    public Message get(Long id){
        return messageRepository.findOne(id);
    }

    public void delete(Long id){
        messageRepository.delete(id);
    }

    public void update(Long id,String newmessage){
        messageRepository.findOne(id).setMessage(newmessage);
    }
}