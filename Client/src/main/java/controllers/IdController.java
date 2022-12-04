package controllers;

import models.Id;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import static controllers.ServerController.shared;

public class IdController {

    private HashMap<String, Id> allIds;

    Id myId;

    public ArrayList<Id> getIds() throws IOException {
        return (ArrayList<Id>) shared().idGet();
    }

    public Id postId(Id id) {
        // create json from id
        // call server, get json result Or error
        // result json to Id obj


        return null;
    }

    public Id putId(Id id) {
        return null;
    }
 
}