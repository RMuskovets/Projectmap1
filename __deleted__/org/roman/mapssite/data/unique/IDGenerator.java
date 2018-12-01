package org.roman.mapssite.data.unique;

import java.util.*;

public class IDGenerator {

    private static Map<Class, Integer> ids = new HashMap<>();

    private IDGenerator() {}

    public static int generateID(Class clazz) {
        int i = 0;
        if (ids.containsKey(clazz)) {
            i = ids.get(clazz);
            ids.put(clazz, i++);
        } else {
            ids.put(clazz, i++);
        }
        return i;
    }
}
