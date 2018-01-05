package com.ZipSlack.service;


import com.ZipSlack.model.Emoji2;
import com.ZipSlack.model.Joke;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Service
public class Emoji2Service {


    public Emoji2 getEmoji2() {
        Emoji2 emoji2ndVersion = new Emoji2 ();
        try {
            RestTemplate restTemplate = new RestTemplate ();

           String emoji2 = restTemplate.getForObject (
                   "https://raw.githubusercontent.com/shanraisshan/EmojiCodeSheet/master/json/string/Activity.json", String.class);
            System.out.println (emoji2);
            JSONObject jsonpObject = new JSONObject(emoji2);
            JSONObject activity = jsonpObject.getJSONObject ("activities");
            System.out.println (activity);
            JSONArray activityArray = activity.getJSONArray ("activity");
            System.out.println (activityArray);
            Map<String,String> map = new HashMap<> ();
            for(int i =0;i<activityArray.length ();i++){

                JSONObject jsonObject = activityArray.getJSONObject (i);

                for(int j=0;j<jsonObject.length ();j++){
                    map.put((String) jsonObject.get ("key"), jsonObject.getString ("value") ); }
            }
            emoji2ndVersion.setEmojiMap (map);
            return emoji2ndVersion;

        } catch (Exception e) {
            e.printStackTrace ();
        }
        return null;
    }

}
