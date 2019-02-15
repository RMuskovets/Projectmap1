package org.roman.mapssite.data;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import org.roman.mapssite.data.json.DataClass;

import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Entity;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY) @Entity
public class User implements DataClass {


    @Column @Id @GeneratedValue
    private Integer id;

    @Column
    private String username;

    @Column
    private String password; // SHA-256 encrypted

    @Column
    private Integer type;

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

    public User(String username, String password, Integer type) {
        this.username = username;
        this.password = password;
        this.type = type;
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User() {
    }

    public Integer getID() {
        return id;
    }

    public static class Builder {
        private String n, p;
        private Integer t;

        public Builder(String n, String p, Integer t) {
            this.n = n;
            this.p = p;
            this.t = t;
        }

        public Builder(String n, String p) {
            this.n = n;
            this.p = p;
        }

        public Builder() {
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

        public User build() {
            return new User(n, p, t);
        }
    }
}
