package com.top.movie.rubicon.data.converter;

import com.top.movie.rubicon.data.Movie;
import com.top.movie.rubicon.data.Show;
import com.top.movie.rubicon.data.storage.remote.response.response.MovieResponse;
import com.top.movie.rubicon.data.storage.remote.response.response.ShowMovieResponse;
import com.top.movie.rubicon.data.storage.remote.response.searchresponse.SearchResponse;
import com.top.movie.rubicon.data.storage.remote.response.searchresponse.showSearchResponse;

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
    public static List<Show> showConverter(List<ShowMovieResponse> showMovieRespons) {

        List<Show> shows = new ArrayList<>();

        for (ShowMovieResponse m : showMovieRespons) {

            shows.add(
                    new Show(
                            m.getOriginalName(),
                            m.getId(),
                            m.getOverview(),
                            m.getPosterPath()
                    )
            );
        }
        return shows;
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
    public static List<Show> showSearchConverter(List<showSearchResponse> showSearchRespons) {

        List<Show> shows = new ArrayList<>();

        for (showSearchResponse s : showSearchRespons) {

            shows.add(
                    new Show(
                            s.getOriginalName(),
                            s.getId(),
                            s.getOverview(),
                            s.getPosterPath()
                    )
            );
        }
        return shows;
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
