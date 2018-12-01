package org.roman.mapssite.data;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY) @Entity
public class Event implements DataClass {

    @Column @GeneratedValue
    private Integer ID;
    @Column
    private String name;
    @Column(name="chas_pochatok")
    private Date start;
    @Column(name="chas_kinec")
    private Date end;
    @Column @ManyToMany(targetEntity = User.class, cascade=CascadeType.REMOVE)
    private List<User> zaprosheni;

    public String getName() {
        return name;
    }

    public Event setName(String name) {
        this.name = name;
        return this;
    }

    public Date getStart() {
        return start;
    }

    public Event setStart(Date start) {
        this.start = start;
        return this;
    }

    public Date getEnd() {
        return end;
    }

    public Event setEnd(Date end) {
        this.end = end;
        return this;
    }

    public List<User> getZaprosheni() {
        return zaprosheni;
    }

    public Event setZaprosheni(List<User> zaprosheni) {
        this.zaprosheni = zaprosheni;
        return this;
    }

    private Event(String name, Date start, Date end, List<User> zaprosheni) {
        this.name = name;
        this.start = start;
        this.end = end;
        this.zaprosheni = zaprosheni;
    }

    private Event(String name, Date start, Date end) {
        this.name = name;
        this.start = start;
        this.end = end;
    }

    public Event() {
    }

    public static class Builder {

        private String name;

        public Builder(String name) {
            this.name = name;
        }
    }
}
