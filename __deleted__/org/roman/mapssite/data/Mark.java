package org.roman.mapssite.data;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import javax.persistence.Column;
import javax.persistence.Entity;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY) @Entity
public class Mark implements DataClass {

    private static Integer CURRENT_ID = 0;

    @Column(name="ID", nullable=false)
    private final Integer id = CURRENT_ID++;
    @Column(name="typeID", nullable=false)
    private Integer type_id = -1;
    @Column(name="coordX", nullable=false)
    private double coord_x;
    @Column(name="coordY", nullable=false)
    private double coord_y;
    @Column
    private String name;
    @Column(name="ownerID")
    private Integer owner_id = -1;

    public Mark(Integer type_id, double coord_x, double coord_y, String name, Integer owner_id) {
        this.type_id = type_id;
        this.coord_x = coord_x;
        this.coord_y = coord_y;
        this.name = name;
        this.owner_id = owner_id;
    }

    public Mark(Integer type_id, double coord_x, double coord_y, String name) {
        this.type_id = type_id;
        this.coord_x = coord_x;
        this.coord_y = coord_y;
        this.name = name;
    }

    public Mark(double coord_x, double coord_y, String name) {
        this.coord_x = coord_x;
        this.coord_y = coord_y;
        this.name = name;
    }

    public Mark() {}

    public double getCoord_x() {
        return coord_x;
    }

    public void setCoord_x(double coord_x) {
        this.coord_x = coord_x;
    }

    public double getCoord_y() {
        return coord_y;
    }

    public void setCoord_y(double coord_y) {
        this.coord_y = coord_y;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getOwner_id() {
        return owner_id;
    }

    public void setOwner_id(Integer owner_id) {
        this.owner_id = owner_id;
    }

    public Integer getId() {
        return id;
    }

    public Integer getType_id() {
        return type_id;
    }
}
