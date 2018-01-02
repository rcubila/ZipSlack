package com.ZipSlack.model;

import org.apache.el.lang.ELSupport;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Emoji {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long emojiId;
    private String emoji;
    private ELSupport unicode;

    public Emoji() {}

    public Emoji(Long emojiId) {
        this.emojiId = emojiId;
    }

    public Emoji(Long emojiId, String emoji) {
        this.emojiId = emojiId;
        this.emoji = emoji;
    }

    public Long getEmojiId() {
        return emojiId;
    }

    public void setEmojiId(Long emojiId) {
        this.emojiId = emojiId;
    }

    public String getEmoji() {
        return emoji;
    }

    public void setEmoji(String emoji) {
        this.emoji = emoji;
    }

    public ELSupport getUnicode() {
        return unicode;
    }
}
