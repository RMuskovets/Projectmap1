package org.roman.mapssite.data;

import com.fasterxml.jackson.annotation.*;
import org.roman.mapssite.data.json.DataClass;

import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Entity;
import java.util.Date;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY) @Entity
public class User implements DataClass {


    @Column @Id @GeneratedValue 
    private Integer id;

    @Column
    private String username;

    @Column //@JsonIgnore
    private String password; // SHA-256 encrypted

    @OneToOne(cascade=CascadeType.REMOVE)
    @JoinColumn(name="type", referencedColumnName="id")
    private Type type;

    //region Telemetry data
        @Column
        private String email;
        @Column
        private String firstName;
        @Column
        private String lastName;
        @Column
        private Date birthDate;
        @Column
        private String phoneNumber;

    //endregion

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Integer getId() {
        return id;
    }


    public User(String username, String password, Integer type, String email, String firstName, String lastName, Date birthDate, String phoneNumber) {
        this.username = username;
        this.password = password;
        this.type = type;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.phoneNumber = phoneNumber;
    }

    public Integer getId() {
        return id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    public static class Builder {

        private static void initAll(Builder b) {
            b.n = b.p = b.e = b.fn = b.ln = b.pn = "";
            b.t = 0;
            b.bd = new Date();
        }

        private String n = "", p = "";
        private Integer t;
        private String e, fn, ln, pn;
        private Date bd;

        public Builder(String n, String p, Integer t, String e, String fn, String ln, String pn, Date bd) {
            initAll(this);
            this.n = n;
            this.p = p;
            this.t = t;
            this.e = e;
            this.fn = fn;
            this.ln = ln;
            this.pn = pn;
            this.bd = bd;
        }

        public Builder(String n, String p, Integer t, String e, String fn, String ln, Date bd) {initAll(this);
            this.n = n;
            this.p = p;
            this.t = t;
            this.e = e;
            this.fn = fn;
            this.ln = ln;
            this.bd = bd;
        }

        public Builder(String n, String p, Integer t, String e, String fn, String ln) {initAll(this);
            this.n = n;
            this.p = p;
            this.t = t;
            this.e = e;
            this.fn = fn;
            this.ln = ln;
        }

        public Builder(String n, String p, Integer t) {initAll(this);
            this.n = n;
            this.p = p;
            this.t = t;
        }

        public Builder(String n, String p) {initAll(this);
            this.n = n;
            this.p = p;
        }

        public Builder() {
            initAll(this);
        }

        public Builder setName(String n) {
            this.n = n;
            return this;
        }

        public Builder setPassword(String p) {
            this.p = p;
            return this;
        }

        public Builder setType(Integer t) {
            this.t = t;
            return this;
        }

        public Builder setEmail(String e) {
            this.e = e;
            return this;
        }

        public Builder setFirstname(String fn) {
            this.fn = fn;
            return this;
        }

        public Builder setLastname(String ln) {
            this.ln = ln;
            return this;
        }

        public Builder setPhoneNumber(String pn) {
            this.pn = pn;
            return this;
        }

        public Builder setBirthDate(Date bd) {
            this.bd = bd;
            return this;
        }

        public User build() {
            return new User(n, p, t, e, fn, ln, bd, pn);
        }
    }
}
