package org.roman.mapssite.data;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import org.roman.mapssite.data.json.DataClass;

import java.util.*;

//import javax.persistence.Entity;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY) //@Entity
public class Route implements DataClass {

    //private Integer id = IDGenerator.generateID(Route.class);

    private Integer id;

    private List<Mark> marks = new ArrayList<>();


    private Route(List<Mark> marks) {
        this.marks = marks;
    }

    public Route() {
    }

    public Integer getId() {
        return id;
    }

    public List<Mark> getMarks() {
        return marks;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setMarks(List<Mark> marks) {
        this.marks = marks;
    }

    public static class Builder {

        private List<Mark> marks = new ArrayList<>();
    }
}
