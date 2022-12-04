package controllers;

import models.Id;
import models.Message;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class ServerControllerTest {


    @Test
    public void idGetTest() throws IOException {
        System.out.println(ServerController.shared().idGet().toString());

    }

    @Test
    public void idPostTest() throws IOException {
        Id id = new Id("Emory", "Emory-Miller");
        System.out.println(ServerController.shared().idPost(id));
    }

    @Test
    public void idMessagesTest() throws IOException {
        System.out.println(ServerController.shared().messageGet().toString());

    }

    @Test
    public void messagePostTest() throws IOException {
        Message message = new Message("Just testing this out.... from a test class", "Emory-Miller");
        System.out.println(ServerController.shared().messagePost(message));
    }

}