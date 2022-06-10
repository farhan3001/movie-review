package com.example.moviereviewv3;

import android.app.Activity;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class Fragment_Home extends Fragment implements ItemClickListener{

    ImageView home_poster;
    TextView home_movie_name;
    TextView home_movie_year;
    Toolbar toolbar;
    RecyclerView moviesRecyclerView;
    VideoView videoView;

    Adapter_Cast castAdapter;
    Adapter_MovieHorizontal movieAdapter;
    List<Model_Actor> actors;
    List<Model_Movie> movies;
    List<Model_Movie> allMovies;
    SQLiteHelper helper;
    Model_Movie movie=new Model_Movie();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable
            ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        toolbar=view.findViewById(R.id.home_toolbar);
        AppCompatActivity activity = (AppCompatActivity) getActivity();
        activity.setSupportActionBar(toolbar);

        movie=getRandomMovie();

        home_poster=view.findViewById(R.id.home_trailer_poster);
        home_movie_name=view.findViewById(R.id.home_movie_name);
        home_movie_year=view.findViewById(R.id.home_movie_year);

        home_poster.setImageResource(movie.getImage());
        home_movie_name.setText(movie.getName());
        home_movie_year.setText(movie.getYear());

        videoView=view.findViewById(R.id.home_trailer_player);
        String trailer_path= movie.getTrailer();
        Uri uri = Uri.parse(trailer_path);
        videoView.setVideoURI(uri);
        MediaController mediaController = new MediaController(getContext());
        videoView.setMediaController(mediaController);
        mediaController.setAnchorView(videoView);
        videoView.start();

        RecyclerView castRecyclerView =view.findViewById(R.id.home_cast_recycler_view);

        actors= new ArrayList<>();

        Model_Actor actor1 = new Model_Actor(getDrawableId("actor_idris_elba"),
                42, "November 29,2021", "Idris Elba", "Actor", "Suicide Squad", "Idrissa Akuna Elba OBE is an English actor, producer and musician. He is known for roles including Stringer Bell in the HBO series The Wire, DCI John Luther in the BBC One series Luther, and Nelson Mandela in the biographical film Mandela: Long Walk to Freedom.");

        actors.add(actor1);

        castAdapter = new Adapter_Cast(actors);
        castAdapter.setClickListener(new ItemClickListener() {
            @Override
            public void onClick(View view, int position) {
                Bundle bundle = new Bundle();
                bundle.putSerializable("actor_object",actors.get(position));
                Fragment fragment = new Fragment_ActorProfile();
                fragment.setArguments(bundle);
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.home_fragment_container,fragment).addToBackStack(null).commit();
            }
        });
        castRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false));
        castRecyclerView.setAdapter(castAdapter);

        moviesRecyclerView =view.findViewById(R.id.home_movies_recycler_view);
        allMovies=helper.readAllMovies();
        movies= allMovies;
        movieAdapter=new Adapter_MovieHorizontal(allMovies);
        movieAdapter.setClickListener(this);
        moviesRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false));
        moviesRecyclerView.setAdapter(movieAdapter);
        return view;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public Model_Movie getRandomMovie(){
        Random random = new Random();
        return helper.readMovieById(random.ints(1,15).findAny().getAsInt());
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.home_navbar_menu,menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId())
        {
            case R.id.home_nav_sort_rating:
            {
                sortByRating(allMovies);
                return true;
            }
            case R.id.home_nav_sort_date:
            {
                sortByYear(allMovies);
                return true;
            }

            default:
            {
                return super.onOptionsItemSelected(item);
            }
        }
    }
    @Override
    public void onClick(View view, int position) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("movie_object",movies.get(position));
        Fragment fragment = new Fragment_MovieProfile();
        fragment.setArguments(bundle);
        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.home_fragment_container,fragment).addToBackStack(null).commit();
    }

    public void sortByRating(List<Model_Movie> moviesList){
        movies=moviesList;
        Collections.sort(movies, new Comparator<Model_Movie>() {
            @Override
            public int compare(Model_Movie movie, Model_Movie t1) {
                return Math.round(t1.getRating()*10 - Math.round(movie.getRating()*10));
            }
        });
        movieAdapter=new Adapter_MovieHorizontal(movies);
        movieAdapter.setClickListener(this);
        moviesRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false));
        moviesRecyclerView.setAdapter(movieAdapter);
    }

    public void sortByYear(List<Model_Movie> movieList){
        movies=movieList;
        Collections.sort(movies, new Comparator<Model_Movie>() {
            @Override
            public int compare(Model_Movie movie, Model_Movie t1) {
                return  Integer.parseInt(t1.getYear()) - Integer.parseInt(movie.getYear());
            }
        });
        movieAdapter=new Adapter_MovieHorizontal(movies);
        movieAdapter.setClickListener(this);
        moviesRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false));
        moviesRecyclerView.setAdapter(movieAdapter);
    }



    public int getDrawableId(String name)
    {
        return getContext().getResources().getIdentifier(name, "drawable", getContext().getPackageName());
    }
    @Override
    public void onAttach(@NonNull Activity activity) {
        super.onAttach(activity);
        helper=new SQLiteHelper(activity);
    }
}
