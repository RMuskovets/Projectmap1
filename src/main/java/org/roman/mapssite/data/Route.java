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

        public Builder() { }
        public Builder(List<Mark> m) {marks = m;}

        public Builder addMark(Mark m) {
            marks.add(m);
            return this;
        }

        public Builder removeMark(Mark m) {
            marks.remove(m);
            return this;
        }

        public Builder removeMark(int i) {
            marks.remove(i);
            return this;
        }

        public Builder setMarks(List<Mark> m) {
            marks = m;
            return this;
        }

        public Route build() {
            return new Route(marks);
        }
    }
}
