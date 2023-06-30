package com.company.ArenaFilm.repos;

import com.company.ArenaFilm.models.Films;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface FilmsRepo extends CrudRepository<Films, Long> {
    List<Films>findByYear(String year);
    List<Films>findByGenre(String genre);
}
