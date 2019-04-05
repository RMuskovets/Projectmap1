package org.roman.mapssite;

import org.roman.mapssite.data.Event;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(/*collectionResourceRel = "people", path = "people"*/path="Events")
public interface EventRepository extends PagingAndSortingRepository<Event, Integer> {

    List<Event> findByName(@Param("name") String name);
    //List<Event> findByType(@Param("type") Integer type);
    List<Event> findBetween(@Param("start") Date start, @Param("end") Date end);
}
