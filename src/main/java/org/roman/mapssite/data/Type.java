package org.roman.mapssite.data;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import org.roman.mapssite.data.json.DataClass;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY) @Entity
public class Type implements DataClass {


    @Column(name="ID", nullable = false) @GeneratedValue @Id
    private Integer id;
    @Column
    private String name;
    @Column(name="parentID", nullable = false)
    private Integer parent_id;

    private Type(String name, Integer parent_id) {
        this.name = name;
        this.parent_id = parent_id;
    }

    public Type() {}

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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getParent_id() {
        return parent_id;
    }

    public void setParent_id(Integer parent_id) {
        this.parent_id = parent_id;
    }

    public static class Builder {

        private int pid = -1;
        private String name;

        public Builder() {}

        public Builder setParentID(int pid) {
            this.pid = pid;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Type build() {
            return new Type(name, pid);
        }
    }
}
