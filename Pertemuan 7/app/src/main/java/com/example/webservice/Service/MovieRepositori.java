package com.example.webservice.Service;

import com.example.webservice.Model.Movie.MovieDiscoverResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MovieRepositori {
    @GET("3/discover/movie?api_key=05faacecb1bb8a123ad56542b1708bad")
    Call<MovieDiscoverResponse> getMovieDiscover();
}
