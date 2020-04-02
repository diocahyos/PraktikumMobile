package com.example.webservice.View.ViewModel;

import com.example.webservice.Model.Movie.MovieDiscoverResponse;
import com.example.webservice.Model.Movie.MovieDiscoverResultsItem;
import com.example.webservice.Service.ApiMain;

import java.util.ArrayList;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MovieViewModel extends ViewModel {
    private ApiMain apiMain;

    private MutableLiveData<ArrayList<MovieDiscoverResultsItem>> listDiscoverMovie = new MutableLiveData<>();

    public void setMovieDiscover(){
        if(this.apiMain == null){
            apiMain = new ApiMain();
        }

        apiMain.getApiMovie().getMovieDiscover().enqueue(new Callback<MovieDiscoverResponse>() {
            @Override
            public void onResponse(Call<MovieDiscoverResponse> call, Response<MovieDiscoverResponse> response) {
                MovieDiscoverResponse responseDiscover = response.body();
                if (responseDiscover != null && responseDiscover.getResults() != null){
                    ArrayList<MovieDiscoverResultsItem> movieDiscoverItem = responseDiscover.getResults();
                    listDiscoverMovie.postValue(movieDiscoverItem);
                }
            }

            @Override
            public void onFailure(Call<MovieDiscoverResponse> call, Throwable t) {

            }
        });
    }

    public LiveData<ArrayList<MovieDiscoverResultsItem>> getMovieDiscover(){
        return listDiscoverMovie;
    }
}
