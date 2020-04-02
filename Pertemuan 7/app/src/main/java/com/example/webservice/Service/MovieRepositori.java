package com.example.webservice.Service;

import com.example.webservice.Model.Movie.MovieDiscoverResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MovieRepositori {
    @GET("3/discover/movie?api_key=86bab8bf4d4758570d2d997c8ea34ac8")
    Call<MovieDiscoverResponse> getMovieDiscover();
}
