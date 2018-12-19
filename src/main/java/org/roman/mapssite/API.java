package org.roman.mapssite;

import org.roman.mapssite.data.*;
import org.roman.mapssite.server.Server;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class API {

    ////////////////// GET ALL ////////////////////

    private static Server server = Server.instance();

    @RequestMapping(path = "/api/user/all")
    public List<User> users() {
        return new ArrayList<>();
    }

    @RequestMapping(path = "/api/event/all")
    public List<Event> events() {
        return new ArrayList<>();
    }

    @RequestMapping(path = "/api/mark/all")
    public List<Mark> marks() {
        return new ArrayList<>();
    }

    ////////////////// GET BY ... /////////////////////

    @RequestMapping(path = "/api/user/byid")
    public String userById(@RequestParam(name = "id") String id) {
        return "";
    }


    private enum AJAX {
        ;

        public static final int INCORRECT_DATA_ERROR = 100;

        public static Map<String, Object> incorrectData(String kind) {
            Map<String, Object> mso = new HashMap<>();
            mso.put("response", INCORRECT_DATA_ERROR);
            mso.put("kind", kind);
            return mso;
        }
    }

}
