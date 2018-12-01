package org.roman.mapssite.data;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import org.roman.mapssite.data.unique.IDGenerator;

import javax.persistence.Entity;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY) @Entity
public class Route implements DataClass {

    private Integer id = IDGenerator.generateID(Route.class);


}
