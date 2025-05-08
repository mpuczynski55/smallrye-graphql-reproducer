package com.example;

import com.example.model.Movie;
import jakarta.enterprise.context.ApplicationScoped;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class MovieService {

    private final List<Movie> movies = new ArrayList<>();

    public MovieService() {
        Movie aNewHope = new Movie();
        aNewHope.title = "A New Hope";
        aNewHope.releaseDate = LocalDate.of(1977, Month.MAY, 25);
        aNewHope.episodeID = 4;
        aNewHope.director = "George Lucas";

        Movie theEmpireStrikesBack = new Movie();
        theEmpireStrikesBack.title = "The Empire Strikes Back";
        theEmpireStrikesBack.releaseDate = LocalDate.of(1980, Month.MAY, 21);
        theEmpireStrikesBack.episodeID = 5;
        theEmpireStrikesBack.director = "George Lucas";

        Movie returnOfTheJedi = new Movie();
        returnOfTheJedi.title = "Return Of The Jedi";
        returnOfTheJedi.releaseDate = LocalDate.of(1983, Month.MAY, 25);
        returnOfTheJedi.episodeID = 6;
        returnOfTheJedi.director = "George Lucas";

        movies.add(aNewHope);
        movies.add(theEmpireStrikesBack);
        movies.add(returnOfTheJedi);
    }

    public List<Movie> getAllFilms() {
        return movies;
    }

}