package org.roman.mapssite.data.json;

import org.junit.Test;
import org.roman.mapssite.data.DataClass;
import org.roman.mapssite.data.Mark;
import org.roman.mapssite.data.Type;

public class SerializerTest {

    @Test
    public void testSerializeTypes() {
        Serializer s = Serializer.instance();
        Type t = new Type("test"), t1 = new Type("test", 15);
        System.out.println(s.serialize(t));
        System.out.println(s.serialize(t1));
    }

    @Test
    public void testSerializeMarks() {
        Serializer s = Serializer.instance();
        Mark m = new Mark(15, 15, "Mark 1");
        System.out.println(s.serialize(m));
        m = new Mark(15, 150, "Mark 1");
        m.setOwner_id(1);
        System.out.println(s.serialize(m));
    }

    @Test
    public void testSerializeDataClass() {
        Serializer s = Serializer.instance();
        System.out.println(s.serialize(new DataClass() {}));
    }
}
