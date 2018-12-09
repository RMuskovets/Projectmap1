package org.roman.mapssite.data;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import org.roman.mapssite.data.json.DataClass;

//import javax.persistence.*;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY) //@Entity
public class User implements DataClass {

    private static Integer CURRENT_ID = 0;

    //@Column
    private Integer ID = CURRENT_ID++;

    //@Column
    private String username;

    //@Column
    private String password; // SHA-256 encrypted

    //@Column
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
        return ID;
    }
}
