package com.vikcandroid.retrofitdemo.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.vikcandroid.retrofitdemo.R;
import com.vikcandroid.retrofitdemo.adapter.MoviesAdapter;
import com.vikcandroid.retrofitdemo.model.Movie;
import com.vikcandroid.retrofitdemo.model.MovieResponse;
import com.vikcandroid.retrofitdemo.rest.ApiClient;
import com.vikcandroid.retrofitdemo.rest.ApiInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private static final String API_KEY = "52e1d2bd9f3c80de7894de9939545286";
    public final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (API_KEY.isEmpty()) {
            Toast.makeText(getApplicationContext(), "Please obtain an API key from" +
                    "www.themoviedb.org/", Toast.LENGTH_LONG).show();
        }

        final RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);

        Call<MovieResponse> call = apiInterface.getTopRatedMovies(API_KEY);
        call.enqueue(new Callback<MovieResponse>() {
            @Override
            public void onResponse(Call<MovieResponse> call, Response<MovieResponse> response) {
                List<Movie> movieList = response.body().getResults();
                Log.d(TAG, "number of movies received: " + movieList.size());
                recyclerView.setAdapter(new MoviesAdapter(movieList,
                        R.layout.list_item, getApplicationContext()));
            }

            @Override
            public void onFailure(Call<MovieResponse> call, Throwable t) {
                Log.d(TAG, t.toString());
            }
        });
    }
}
