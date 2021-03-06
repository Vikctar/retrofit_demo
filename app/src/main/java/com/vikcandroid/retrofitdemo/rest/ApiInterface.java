package com.vikcandroid.retrofitdemo.rest;

import com.vikcandroid.retrofitdemo.model.MovieResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * The endpoints are defined inside of an interface using special retrofit annotations to encode details
 * about the parameters and request method.
 * In addition, the return value is always a parameterized Call<T> object such as Call<MovieResponse>.
 * For instance, the interface defines each endpoint in the following way.
 * <p/>
 * So, using this route the retrofit will generate the following
 * URL:http://api.themoviedb.org/3/movie/top_rated?api_key=12345678910111213
 * Each endpoint specifies an annotation of the HTTP method (GET, POST, etc.)
 * and the parameters of this method can also have special annotations (@Query, @Path, @Body etc.)
 *
 * @Path – variable substitution for the API endpoint. For example movie id will be swapped for{id} in the URL endpoint.
 * @Query – specifies the query key name with the value of the annotated parameter.
 * @Body – payload for the POST call
 * @Header – specifies the header with the value of the annotated parameter
 */
public interface ApiInterface {

    @GET("movie/top_rated")
    Call<MovieResponse> getTopRatedMovies(@Query("api_key") String apiKey);

    @GET("movie/{id}")
    Call<MovieResponse> getMovieDetail(@Path("id") int id, @Query("api_key") String apiKey);
}
