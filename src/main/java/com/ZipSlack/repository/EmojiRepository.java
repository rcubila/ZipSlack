package com.ZipSlack.repository;

import java.util.HashMap;
import java.util.Map;

public class EmojiRepository {

    Map<Integer, String> emojisDAo = new HashMap<>();

    public String getEmjojiById(int id){

        for(int i = 0; i < emojisDAo.size();i++){
            return emojisDAo.get(i);
        }
        return null;
    }
}
