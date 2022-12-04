package controllers;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import models.Id;
import models.Message;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;


public class ServerController {
    private String rootURL = "http://zipcode.rocks:8085";

    private static ServerController svr = new ServerController();

    private ServerController() {}

    public static ServerController shared() {
        return svr;
    }

    public List<Id> idGet() throws IOException {
        // url -> /ids/
        // send the server a get with url
        // return json from server
        Gson gson = new Gson();
        List<Id> ids = new ArrayList<>();
        InputStream input = new URL(rootURL + "/ids").openStream();
        JsonReader reader = new JsonReader(new InputStreamReader(input, StandardCharsets.UTF_8));
        reader.beginArray();
        Id id = null;
        while (reader.hasNext()) {
            id = gson.fromJson(reader, Id.class);
            ids.add(id);
        }
        reader.close();
        return ids;
    }

    public String idPost(Id id) throws IOException {
        // url -> /ids/
        // create json from Id
        // request
        // reply
        // return json
        Gson gson = new Gson();
        URL url = new URL(rootURL+"/ids");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("POST");
        con.setRequestProperty("Content-Type", "application/json");
        con.setRequestProperty("Accept", "application/json");
        con.setDoOutput(true);

        try(OutputStream os = con.getOutputStream()){
            byte[] input = gson.toJson(id).getBytes();
            os.write(input, 0, input.length);
        }

        StringBuilder response;
        try(BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), StandardCharsets.UTF_8))){
            response = new StringBuilder();
            String responseLine = null;
            while ((responseLine = br.readLine()) != null){
                response.append(responseLine.trim());
            }
        }

        return response.toString();
    }

//    public String idPut(Id) {
//        // url -> /ids/
//    }

    public List<Message> messageGet() throws IOException {
        // url -> /ids/
        // send the server a get with url
        // return json from server
        Gson gson = new Gson();
        List<Message> messages = new ArrayList<>();
        InputStream input = new URL(rootURL + "/messages").openStream();
        JsonReader reader = new JsonReader(new InputStreamReader(input, StandardCharsets.UTF_8));
        reader.beginArray();
        Message message = null;
        while (reader.hasNext()) {
            message = gson.fromJson(reader, Message.class);
            messages.add(message);
        }
        reader.close();
        return messages;
    }

    public String messagePost(Message message) throws IOException {
        // url -> /ids/
        // create json from Id
        // request
        // reply
        // return json
        Gson gson = new Gson();
        URL url = new URL(rootURL+"/messages");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("POST");
        con.setRequestProperty("Content-Type", "application/json");
        con.setRequestProperty("Accept", "application/json");
        con.setDoOutput(true);

        try(OutputStream os = con.getOutputStream()){
            byte[] input = gson.toJson(message).getBytes();
            os.write(input, 0, input.length);
        }

        StringBuilder response;
        try(BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), StandardCharsets.UTF_8))){
            response = new StringBuilder();
            String responseLine = null;
            while ((responseLine = br.readLine()) != null){
                response.append(responseLine.trim());
            }
        }

        return response.toString();
    }


}

// ServerController.shared.doGet()