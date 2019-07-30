package org.roman.mapssite.data;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import org.roman.mapssite.data.json.DataClass;

import javax.persistence.*;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY) @Entity
public class Mark implements DataClass {

    @Column(name="ID", nullable=false) @GeneratedValue @Id
    private Integer id;
    //@Column(name="typeID", nullable=false)
    //private Integer type_id = -1;
    @Column(name="coordx", nullable=false)
    private double coord_x;
    @Column(name="coordy", nullable=false)
    private double coord_y;
    @Column
    private String name;
//    @Column(name="ownerID")
//    private Integer owner_id = -1;
    @OneToOne(targetEntity = User.class,cascade = CascadeType.REMOVE, optional=false)
    @JoinColumn(name = "owner_id", referencedColumnName = "id")
    private User owner;

    private Mark(Integer type_id, double coord_x, double coord_y, String name,
                User owner) {
        this.type_id = type_id;
        this.coord_x = coord_x;
        this.coord_y = coord_y;
        this.name = name;
        this.owner = owner;
    }

    private Mark(Integer type_id, double coord_x, double coord_y, String name) {
        this.type_id = type_id;
        this.coord_x = coord_x;
        this.coord_y = coord_y;
        this.name = name;
    }

    private Mark(double coord_x, double coord_y, String name) {
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

//    public Integer getOwner_id() {
//        return owner_id;
//    }
//
//    public vo setOwner_id(Integer owner_id) {
//        this.owner_id = owner_id;
//    }

    public Integer getId() {
        return id;
    }

    //public Integer getType_id() {
    //    return type_id;
    //}

    public static class Builder {

        //private Integer tid, o;
        private Integer tid;
        private User o;
        private String n;
        private double cx, cy;

        public Builder() { }

        public Builder(Integer tid, User o, String n, double cx, double cy) {
            this.tid = tid;
            this.o = o;
            this.n = n;
            this.cx = cx;
            this.cy = cy;
        }

        public Builder(Integer tid, User o, double cx, double cy) {
            this.tid = tid;
            this.o = o;
            this.cx = cx;
            this.cy = cy;
        }

        public Builder(Integer tid, User o, String n) {
            this.tid = tid;
            this.o = o;
            this.n = n;
        }

        public Builder(Integer tid, User o) {
            this.tid = tid;
            this.o = o;
        }

        public Builder setTid(Integer tid) {
            this.tid = tid;
            return this;
        }

        public Builder setOid(User o) {
            this.o = o;
            return this;
        }

        public Builder setN(String n) {
            this.n = n;
            return this;
        }

        public Builder setCx(double cx) {
            this.cx = cx;
            return this;
        }

        public Builder setCy(double cy) {
            this.cy = cy;
            return this;
        }

        public Mark build() {
            return new Mark(tid, cx, cy, n, o);
        }
    }
}
