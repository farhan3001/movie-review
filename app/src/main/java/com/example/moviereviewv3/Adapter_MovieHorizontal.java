package com.example.moviereviewv3;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Adapter_MovieHorizontal extends RecyclerView.Adapter <Adapter_MovieHorizontal.MovieHorizontalViewHolder> implements ItemClickListener {

    List<Model_Movie> movies;
    private ItemClickListener clickListener;
    public Adapter_MovieHorizontal(List<Model_Movie> movies){
        this.movies = movies;
    }

    @NonNull
    @Override
    public MovieHorizontalViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_movies_horizontal, parent, false);
        MovieHorizontalViewHolder MovieHorizontalViewHolder = new MovieHorizontalViewHolder(view);
        return MovieHorizontalViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MovieHorizontalViewHolder holder, int position) {

        Model_Movie movie = movies.get(position);
        holder.img.setImageResource(movie.getImage());
        holder.name.setText(movie.getName());
        holder.year.setText(movie.getYear());
        holder.rating.setText(Float.toString(movie.getRating()));
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    public void setClickListener(ItemClickListener itemClickListener) {
        this.clickListener = itemClickListener;
    }

    @Override
    public void onClick(View view, int position) {

    }

    public class MovieHorizontalViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        ImageView img;
        TextView name;
        TextView year;
        TextView rating;

        public MovieHorizontalViewHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.movie_card_image);
            name = itemView.findViewById(R.id.movie_card_name);
            year = itemView.findViewById(R.id.movie_card_year);
            rating = itemView.findViewById(R.id.movie_card_rating);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (clickListener != null) clickListener.onClick(view, getAdapterPosition());
        }
    }
}

