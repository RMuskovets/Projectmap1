package org.roman.mapssite;

import org.roman.mapssite.server.Server;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class API {

    ////////////////// GET ALL ////////////////////

    private static Server server = Server.instance();

    @RequestMapping(path = "/api/user/all")
    public String users() {
        return "";
    }

    @RequestMapping(path = "/api/event/all")
    public String events() {
        return "";
    }

    @RequestMapping(path = "/api/lang/all")
    public String languages() {
        return "";
    }

    @RequestMapping(path = "/api/mark/all")
    public String marks() {
        return "";
    }

    ////////////////// GET BY ... /////////////////////

    @RequestMapping(path = "/api/user/byid")
    public String userById(@RequestParam(name = "id") String id) {
        return "";
    }
}
