package org.roman.mapssite.data.json;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.roman.mapssite.data.*;

import java.io.IOException;
import java.io.StringWriter;

public class Serializer {
    private static Serializer ourInstance = new Serializer();

    private ObjectMapper om;

    public static Serializer instance() {
        return ourInstance;
    }

    private Serializer() {
        om = new ObjectMapper();
    }

    public String serialize(DataClass t) {
        StringWriter sw = new StringWriter();
        try {
            om.writeValue(sw, t);
        } catch (IOException e) {
            return "{ \"error\": \"IOException\" }";
        }
        return sw.toString();
    }
}
