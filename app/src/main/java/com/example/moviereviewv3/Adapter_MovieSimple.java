package com.example.moviereviewv3;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class Adapter_MovieSimple extends RecyclerView.Adapter <Adapter_MovieSimple.MovieSimpleViewHolder> implements ItemClickListener, Filterable {

    List<Model_Movie> allMovies;
    List<Model_Movie> filteredMovies;
    List<String> filteredMoviesNames= new ArrayList<>();
    private ItemClickListener clickListener;

    public Adapter_MovieSimple(List<Model_Movie> movies){
        this.allMovies = movies;
        this.filteredMovies=movies;
        for (Model_Movie movie:movies) {
            filteredMoviesNames.add(movie.getName());
        }
    }

    @NonNull
    @Override
    public MovieSimpleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_movie_simple, parent, false);
        MovieSimpleViewHolder movieSimpleViewHolder = new MovieSimpleViewHolder(view);
        return movieSimpleViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MovieSimpleViewHolder holder, int position) {

        Model_Movie movie = allMovies.get(position);
        holder.img.setImageResource(movie.getImage());
        holder.name.setText(movie.getName());
        holder.year.setText(movie.getYear());
        holder.rating.setText(Float.toString(movie.getRating()));
    }
    Filter filter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence charSequence) {
            List<String> fileteredList= new ArrayList<>();
            if(charSequence.toString().isEmpty()){
                fileteredList.addAll(filteredMoviesNames);
            }else{
                for(String movie:filteredMoviesNames){
                    movie.toLowerCase().contains(charSequence.toString().toLowerCase());
                    fileteredList.add(movie);
                }
            }


            FilterResults filterResults = new FilterResults();
            filterResults.values=fileteredList;
            return filterResults;
        }


        @Override
        protected void publishResults(CharSequence charSequence, FilterResults filterResults) {

            filteredMovies.clear();
            filteredMovies.add((Model_Movie) filterResults.values);
            notifyDataSetChanged();
        }
    };

    @Override
    public int getItemCount() {
        return allMovies.size();
    }

    public void setClickListener(ItemClickListener itemClickListener) {
        this.clickListener = itemClickListener;
    }

    @Override
    public void onClick(View view, int position) {

    }

    @Override
    public Filter getFilter() {
        return filter;
    }


    public class MovieSimpleViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        ImageView img;
        TextView name;
        TextView year;
        TextView rating;


        public MovieSimpleViewHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.simple_list_movie_image);
            name = itemView.findViewById(R.id.simple_list_movie_name);
            year = itemView.findViewById(R.id.simple_list_movie_year);
            rating = itemView.findViewById(R.id.simple_list_movie_rating);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (clickListener != null) clickListener.onClick(view, getAdapterPosition());
        }
    }

}

