package com.vikcandroid.retrofitdemo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.vikcandroid.retrofitdemo.R;
import com.vikcandroid.retrofitdemo.model.Movie;

import java.util.List;

/**
 * Adapter is a common pattern which helps to bind view and data.
 *
 */
public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.MovieViewHolder> {
    private List<Movie> movieList;
    private int rowLayout;
    private Context context;

    @Override
    public MovieViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(rowLayout, parent, false);
        return new MovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MovieViewHolder holder, int position) {
        holder.movieTitle.setText(movieList.get(position).getTitle());
        holder.data.setText(movieList.get(position).getReleaseDate());
        holder.movieDescription.setText(movieList.get(position).getOverview());
        holder.rating.setText(movieList.get(position).getVoteAverage().toString());
    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }

    public static class MovieViewHolder extends RecyclerView.ViewHolder {
        LinearLayout moviesLayout;
        TextView movieTitle;
        TextView data;
        TextView movieDescription;
        TextView rating;

        public MovieViewHolder(View itemView) {
            super(itemView);
            moviesLayout = (LinearLayout) itemView.findViewById(R.id.movies_layout);
            movieTitle = (TextView) itemView.findViewById(R.id.title);
            data = (TextView) itemView.findViewById(R.id.subtitle);
            movieDescription = (TextView) itemView.findViewById(R.id.description);
            rating = (TextView) itemView.findViewById(R.id.rating);
        }
    }

    public MoviesAdapter(List<Movie> movieList, int rowLayout, Context context) {
        this.movieList = movieList;
        this.rowLayout = rowLayout;
        this.context = context;
    }
}
