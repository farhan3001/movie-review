package com.example.moviereviewv3;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Fragment_Search extends Fragment implements ItemClickListener,AdapterView.OnItemSelectedListener {

    SQLiteHelper helper;
    Adapter_Movie movieAdapter;
    List<Model_Movie> movies;
    List<Model_Movie> allMovies;
    RecyclerView recyclerView;
    Toolbar toolbar;
    Spinner spinner;

    @Override
    public void onAttach(@NonNull Activity activity) {
        super.onAttach(activity);
        helper= new SQLiteHelper(activity);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable
            ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_search, container, false);

        toolbar=view.findViewById(R.id.search_toolbar);
        AppCompatActivity activity = (AppCompatActivity) getActivity();
        activity.setSupportActionBar(toolbar);

        recyclerView=view.findViewById(R.id.search_movies_recycler_view);

        allMovies=helper.readAllMovies();
        movies = allMovies;
        movieAdapter=new Adapter_Movie(movies);
        movieAdapter.setClickListener(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));
        recyclerView.setAdapter(movieAdapter);
        return view;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }
    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.search_bar_menu,menu);
        MenuItem menuItem = menu.findItem(R.id.search_option);
        SearchView searchView = (SearchView) menuItem.getActionView();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                movieAdapter.getFilter().filter(newText);
                return false;
            }
        });
        super.onCreateOptionsMenu(menu, inflater);
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View view, int position) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("movie_object", movies.get(position));
        Fragment fragment = new Fragment_MovieProfile();
        fragment.setArguments(bundle);
        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.home_fragment_container,fragment).addToBackStack(null).commit();
    }




    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    public void sortByRating(List<Model_Movie> moviesList){
        movies=moviesList;
        Collections.sort(movies, new Comparator<Model_Movie>() {
            @Override
            public int compare(Model_Movie movie, Model_Movie t1) {
                return Math.round(t1.getRating()*10 - Math.round(movie.getRating()*10));
            }
        });
        movieAdapter=new Adapter_Movie(movies);
        movieAdapter.setClickListener(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));
        recyclerView.setAdapter(movieAdapter);
    }
    public void sortByYear(List<Model_Movie> movieList){
        movies=movieList;
        Collections.sort(movies, new Comparator<Model_Movie>() {
            @Override
            public int compare(Model_Movie movie, Model_Movie t1) {
                return  Integer.parseInt(t1.getYear()) - Integer.parseInt(movie.getYear());
            }
        });
        movieAdapter=new Adapter_Movie(movies);
        movieAdapter.setClickListener(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));
        recyclerView.setAdapter(movieAdapter);
    }
    void sortByGenre(List<Model_Movie> movieList, String genre){
        List<Model_Movie> movies2= new ArrayList<>();
        for(int i=0;i<movieList.size();i++){
            if(movieList.get(i).getGenre().contains(genre)){
                movies2.add(movieList.get(i));
            }
        }
        movies=movies2;
        movieAdapter=new Adapter_Movie(movies);
        movieAdapter.setClickListener(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));
        recyclerView.setAdapter(movieAdapter);
    }


}