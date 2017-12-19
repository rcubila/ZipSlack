package com.slackhubb.zach.andrea.raul.hubslack.controller;

import com.slackhubb.zach.andrea.raul.hubslack.MessageService;
import com.slackhubb.zach.andrea.raul.hubslack.model.Message;
import com.slackhubb.zach.andrea.raul.hubslack.repository.MessageRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringJUnit4ClassRunner.class)
@WebMvcTest(value = MessageController.class, secure = false)
public class MessageControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    MessageService messageService;

    Message mockMessage = new Message("hey", (long) 1);
    String example = "{\"message\":\"hey\",\"messageID\":1,\"timestamp\":1,\"userId\":null}";


    @Test
    public void testFindAll() {
    }

    @Test
    public void create() throws Exception {
        Mockito.when(messageService.addMessage(Mockito.any(Message.class))).thenReturn(mockMessage);

        mockMvc.perform(MockMvcRequestBuilders
                .post("/chat/messages")
                .accept(MediaType.APPLICATION_JSON)
                .content(example)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());
    }

    @Test
    public void getMessage() throws Exception {

        Mockito.when(messageService.get(Mockito.anyLong())).thenReturn(mockMessage);

        mockMvc.perform(MockMvcRequestBuilders
                .get("/chat/messages/1")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(content().string(example));
    }

    @Test
    public void delete() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders
                .delete("/chat/messages/1")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void update() throws Exception {





    }


}