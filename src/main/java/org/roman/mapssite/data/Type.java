package org.roman.mapssite.data;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import org.roman.mapssite.data.json.DataClass;

//import javax.persistence.Column;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class Type implements DataClass {

    private static Integer CURRENT_ID = 0;

    //@Column(name="ID", columnDefinition = "NOT NULL AUTO_INCREMENT PRIMARY KEY",
    //        nullable = false)
    private final Integer id = CURRENT_ID++;
    //@Column
    private String name;
    //@Column(name="parentID", nullable = false)
    private Integer parent_id;

    public Type(String name, Integer parent_id) {
        this.name = name;
        this.parent_id = parent_id;
    }

    public Type(String name) {
        this(name, -1);
    }

    public Integer getID() {
        return id;
    }

    public Integer getParentID() {
        return parent_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
