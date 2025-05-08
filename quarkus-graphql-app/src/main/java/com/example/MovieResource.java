package com.example;

import com.example.model.Movie;
import jakarta.inject.Inject;
import org.eclipse.microprofile.graphql.GraphQLApi;
import org.eclipse.microprofile.graphql.Name;
import org.eclipse.microprofile.graphql.Query;

import java.util.List;

@GraphQLApi
public class MovieResource {

    @Inject
    MovieService movieService;

    @Query("allFilms")
    public List<Movie> getMovies(@Name("paginationParams")  PaginationParams paginationParams) {
        return movieService.getAllFilms();
    }

}