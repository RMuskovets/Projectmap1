package org.roman.mapssite.server;

public class Server {

    private static Server INSTANCE;

    private Server() {

    }

    public static Server instance() {
        if (INSTANCE == null) INSTANCE = new Server();
        return INSTANCE;
    }
}
