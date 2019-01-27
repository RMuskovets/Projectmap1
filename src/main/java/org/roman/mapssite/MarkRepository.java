package org.roman.mapssite;

import org.roman.mapssite.data.Mark;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.Repository;

public interface MarkRepository extends PagingAndSortingRepository<Mark, Integer> {
}
