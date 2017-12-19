package com.slackhubb.zach.andrea.raul.hubslack.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long messageID;
    private String message;
    private Long timestamp;
    private Long userId;

    public Message() {
        this.messageID = new Date().getTime();
        this.timestamp = new Date().getTime();
    }

    public Message(String message, Long messageID) {
        this.messageID = messageID;
        this.message = message;
        this.userId = userId;
        this.timestamp = messageID;
    }

    public Message(String message) {
        this.messageID = new Date().getTime();
        this.message = message;
        this.userId = userId;
        this.timestamp = new Date().getTime();
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Long getMessageID() {
        return messageID;
    }

    public void setMessageID(Long messageID) {
        this.messageID = messageID;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

}
