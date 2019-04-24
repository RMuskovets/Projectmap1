package org.roman.mapssite;

import org.roman.mapssite.data.User;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(/*collectionResourceRel = "people", path = "people"*/path="users")
public interface UserRepository extends PagingAndSortingRepository<User, Integer> {

    List<User> findByUsername(@Param("username") String username);
    List<User> findByType(@Param("type") Integer type);

}
