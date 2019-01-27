package org.roman.mapssite;

import org.roman.mapssite.data.Route;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.Repository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "people", path = "people")
public interface RouteRepository extends PagingAndSortingRepository<Route, Integer> {
}
