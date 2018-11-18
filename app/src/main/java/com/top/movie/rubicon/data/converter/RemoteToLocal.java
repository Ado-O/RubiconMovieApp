package com.top.movie.rubicon.data.converter;

import com.top.movie.rubicon.data.Movie;
import com.top.movie.rubicon.data.Search;
import com.top.movie.rubicon.data.TvShow;
import com.top.movie.rubicon.data.TvShowSearch;
import com.top.movie.rubicon.data.storage.remote.response.movieresponse.MovieResponse;
import com.top.movie.rubicon.data.storage.remote.response.movieresponse.ShowMovieResponse;
import com.top.movie.rubicon.data.storage.remote.response.searchresponse.SearchResponse;
import com.top.movie.rubicon.data.storage.remote.response.searchresponse.TvShowSearchResponse;

import java.util.ArrayList;
import java.util.List;

public class RemoteToLocal {

    public static final String TAG = RemoteToLocal.class.getSimpleName();

    /*********
     * movie
     ********/
    public static List<Movie> movieConverter(List<MovieResponse> movieResponses) {

        List<Movie> movie = new ArrayList<>();

        for (MovieResponse m : movieResponses) {

            movie.add(
                    new Movie(
                            m.getOriginalTitle(),
                            m.getId(),
                            m.getOverview(),
                            m.getPosterPath()
                    )
            );
        }
        return movie;
    }

    /**********
     * tv show
     *********/
    public static List<TvShow> tvShowConverter(List<ShowMovieResponse> showMovieRespons) {

        List<TvShow> tvShows = new ArrayList<>();

        for (ShowMovieResponse m : showMovieRespons) {

            tvShows.add(
                    new TvShow(
                            m.getOriginalName(),
                            m.getId(),
                            m.getOverview(),
                            m.getPosterPath()
                    )
            );
        }
        return tvShows;
    }

    /**********
     * movie search
     *********/
    public static List<Movie> searchConverter(List<SearchResponse> searchResponses) {

        List<Movie> movies = new ArrayList<>();

        for (SearchResponse s : searchResponses) {

            movies.add(
                    new Movie(
                            s.getOriginalTitle(),
                            s.getId(),
                            s.getOverview(),
                            s.getPosterPath()
                    )
            );
        }
        return movies;
    }

    /****************
     * tvShow search
     ***************/
    public static List<TvShow> tvShowSearchConverter(List<TvShowSearchResponse> tvShowSearchResponses) {

        List<TvShow> tvShows = new ArrayList<>();

        for (TvShowSearchResponse s : tvShowSearchResponses) {

            tvShows.add(
                    new TvShow(
                            s.getOriginalName(),
                            s.getId(),
                            s.getOverview(),
                            s.getPosterPath()
                    )
            );
        }
        return tvShows;
    }

//    /****************
//     * description
//     ***************/
//    public static List<Description> descriptionConverter(DescriptionBaseResponse descriptionBaseResponse) {
//
//        List<Description> description = new ArrayList<>();
//
//            description.add(
//                    new Description(
//                            descriptionBaseResponse.getOriginalName(),
//                            descriptionBaseResponse.getOverview(),
//                            descriptionBaseResponse.getPosterPath()
//                    )
//            );
//
//        return description;
//    }
}
