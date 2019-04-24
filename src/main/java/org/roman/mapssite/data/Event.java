package org.roman.mapssite.data;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import org.roman.mapssite.data.json.DataClass;

import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Entity;
import javax.persistence.CascadeType;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY) @Entity
public class Event implements DataClass {

    @Column @GeneratedValue @Id
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

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public List<User> getZaprosheni() {
        return zaprosheni;
    }

    public Event setZaprosheni(List<User> zaprosheni) {
        this.zaprosheni = zaprosheni;
        return this;
    }

    public Integer getID() {
        return ID;
    }

    private Event(String name, Date start, Date end, List<User> zaprosheni) {
        this.name = name;
        this.start = start;
        this.end = end;
        this.zaprosheni = zaprosheni;
    }

    public Event() {
    }

    public static class Builder {

        private String name;
        private List<User> zapr = new ArrayList<>();
        private Date start, end;

        public Builder(String name) {
            this.name = name;
        }

        public Builder(String name, List<User> zapr, Date start, Date end) {
            this.name = name;
            this.zapr = zapr;
            this.start = start;
            this.end = end;
        }

        public Builder(String name, Date start, Date end) {
            this.name = name;
            this.start = start;
            this.end = end;
        }

        public Builder() {
        }

        public Builder addInvited(User i) {
            zapr.add(i);
            return this;
        }

        public Builder setName(String n) {
            name = n;
            return this;
        }

        public Builder setStartDate(Date d) {
            start = d;
            return this;
        }

        public Builder setEndDate(Date d) {
            end = d;
            return this;
        }

        public Event build() {
            return new Event(name, start, end, zapr);
        }
    }
}
